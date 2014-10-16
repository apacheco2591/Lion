package com.core.kernel;

import java.util.HashMap;

import com.core.process.Node;
import com.core.process.Tree;
import com.core.sync.Lock;

public class Context {
	
	HashMap<String, Lock> listLock;
	Tree tree;
	
	public Context(HashMap<String, Lock> listLock, Tree tree) {
		super();
		this.listLock = listLock;
		this.tree = tree;
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

	public Tree getTree() {
		return tree;
	}
	
	public Node getNode(int pid) {
		return this.tree.getLeaf(pid);
	}
	
}
