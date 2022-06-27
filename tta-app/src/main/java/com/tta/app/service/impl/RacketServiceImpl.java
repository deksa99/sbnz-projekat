package com.tta.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tta.app.exceptions.EntityNotFoundException;
import com.tta.app.exceptions.HistoryException;
import com.tta.app.model.User;
import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;
import com.tta.app.model.enums.Playstyle;
import com.tta.app.model.enums.RacketRecommendation;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.NewRacketRecommendation;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.model.racket.Rubber;
import com.tta.app.repository.BladeRepository;
import com.tta.app.repository.RubberRepository;
import com.tta.app.repository.UserRepository;
import com.tta.app.service.KieService;
import com.tta.app.service.RacketService;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RacketServiceImpl implements RacketService {
	
	private final BladeRepository bladeRepository;
	private final RubberRepository rubberRepository;
	private final UserRepository userRepository;
	private final KieService kieService;
	
	@Autowired
	public RacketServiceImpl(KieService kieService, BladeRepository bladeRepository, 
			RubberRepository rubberRepository, UserRepository userRepository) {
		super();
		this.kieService = kieService;
		this.bladeRepository = bladeRepository;
		this.rubberRepository = rubberRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Racket getRecommendation(RacketForm form) {
		RacketParams rp = new RacketParams();
		rp.setFormId(form.getId());
		KieSession kieSession = kieService.getDefaultKieSession();
		kieSession.insert(form);
		kieSession.insert(rp);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return findOptimalRacket(rp);
	}

	private Racket findOptimalRacket(RacketParams rp) {
		List<Blade> blades = bladeRepository.findAll();
		List<Rubber> rubbers = rubberRepository.findAll();
		
		blades = blades.stream()
				.filter(b -> b.getPrice() < rp.getBladePrice().getMax())
				.filter(b -> b.getPrice() > rp.getBladePrice().getMin())
				.filter(b -> b.getControl() < rp.getControlRange().getMax())
				.filter(b -> b.getControl() > rp.getControlRange().getMin())
				.filter(b -> b.getSpeed() < rp.getBladeSpeed().getMax())
				.filter(b -> b.getSpeed() > rp.getBladeSpeed().getMin())
				.filter(b -> b.getGrip() == rp.getGrip())
				.filter(b -> b.getGripType() == rp.getGripType())
				.collect(Collectors.toList());
		
		rubbers = rubbers.stream()
				.filter(r -> r.getPrice() < rp.getRubberPrice().getMax())
				.filter(r -> r.getPrice() > rp.getRubberPrice().getMin())
				.filter(r -> r.getControl() < rp.getControlRange().getMax())
				.filter(r -> r.getControl() > rp.getControlRange().getMin())
				.filter(r -> r.getSpeed() < rp.getRubberSpeed().getMax())
				.filter(r -> r.getSpeed() > rp.getRubberSpeed().getMin())
				.filter(r -> r.getSpin() < rp.getRubberSpin().getMax())
				.filter(r -> r.getSpin() > rp.getRubberSpin().getMin())
				.collect(Collectors.toList());
		
		final Double offCoef = 1.10;
		final Double defCoef = 0.90;
		final Double coef = 1.00;
		
		rubbers.sort((r1, r2) -> {
			if (rp.getPlaystyle() == Playstyle.OFFENSIVE) {
				return calculateRubberGrade(r1, offCoef) > calculateRubberGrade(r2, offCoef) ? 1 : -1;
			}
			if (rp.getPlaystyle() == Playstyle.DEFENSIVE) {
				return calculateRubberGrade(r1, defCoef) > calculateRubberGrade(r2, defCoef) ? 1 : -1;
			}
			return calculateRubberGrade(r1, coef) > calculateRubberGrade(r2, coef) ? 1 : -1;
		});
		
		blades.sort((b1, b2) -> {
			if (rp.getPlaystyle() == Playstyle.OFFENSIVE) {
				return calculateBladeGrade(b1, offCoef) > calculateBladeGrade(b2, offCoef) ? 1 : -1;
			}
			if (rp.getPlaystyle() == Playstyle.DEFENSIVE) {
				return calculateBladeGrade(b1, defCoef) > calculateBladeGrade(b2, defCoef) ? 1 : -1;
			}
			return calculateBladeGrade(b1, coef) > calculateBladeGrade(b2, coef) ? 1 : -1;
		});
		 		
		return new Racket(blades.get(0), rubbers.get(0), rubbers.get(0));
	}
	
	private Double calculateBladeGrade(Blade b, Double coef) {
		return b.getConsistency() + 
				b.getControl() / coef + 
				b.getHardness() * coef + 
				b.getSpeed() * coef + 
				b.getStiffness() * coef;
	}
	
	private Double calculateRubberGrade(Rubber r, Double coef) {
		return r.getConsistency() + 
				r.getControl() / coef + 
				r.getSpeed() * coef + 
				r.getSpin() * coef + 
				r.getTackiness();
	}

	@Override
	@Transactional
	public Racket getHistoryRecommendation(Long userId) {
		Optional<User> u = userRepository.findById(userId);
		
		if (!u.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		if (u.get().getCurrentRacket() == null) {
			throw new EntityNotFoundException();
		}
		
		NewRacketRecommendation nrr = new NewRacketRecommendation();
		nrr.setUser(u.get());
		
		KieSession kieSession = kieService.getDefaultKieSession();
		kieSession.insert(nrr);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		if (nrr.getRecommendation() == null) {
			throw new HistoryException();
		}
		
		return scaleRacket(u.get().getCurrentRacket(), nrr.getRecommendation());
	}
	
	private Racket scaleRacket(Racket r, RacketRecommendation rr) {
		Double coefL = 1.0;
		if (rr == RacketRecommendation.NOTHING) {
			return r;
		}
		
		if (rr == RacketRecommendation.UPGRADE) {
			coefL = 1.10;
		}
		
		if (rr == RacketRecommendation.DOWNGRADE) {
			coefL = 0.90;
		}
		Double rPriceMax = (r.getFhRubber().getPrice() + r.getBhRubber().getPrice()) / 2 * coefL;
		Double rControlMin = Math.min((r.getFhRubber().getControl() + r.getBhRubber().getControl()) / 2 / coefL, 7.5);
		Double rSpeedMax = Math.max((r.getFhRubber().getSpeed() + r.getBhRubber().getSpeed()) / 2 * coefL, 10);
		Double rSpinMax = Math.max((r.getFhRubber().getSpin() + r.getBhRubber().getSpin()) / 2 * coefL, 10);
		
		Double bPriceMax = r.getBlade().getPrice() * coefL;
		Double bControlMin = Math.min(r.getBlade().getControl() / coefL, 7.5);
		Double bSpeedMax = Math.max(r.getBlade().getControl() * coefL, 10);
		Grip grip = r.getBlade().getGrip();
		GripType gripType = r.getBlade().getGripType();
		
		List<Blade> blades = bladeRepository.findAll();
		List<Rubber> rubbers = rubberRepository.findAll();
		
		blades = blades.stream()
				.filter(b -> b.getPrice() < bPriceMax)
				.filter(b -> b.getControl() > bControlMin)
				.filter(b -> b.getSpeed() < bSpeedMax)
				.filter(b -> b.getGrip() == grip)
				.filter(b -> b.getGripType() == gripType)
				.collect(Collectors.toList());
		
		rubbers = rubbers.stream()
				.filter(ra -> ra.getPrice() < rPriceMax)
				.filter(ra -> ra.getControl() > rControlMin)
				.filter(ra -> ra.getSpeed() < rSpeedMax)
				.filter(ra -> ra.getSpin() < rSpinMax)
				.collect(Collectors.toList());
		
		final Double offCoef = 1.10;
		final Double defCoef = 0.90;
		final Double coef = 1.00;
		
		rubbers.sort((r1, r2) -> {
			if (rr == RacketRecommendation.UPGRADE) {
				return calculateRubberGrade(r1, offCoef) > calculateRubberGrade(r2, offCoef) ? 1 : -1;
			}
			if (rr == RacketRecommendation.DOWNGRADE) {
				return calculateRubberGrade(r1, defCoef) > calculateRubberGrade(r2, defCoef) ? 1 : -1;
			}
			return calculateRubberGrade(r1, coef) > calculateRubberGrade(r2, coef) ? 1 : -1;
		});
		
		blades.sort((b1, b2) -> {
			if (rr == RacketRecommendation.UPGRADE) {
				return calculateBladeGrade(b1, offCoef) > calculateBladeGrade(b2, offCoef) ? 1 : -1;
			}
			if (rr == RacketRecommendation.DOWNGRADE) {
				return calculateBladeGrade(b1, defCoef) > calculateBladeGrade(b2, defCoef) ? 1 : -1;
			}
			return calculateBladeGrade(b1, coef) > calculateBladeGrade(b2, coef) ? 1 : -1;
		});
		 		
		return new Racket(blades.get(0), rubbers.get(0), rubbers.get(0));
	}
}
