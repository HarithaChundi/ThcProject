package com.cybermate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybermate.entity.Habits;
import com.cybermate.entity.Vitals;
import com.cybermate.repository.VitalRepository;

@Service
public class VitalService implements IVitalService{

	@Autowired
	private VitalRepository vitalRepository;

	@Override
	public List<Vitals> getAllVitals() {
		List<Vitals> list = new ArrayList<>();
		vitalRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Vitals getVitalById(int vitalId) {
		Vitals obj = vitalRepository.findById(vitalId).get();
		return obj;
	}


	@Override
	public boolean addVitals(Vitals vitals) {
		List<Vitals> list = vitalRepository.getByvitalId(vitals.getVitalId());
		if (list.size() > 0) {
			return false;
		} else {
			vitalRepository.save(vitals);
			return true;
		}
	}

	@Override
	public void updateVitals(Vitals vitals) {
		vitalRepository.save(vitals);

	}


}
