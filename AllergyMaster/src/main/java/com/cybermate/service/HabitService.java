package com.cybermate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybermate.entity.Habits;
import com.cybermate.repository.HabitRepository;

@Service
public class HabitService implements IHabitService {

	@Autowired
	private HabitRepository habitRepository;

	@Override
	public List<Habits> getAllHabits() {
		List<Habits> list = new ArrayList<>();
		habitRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Habits getHabitById(long habitId) {
		Habits obj = habitRepository.findById(habitId).get();
		return obj;
	}

	@Override
	public boolean addHabits(Habits habits) {
		List<Habits> list = habitRepository.findByNameAndActive(habits.getName(), habits.isActive());
		if (list.size() > 0) {
			return false;
		} else {
			habitRepository.save(habits);
			return true;
		}
	}

	@Override
	public void updateHabits(Habits habits) {
		habitRepository.save(habits);
	}
}
