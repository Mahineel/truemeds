package com.truemeds.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StackUsingArray {

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

	// PUSH
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

	public static void main(String[] args) {
		String s = "aabcbb cdee";
		StackUsingArray stack = new StackUsingArray(s.length());
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
				stack.push(s.charAt(i));
			} else {
				stack.pop();
			}

		}

		String shortString = "";
		int i = 0;
		while (!stack.isEmpty()) {
			shortString = stack.peek() + shortString;
			stack.pop();
		}
		if (shortString.length() == 0) {
			shortString = "Empty String";
		}
		System.out.println(shortString);
		// System.out.println(shortString);
		// stack.contains(new String(stack.arr));
	}

}
