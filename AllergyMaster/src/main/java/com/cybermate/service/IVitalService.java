package com.cybermate.service;

import java.util.List;

import com.cybermate.entity.Vitals;

public interface IVitalService {
	List<Vitals> getAllVitals();

	Vitals getVitalById(int vitalId);

	boolean addVitals(Vitals vitals);

	void updateVitals(Vitals vitals);

}
