package com.truemeds.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "firstname_lastname_java_output")
public class JavaOutput extends AbstractEntity {
	
	
	@Column(name="final_output", nullable = false)
	private String finalOutput;
	
	@Column(nullable = false)
	private int count;

	@CreationTimestamp
	@Column(updatable = false)
	protected Instant created;

	public String getFinalOutput() {
		return finalOutput;
	}

	public void setFinalOutput(String finalOutput) {
		this.finalOutput = finalOutput;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "JavaOutput [finalOutput=" + finalOutput + ", count=" + count + ", created=" + created + "]";
	}

	
	
	 
}
