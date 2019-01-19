package com.cybermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.cybermate.entity.Habits;
import com.cybermate.service.IHabitService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("api/v1")
public class HabitController {
	@Autowired
	private IHabitService habitService;

	@GetMapping("habits/{id}")
	public ResponseEntity<Habits> getHabitById(@PathVariable("id") Integer id) {
		Habits habits = habitService.getHabitById(id);
		return new ResponseEntity<Habits>(habits, HttpStatus.OK);
	}

	@GetMapping("habits")
	public ResponseEntity<List<Habits>> getAllHabits() {
		List<Habits> list = habitService.getAllHabits();
		System.out.println("posted");
		return new ResponseEntity<List<Habits>>(list, HttpStatus.OK);

	}

	@PostMapping("habits/")
	public ResponseEntity<Void> addHabits(@RequestBody Habits habits, UriComponentsBuilder builder) {
		boolean flag = habitService.addHabits(habits);
		System.out.println("Posting..");
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/habits/{id}").buildAndExpand(habits.getHabitId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("habits/update")
	public ResponseEntity<Habits> updateHabits(@RequestBody Habits habits) {
		habitService.updateHabits(habits);
		return new ResponseEntity<Habits>(habits, HttpStatus.OK);
	}

}
