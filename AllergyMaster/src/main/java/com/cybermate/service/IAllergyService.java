package com.cybermate.service;

import java.util.List;

import com.cybermate.entity.Allergy;


public interface IAllergyService {
	
	List<Allergy> getAllAllergies();

	Allergy getAllergyById(long allergyId);

	boolean addAllergy(Allergy allergy);

	void updateAllergy(Allergy allergy);

	
}
