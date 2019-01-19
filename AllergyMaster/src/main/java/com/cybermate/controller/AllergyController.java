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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cybermate.entity.Allergy;
import com.cybermate.service.IAllergyService;

@CrossOrigin(origins ="*")
@Controller
@RequestMapping("api/v1")
public class AllergyController {

	@Autowired
	private IAllergyService allergyService;


	@GetMapping("allergies/{id}")
	public ResponseEntity<Allergy> getAllergyById(@PathVariable("id") Integer id) {
		Allergy allergy = allergyService.getAllergyById(id);
		return new ResponseEntity<Allergy>(allergy, HttpStatus.OK);
	}

	@GetMapping("allergies")
	public ResponseEntity<List<Allergy>> getAllAllergies() {
		List<Allergy> list = allergyService.getAllAllergies();
		System.out.println("posted");
		return new ResponseEntity<List<Allergy>>(list, HttpStatus.OK);

	}

	@PostMapping("allergies/")
	public ResponseEntity<Void> addAllergy(@RequestBody Allergy allergy, UriComponentsBuilder builder) {
		boolean flag = allergyService.addAllergy(allergy);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/allergies/{id}").buildAndExpand(allergy.getAllergyId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("allergies/update")
	public ResponseEntity<Allergy> updateAllergy(@RequestBody Allergy allergy) {
		allergyService.updateAllergy(allergy);
		return new ResponseEntity<Allergy>(allergy, HttpStatus.OK);
	}
}
