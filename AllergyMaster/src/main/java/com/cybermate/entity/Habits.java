package com.cybermate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "habits")
public class Habits {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "habit_id")
	private long habitId;
	@Column(name = "habit_name")
	private String name;
	@Column(name = "active")
	private boolean active;

	public long getHabitId() {
		return habitId;
	}
	public void setHabitId(long habitId) {
		this.habitId = habitId;
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
