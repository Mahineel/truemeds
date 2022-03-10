package com.truemeds.service;

import java.util.List;

import com.truemeds.model.InputDetails;
import com.truemeds.model.JavaOutput;

public interface RemoveCharService {

	
	public List<InputDetails> fetchDataFromDb();

	public List<JavaOutput> saveFinalOutput(List<InputDetails> data);
	
	
}
