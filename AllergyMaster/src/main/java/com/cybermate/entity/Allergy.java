package com.cybermate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allergies")
public class Allergy{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allergy_id")
	private long allergyId;
	@Column(name = "allergy_name")
	private String name;
	@Column(name = "active")
	private boolean active;
	
	public long getAllergyId() {
		return allergyId;
	}
	public void setAllergyId(long allergyId) {
		this.allergyId = allergyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}