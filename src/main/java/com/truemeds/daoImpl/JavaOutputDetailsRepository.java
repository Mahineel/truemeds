package com.truemeds.daoImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truemeds.model.InputDetails;
import com.truemeds.model.JavaOutput;

@Repository
public interface JavaOutputDetailsRepository extends JpaRepository<JavaOutput, Integer>  {

		

	
}
