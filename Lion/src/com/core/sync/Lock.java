package com.core.sync;

public class Lock {

	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException{
		//System.out.println("lock");
		while(isLocked){
			wait();
		} 
		isLocked = true;
	}
	
	public synchronized void unlock(){
		//System.out.println("Unlock);
		isLocked = false;
		notify();
	}
}
