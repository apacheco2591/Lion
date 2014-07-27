package com.core.main;

public class Process implements Runnable {
	
	int value;

	@Override
	public void run() {
		System.out.println("value = "+value);
	}
	
	public Process(int value) {
		this.value = value;
	}
}
