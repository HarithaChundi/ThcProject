package com.cybermate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cybermate.entity.Allergy;

public interface AllergyRepository extends CrudRepository<Allergy, Long> {

	List<Allergy> findByNameAndActive(String name, boolean b);
}
