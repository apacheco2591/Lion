package com.core.kernel;

import java.util.ArrayList;

import com.core.sync.Lock;

public class Process<T> {
	
	ArrayList<Lock> listLock;
	T obj;
		
	public Process(ArrayList<Lock> listLock, T obj) {
		this.listLock = listLock;
		this.obj = obj;
	}
	
	public int run() throws InterruptedException {
		Thread thread = new Thread((Runnable) obj);
		thread.start();
		thread.join();
		return (int) thread.getId();
	}
}
