package com.tta.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tta.app.model.enums.HealthCondition;
import com.tta.app.model.enums.Playstyle;
import com.tta.app.model.enums.Role;
import com.tta.app.model.enums.TrainingExperience;
import com.tta.app.model.enums.UserSkill;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.training.Training;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private TrainingExperience experience;
	@Enumerated(EnumType.STRING)
	private Playstyle playstyle;
	@Enumerated(EnumType.STRING)
	private HealthCondition healthCondition;
	@Enumerated(EnumType.STRING)
	private UserSkill userSkill;
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Training> trainHistory;
	@ManyToOne(fetch = FetchType.EAGER)
	private Racket currentRacket;
	private Double budget;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {
		super();
	}

	public User(String email, String password, String firstName, String lastName, TrainingExperience experience,
			Playstyle playstyle, HealthCondition healthCondition, UserSkill userSkill, List<Training> trainHistory,
			Racket currentRacket, Double budget, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.playstyle = playstyle;
		this.healthCondition = healthCondition;
		this.userSkill = userSkill;
		this.trainHistory = trainHistory;
		this.budget = budget;
		this.currentRacket = currentRacket;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TrainingExperience getExperience() {
		return experience;
	}

	public void setExperience(TrainingExperience experience) {
		this.experience = experience;
	}

	public Playstyle getPlaystyle() {
		return playstyle;
	}

	public void setPlaystyle(Playstyle playstyle) {
		this.playstyle = playstyle;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public HealthCondition getHealthCondition() {
		return healthCondition;
		
	}

	public void setHealthCondition(HealthCondition healthCondition) {
		this.healthCondition = healthCondition;
		
	}

	public Long getId() {
		return id;
		
	}

	public void setId(Long id) {
		this.id = id;
		
	}

	public UserSkill getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(UserSkill userSkill) {
		this.userSkill = userSkill;
	}

	public List<Training> getTrainHistory() {
		return trainHistory;
	}

	public void setTrainHistory(List<Training> trainHistory) {
		this.trainHistory = trainHistory;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
		
	}

	public void setRole(Role role) {
		this.role = role;
		
	}

	public Racket getCurrentRacket() {
		return currentRacket;
	}

	public void setCurrentRacket(Racket currentRacket) {
		this.currentRacket = currentRacket;
	}

}
