package com.cybermate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybermate.entity.Allergy;
import com.cybermate.repository.AllergyRepository;

@Service
public class AllergyService implements IAllergyService {

	@Autowired
	private AllergyRepository allergyRepository;

	public List<Allergy> getAllAllergies() {
		List<Allergy> list = new ArrayList<>();
		allergyRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public Allergy getAllergyById(long allergyId) {
		Allergy obj = allergyRepository.findById(allergyId).get();
		return obj;
	}

	public boolean addAllergy(Allergy allergy) {
		List<Allergy> list = allergyRepository.findByNameAndActive(allergy.getName(), allergy.isActive());
		if (list.size() > 0) {
			return false;
		} else {
			allergyRepository.save(allergy);
			return true;
		}
	}

	public void updateAllergy(Allergy allergy) {
		allergyRepository.save(allergy);

	}


}
