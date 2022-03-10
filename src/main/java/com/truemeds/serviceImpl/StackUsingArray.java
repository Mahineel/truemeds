package com.truemeds.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.truemeds.model.JavaOutput;

public class StackUsingArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(RemoveCharServiceImpl.class);

	char[] arr;
	int topOfStack;

// Creation of stack takes Time complexity of O(1)
// Space complexity is O(N) where N is the size of the stack
	public StackUsingArray(int size) {
		this.arr = new char[size]; // O(1)
		this.topOfStack = -1; // O(1)
		System.out.println("The stack is created with the size of " + size); // O(1)
	}

// isEmpty

// Time compexity will be O(1) cause we are just checking top of stack
// Space compexity will be O(1) cause we are consuming any space complexity
	public boolean isEmpty() {

		if (topOfStack == -1) { // O(1)
			return true; // O(1)
		}
		return false; // O(1)

	}

// isFull
// Time complexity will be O(1)
// Space complexity will be O(1)
	public boolean isFull() {

		if (topOfStack == arr.length - 1) { // O(1)
			System.out.println("This stack is full");
			return true; // O(1)
		}
		return false; // O(1)
	}

//PUSH
// Time complexity will be O(1)
// Space complexity will be O(1) as we are just updating the value of array
	public void push(char value) {
		if (isFull()) { // O(1)
			System.out.println("Stack is full");
		} else {
			arr[topOfStack + 1] = value; // O(1)
			topOfStack++; // O(1)
			System.out.println("The value is successfully inserted"); // O(1)
		}
	}

	public static JavaOutput getFinalOutput(String value) {
		String replaceAll = value.replaceAll("\\s", "");
		/* For storing the count of characters*/
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> newMap = new HashMap<Character, Integer>();
		
		/*  For Storing the final output from map keys*/
		
		StringBuilder sb = new StringBuilder();
		
		/* For storing the final output in object and count variable for counting steps*/
		
		JavaOutput output = new JavaOutput();
		int count = 0;
		for (int i = 0; i < replaceAll.length(); i++) {
			if (map.containsKey(replaceAll.charAt(i))) {
				map.put(replaceAll.charAt(i), map.get(replaceAll.charAt(i)) + 1);
			} else {
				map.put(replaceAll.charAt(i), 1);
			}
		}
		
		/*
		 * Looping through string and checking if value is not 0. If value is not 0 then checking id value is == 1. If it's == 1 then simply adding it to newMap. 
		 * Then appending characters to StringBuilder else map's value is mod of 2 then increasing the count and putting same key with value 0.
		 */
		try {
			for (int i = 0; i < replaceAll.length(); i++) {
				if (map.get(replaceAll.charAt(i)) != 0) {
					if (map.get(replaceAll.charAt(i)) == 1) {
						newMap.put(replaceAll.charAt(i), 1);
						sb.append(replaceAll.charAt(i));

					} else if (map.get(replaceAll.charAt(i)) % 2 == 0) {
						count++;
						map.put(replaceAll.charAt(i), 0);
					}

				}

			}

		} catch (NullPointerException e) {
			LOGGER.info("NullPointerException Occured in StackUsingArray.getFinalOutput()" );
			e.getMessage();
		} catch (Exception e) {
			LOGGER.info("Exception Occured in StackUsingArray.getFinalOutput()" );
			e.getMessage();
		}

		/* Looping through Map and adding it into the JavaOutput Obeject */
		for (Map.Entry<Character, Integer> entrySet : newMap.entrySet()) {

			output.setCount(count);
			output.setFinalOutput(sb.toString());
		}
		
		return output;
	}

// POP
// Time Complexity will be O(1)
// Space Complexity will be O(1)
	public int pop() {
		if (isEmpty()) { // -------------O(1)
			System.out.println("Stack is empty");
			return -1;
		} else {
			int topStack = arr[topOfStack];// -----O(1)
			topOfStack--; // ------------------O(1)
			return topStack;

		}
	}

// Time complexity will be O(1)
// Space Complexity will be O(1)
	public int peek() {
		if (isEmpty()) { // ----------------------O(1)
			System.out.println("The stack is empty"); // ----------------------O(1)
			return -1; // ----------------------O(1)
		} else {
			return arr[topOfStack];// ----------------------O(1)
		}
	}

	/*
	 * public static void main(String[] args) { String s = "baacdccce";
	 * StackUsingArray stack = new StackUsingArray(s.length());
	 * 
	 * for (int i = 0; i < s.length(); i++) { stack.push(s.charAt(i)); }
	 * 
	 * stack.getFinalOutput(new String(stack.arr)); }
	 */

}