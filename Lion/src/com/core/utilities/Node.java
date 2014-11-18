package com.core.utilities;

import java.util.ArrayList;

import com.core.sync.Lock;

public class Node {
	
	Node padre;
	ArrayList<Node> hijos;
	int pid;
	ArrayList<Lock> listLock;
	String descripcion;
	
	public Node(int info, String desc) {
		super();
		this.hijos = new ArrayList<Node>();
		this.pid = info;
		this.padre = null;
		this.listLock = new ArrayList<Lock>();
		this.descripcion = desc;
	}
	
	public ArrayList<Node> getHijos() {
		return hijos;
	}
	
	public void addHijo(Node hijo) {
		this.hijos.add(hijo);
	}

	public int getInfo() {
		return pid;
	}

	public void setInfo(int info) {
		this.pid = info;
	}

	public Node getPadre() {
		return padre;
	}

	public void setPadre(Node padre) {
		this.padre = padre;
	}
	
	public void addLock(Lock lock) {
		this.listLock.add(lock);
	}

	public ArrayList<Lock> getLocks() {
		return this.listLock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
