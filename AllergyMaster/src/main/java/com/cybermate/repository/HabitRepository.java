package com.cybermate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cybermate.entity.Habits;

public interface HabitRepository extends CrudRepository<Habits, Long>{

	List<Habits> findByNameAndActive(String name, boolean active);


}