package com.tta.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.tta.app.model.User;
import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;
import com.tta.app.model.enums.HealthCondition;
import com.tta.app.model.enums.HitResult;
import com.tta.app.model.enums.HitType;
import com.tta.app.model.enums.Playstyle;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.Role;
import com.tta.app.model.enums.Spin;
import com.tta.app.model.enums.TrainingExperience;
import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.enums.UserSkill;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.Rubber;
import com.tta.app.model.training.Hit;
import com.tta.app.model.training.Training;
import com.tta.app.model.training.TrainingLevelParams;
import com.tta.app.repository.BladeRepository;
import com.tta.app.repository.HitRepository;
import com.tta.app.repository.RacketRepository;
import com.tta.app.repository.RubberRepository;
import com.tta.app.repository.TrainingLevelParamsRepository;
import com.tta.app.repository.TrainingRepository;
import com.tta.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Seeder implements ApplicationRunner {
	
	private final UserRepository userRepository;
	private final TrainingLevelParamsRepository trainingLevelParamsRepository;
	private final TrainingRepository trainingRepository;
	private final HitRepository hitRepository;
	private final RacketRepository racketRepository;
	private final BladeRepository bladeRepository;
	private final RubberRepository rubberRepository;
	
	@Autowired
	public Seeder(UserRepository userRepository, TrainingRepository trainingRepository, HitRepository hitRepository, TrainingLevelParamsRepository trainingLevelParamsRepository,
			RacketRepository racketRepository, BladeRepository bladeRepository, RubberRepository rubberRepository) {
		super();
		this.userRepository = userRepository;
		this.trainingLevelParamsRepository = trainingLevelParamsRepository;
		this.trainingRepository = trainingRepository;
		this.hitRepository = hitRepository;
		this.racketRepository = racketRepository;
		this.bladeRepository = bladeRepository;
		this.rubberRepository = rubberRepository;
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		
		// ################### User ###################
		User admin = new User(
				"admin@maildrop.cc",
				"$2a$12$3l/btwDNxpZ.TaQAS3mTdOT9ZL79zoZdKD/hHhnLfyNBPrObbHMBC", 
				"Admin",
				"Trener",
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				Role.ADMIN);
		
		User nedja = new User(
				"nedja@maildrop.cc",
				"$2a$12$3l/btwDNxpZ.TaQAS3mTdOT9ZL79zoZdKD/hHhnLfyNBPrObbHMBC", 
				"Nedeljko",
				"Vignjevic",
				TrainingExperience.HOBBYIST, 
				Playstyle.DEFENSIVE, 
				HealthCondition.GOOD, 
				UserSkill.INTERMEDIATE, 
				new ArrayList<Training>(), 
				120.00, 
				Role.PLAYER);
		
		User deki = new User(
				"deki@maildrop.cc",
				"$2a$12$3l/btwDNxpZ.TaQAS3mTdOT9ZL79zoZdKD/hHhnLfyNBPrObbHMBC", 
				"Dejan",
				"Todorovic",
				TrainingExperience.INTERMEDIATE, 
				Playstyle.OFFENSIVE, 
				HealthCondition.GOOD, 
				UserSkill.PRO, 
				new ArrayList<Training>(), 
				150.00, 
				Role.PLAYER);
		
		userRepository.save(admin);
		userRepository.save(nedja);
		userRepository.save(deki);
		
		// ################### TrainingLevelParams ###################
		TrainingLevelParams tlpEasy1 = new TrainingLevelParams(0.35, 10.5, 4.5, 4, "EASY - 1", TrainingLevel.EASY);
		TrainingLevelParams tlpEasy2 = new TrainingLevelParams(0.30, 10.0, 4.0, 4, "EASY - 2", TrainingLevel.EASY);
		TrainingLevelParams tlpMedium1 = new TrainingLevelParams(0.20, 5.0, 3.0, 3, "MEDIUM - 1", TrainingLevel.MEDIUM);
		TrainingLevelParams tlpHard1 = new TrainingLevelParams(0.10, 2.0, 2.0, 2, "HARD - 1", TrainingLevel.HARD);
		
		trainingLevelParamsRepository.save(tlpEasy1);
		trainingLevelParamsRepository.save(tlpEasy2);
		trainingLevelParamsRepository.save(tlpMedium1);
		trainingLevelParamsRepository.save(tlpHard1);
		
		// ################### CSV Parameters ###################
		ResourceLoader resourceLoader = new DefaultResourceLoader();
	    String line = "";
	    String splitBy = ",";
	    
		// ################### Blade ###################
		List<Blade> blades = new ArrayList<Blade>();
		
		Resource bladeData = resourceLoader.getResource("classpath:" + "blade_data.csv");

	    try {
	      BufferedReader br = new BufferedReader(new FileReader(bladeData.getFile()));
	      while ((line = br.readLine()) != null)
	      {
	    	  try 
	    	  {
		          String[] blade = line.split(splitBy);
		          Blade b = new Blade();
		          b.setName(blade[0]);
		          b.setPrice(Double.parseDouble(blade[1]));
		          b.setSpeed(Double.parseDouble(blade[2]));
		          b.setControl(Double.parseDouble(blade[3]));
		          b.setStiffness(Double.parseDouble(blade[4]));
		          b.setWeight(Double.parseDouble(blade[5]));
		          b.setHardness(Double.parseDouble(blade[6]));
		          b.setConsistency(Double.parseDouble(blade[7]));
		          b.setGrip(Grip.valueOf(blade[8]));
		          b.setGripType(!blade[9].isEmpty() ? GripType.valueOf(blade[9]) : null);
		        
		          blades.add(b);
		          bladeRepository.save(b);
	    	  } catch(Exception e) {}
	      }
	    }
	    catch(IOException e) {
	    	e.printStackTrace();
	    }
		
		// ################### Rubber ###################
	    List<Rubber> rubbers = new ArrayList<Rubber>();
		
		Resource rubberData = resourceLoader.getResource("classpath:" + "rubber_data.csv");
	    try {
	      BufferedReader br = new BufferedReader(new FileReader(rubberData.getFile()));
	      while ((line = br.readLine()) != null)
	      {
	    	  try 
	    	  {
		          String[] rubber = line.split(splitBy);
		          Rubber r = new Rubber();
		          r.setName(rubber[0]);
		          r.setPrice(Double.parseDouble(rubber[1]));
		          r.setSpeed(Double.parseDouble(rubber[2]));
		          r.setSpin(Double.parseDouble(rubber[3]));
		          r.setControl(Double.parseDouble(rubber[4]));
		          r.setTackiness(Double.parseDouble(rubber[5]));
		          r.setWeight(Double.parseDouble(rubber[6]));
		          r.setHardness(Double.parseDouble(rubber[7]));
		          r.setConsistency(Double.parseDouble(rubber[8]));
		        
		          rubbers.add(r);
		          rubberRepository.save(r);
	    	  } catch(Exception e) {}
	      }
	    }
	    catch(IOException e) {
	    	e.printStackTrace();
	    }
	    
		// ################### Racket ###################
	    Racket racket = new Racket(blades.get(0), rubbers.get(10), rubbers.get(10));
	    
	    racketRepository.save(racket);
				
		// ################### Training ###################
		Training tr1 = new Training(
				RacketOrientation.FOREHAND, HitType.LOOP, tlpEasy1, parseDate("15-07-2022 15:00:00"), 
				Spin.TOP, 35.00, 3.55, deki, racket, new ArrayList<Hit>(), true, true);
		Training tr2 = new Training(
				RacketOrientation.FOREHAND, HitType.LOOP, tlpMedium1, parseDate("16-07-2022 15:00:00"), 
				Spin.TOP, 35.00, 3.55, deki, racket, new ArrayList<Hit>(), false, true);
		Training tr3 = new Training(
				RacketOrientation.BACKHAND, HitType.CHOP, tlpEasy2, parseDate("17-07-2022 15:00:00"), 
				Spin.TOP, 35.00, 3.55, deki, racket, new ArrayList<Hit>(), true, true);
		Training tr4 = new Training(
				RacketOrientation.BACKHAND, HitType.CHOP, tlpEasy2, parseDate("18-07-2022 15:00:00"), 
				Spin.TOP, 35.00, 3.55, deki, racket, new ArrayList<Hit>(), true, true);

		trainingRepository.save(tr1);
		trainingRepository.save(tr2);
		trainingRepository.save(tr3);
		trainingRepository.save(tr4);
		
		// ################### Hit ###################
		this.addHit(36.00, 3.60, HitResult.GOOD, tr1);
		this.addHit(38.00, 3.70, HitResult.GOOD, tr1);
		this.addHit(37.00, 3.60, HitResult.GOOD, tr1);
		this.addHit(34.10, 3.60, HitResult.GOOD, tr1);
		this.addHit(35.00, 3.90, HitResult.GOOD, tr1);
		this.addHit(34.00, 4.00, HitResult.GOOD, tr1);
		this.addHit(36.00, 3.72, HitResult.GOOD, tr1);
		this.addHit(34.10, 3.60, HitResult.GOOD, tr1);
		this.addHit(35.00, 4.10, HitResult.GOOD, tr1);
		this.addHit(37.00, 2.60, HitResult.GOOD, tr1);
		
		this.addHit(43.00, 8.60, HitResult.FRONT_OUT, tr2);
		this.addHit(42.00, 8.60, HitResult.FRONT_OUT, tr2);
		this.addHit(40.00, 4.60, HitResult.GOOD, tr2);
		this.addHit(43.00, 5.60, HitResult.LEFT_OUT, tr2);
		this.addHit(42.00, 5.80, HitResult.LEFT_OUT, tr2);
		this.addHit(43.00, 5.90, HitResult.RIGHT_OUT, tr2);
		this.addHit(33.00, 6.60, HitResult.RIGHT_OUT, tr2);
		this.addHit(41.00, 5.60, HitResult.RIGHT_OUT, tr2);
		this.addHit(39.00, 2.60, HitResult.NET, tr2);
		this.addHit(37.00, 3.60, HitResult.GOOD, tr2);
		
		this.addHit(32.00, 2.90, HitResult.GOOD, tr3);
		this.addHit(33.00, 3.90, HitResult.GOOD, tr3);
		this.addHit(34.00, 3.90, HitResult.GOOD, tr3);
		this.addHit(33.00, 4.90, HitResult.FRONT_OUT, tr3);
		this.addHit(35.00, 3.90, HitResult.GOOD, tr3);
		this.addHit(38.00, 4.90, HitResult.GOOD, tr3);
		this.addHit(35.00, 2.90, HitResult.GOOD, tr3);
		this.addHit(32.00, 4.90, HitResult.GOOD, tr3);
		this.addHit(34.00, 2.90, HitResult.GOOD, tr3);
		this.addHit(37.00, 3.90, HitResult.GOOD, tr3);
		
		this.addHit(37.00, 3.90, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(45.01, 6.80, HitResult.FRONT_OUT, tr4);
		this.addHit(47.00, 6.80, HitResult.FRONT_OUT, tr4);
		this.addHit(46.00, 6.80, HitResult.FRONT_OUT, tr4);
		this.addHit(36.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(36.50, 3.80, HitResult.GOOD, tr4);
		this.addHit(36.40, 3.80, HitResult.GOOD, tr4);
		this.addHit(36.00, 3.80, HitResult.GOOD, tr4);
		this.addHit(37.00, 3.80, HitResult.GOOD, tr4);
	}
	
	private void addHit(Double angle, Double speed, HitResult result, Training training) {
		Hit hit = new Hit(angle, speed, training, result);
		hitRepository.save(hit);
	}
	
	private Long parseDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		try {
			Date d = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.getTimeInMillis();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}

}
