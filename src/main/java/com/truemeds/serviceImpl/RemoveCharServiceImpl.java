package com.truemeds.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truemeds.daoImpl.InputDetailsRepository;
import com.truemeds.daoImpl.JavaOutputDetailsRepository;
import com.truemeds.model.InputDetails;
import com.truemeds.model.JavaOutput;
import com.truemeds.service.RemoveCharService;

@Service
public class RemoveCharServiceImpl implements RemoveCharService {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(RemoveCharServiceImpl.class);
	
	@Autowired
	private InputDetailsRepository inputDetailsRepository;

	@Autowired
	private JavaOutputDetailsRepository javaOutputDetailsRepository;

	@Override
	public List<InputDetails> fetchDataFromDb() {
		return inputDetailsRepository.findAll();
	}

	public List<JavaOutput> saveFinalOutput(List<InputDetails> data) {
		List<JavaOutput> finalOutput = new ArrayList<>();
		try {
			/* Fetching Data from database  and looping through one at a time */
			for (InputDetails id : data) {
				JavaOutput finalOutput2 = StackUsingArray.getFinalOutput(id.getWord());
				finalOutput.add(finalOutput2);
			}
			
			javaOutputDetailsRepository.saveAll(finalOutput);
			
			LOGGER.info("Data Saved Successfully in Database"  + finalOutput);

		} catch (Exception e) {
			LOGGER.info("Exception Occurred in  RemoveCharServiceImpl.saveFinalOutput()");
			e.getMessage();
		}
		return finalOutput;
	}

}
