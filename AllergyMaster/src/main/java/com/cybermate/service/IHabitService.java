package com.cybermate.service;

import java.util.List;

import com.cybermate.entity.Habits;

public interface IHabitService {

	List<Habits> getAllHabits();

	Habits getHabitById(long habitsId);

	boolean addHabits(Habits habits);

	void updateHabits(Habits habits);


}
