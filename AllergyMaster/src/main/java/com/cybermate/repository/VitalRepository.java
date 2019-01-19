package com.cybermate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cybermate.entity.Vitals;

public interface VitalRepository extends CrudRepository<Vitals,Integer>{




	List<Vitals> getByvitalId(int vitalId);

}
