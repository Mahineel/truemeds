package com.truemeds.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class InputDetails extends AbstractEntity {

	private String word;



	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "InputDetails [word=" + word + "]";
	}

}
