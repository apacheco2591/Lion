package com.core.kernel;

import java.util.HashMap;

import com.core.sync.Lock;
import com.core.utilities.Console;

public class Context {
	
	Lock lockContext;
	HashMap<String, Lock> listLock;
	Console consolaPrincipal;
	int kill;
	
	public Context(Lock lockContext, HashMap<String, Lock> listLock, Console con) {
		super();
		this.lockContext = lockContext;
		this.listLock = listLock;
		this.consolaPrincipal = con;
		this.kill = 0;
	}
	
	public Lock getLockContext() {
		return this.lockContext;
	}
	
	public void addLock(String key, Lock lock) {
		this.listLock.put(key, lock);
	}
	
	public Lock getLock(String key) {
		return this.listLock.get(key);
	}

	public HashMap<String, Lock> getListLock() {
		return listLock;
	}
	
	public Console getConsola() {
		return this.consolaPrincipal;
	}
	
}
