package com.truemeds.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truemeds.model.InputDetails;
import com.truemeds.model.JavaOutput;
import com.truemeds.service.RemoveCharService;

@RestController
@RequestMapping("/api/v1")
public class RemoveDuplicateCharController {

	/* Creating Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDuplicateCharController.class);

	@Autowired
	private RemoveCharService removeCharService;

	List<InputDetails> fetchDataFromDb = new ArrayList<>();

	/* Retrieving Strings from the database start */
	@PostConstruct
	private List<InputDetails> getData() {
		fetchDataFromDb = removeCharService.fetchDataFromDb();
		LOGGER.info("Fetching Data From The Database");
		return fetchDataFromDb;
	}
	/* Retrieving Strings from the database end */

	
	/*
	 * Removing Duplicate characters from the string and storing the final output in  database
	 */

	@GetMapping("/removeDuplicates")
	public List<JavaOutput> removeDuplicates() {
		List<JavaOutput> saveFinalOutput = new ArrayList<>();
		try {
			saveFinalOutput = removeCharService.saveFinalOutput(fetchDataFromDb);
		} catch (Exception e) {
			e.getMessage();
		}
		return saveFinalOutput;

		/*
		 * Removing Duplicate characters from the string and storing the final output in database
		 */
	}

}
