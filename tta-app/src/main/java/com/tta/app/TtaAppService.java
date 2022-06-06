package com.tta.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tta.app.model.User;
import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;
import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.events.EndTrainingEvent;
import com.tta.app.model.events.HitEvent;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.model.racket.Rubber;
import com.tta.app.model.training.Training;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class TtaAppService {
	private static Logger log = LoggerFactory.getLogger(TtaAppService.class);
	private final KieContainer kieContainer;
	
	@Autowired
	public TtaAppService(KieContainer kieContainer) {
		log.info("Initialising a new session.");
		this.kieContainer = kieContainer;
	}
	
	public User test(User u) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}
	
	public List<Blade> loadBlades() {
		List<Blade> blades = new ArrayList<Blade>();
		
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource bladeData = resourceLoader.getResource("classpath:" + "blade_data.csv");
	    String line = "";
	    String splitBy = ",";
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
	    	  } catch(Exception e) 
	    	  {
	    	  }

	      }
	    }
	    catch(IOException e) {
	      e.printStackTrace();
	    }
		return blades;
	}
	
	public List<Rubber> loadRubbers() {
		List<Rubber> rubbers = new ArrayList<Rubber>();
		
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource rubberData = resourceLoader.getResource("classpath:" + "rubber_data.csv");
	    String line = "";
	    String splitBy = ",";
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
	    	  } catch(Exception e) 
	    	  {
	    	  }

	      }
	    }
	    catch(IOException e) {
	      e.printStackTrace();
	    }
		return rubbers;
	}

	public RacketParams getRecommendation(RacketForm form) {
		RacketParams rp = new RacketParams();
		rp.setFormId(form.getId());
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(form);
		kieSession.insert(rp);
		kieSession.fireAllRules();
		kieSession.dispose();
		return rp;
	}

	public String simulation(List<HitEvent> hits) {
		KieSession kieSession = kieContainer.newKieSession("cepTraining");

        Thread t = new Thread() {
            @Override
            public void run() {
        		Training tr = new Training();
        		tr.setLevel(TrainingLevel.EASY);
        		kieSession.insert(tr);
        		for (HitEvent hit: hits) {
        			hit.setTimestamp(new Date());
        			hit.setTrainingId(tr.getId());
        			kieSession.insert(hit);
        			try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    	// do nothing
                    }
        		}
                kieSession.insert(new EndTrainingEvent());
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //do nothing
        }
        kieSession.fireUntilHalt();
		return "OK";
	}
}
