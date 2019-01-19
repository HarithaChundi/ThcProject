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

import com.cybermate.entity.Allergy;
import com.cybermate.entity.Habits;
import com.cybermate.entity.Vitals;
import com.cybermate.service.IVitalService;

@CrossOrigin(origins ="*")
@Controller
@RequestMapping("api/v1")
public class VitalController {

	@Autowired
	private IVitalService vitalService;

	@GetMapping("vitals/{id}")
	public ResponseEntity<Vitals> getVitalById(@PathVariable("id") Integer id) {
		Vitals vitals = vitalService.getVitalById(id);
		return new ResponseEntity<Vitals>(vitals, HttpStatus.OK);
	}

	@GetMapping("vitals")
	public ResponseEntity<List<Vitals>> getAllVitals() {
		List<Vitals> list = vitalService.getAllVitals();
		System.out.println("posted");
		return new ResponseEntity<List<Vitals>>(list, HttpStatus.OK);
	}
	@PostMapping("vitals/")
	public ResponseEntity<Void> addVitals(@RequestBody Vitals vitals, UriComponentsBuilder builder) {
		boolean flag = vitalService.addVitals(vitals);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/vitals/{id}").buildAndExpand(vitals.getVitalId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("vitals/update")
	public ResponseEntity<Vitals> updateVitals(@RequestBody Vitals vitals) {
		vitalService.updateVitals(vitals);
		return new ResponseEntity<Vitals>(vitals, HttpStatus.OK);
	}

}
