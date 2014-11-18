package com.core.utilities;

import java.util.HashMap;

public class Tree {

	Node head;
	
	HashMap<Integer, Node> leafs;
	
	public Tree() {
		this.head = null;
		this.leafs =  new HashMap<Integer, Node>();
	}
	
	public Tree(Node head) {
		this.head = head;
		this.leafs =  new HashMap<Integer, Node>();
		this.leafs.put(head.getInfo(), head);
	}
	
	public int addLeaf(Node root, Node leaf) {
		Node node = this.leafs.get(leaf.getInfo());
		
		if (node!=null) {
			return -1;
		}
		
		if (root==null && this.head==null) {	// no se el padre y no hay head -> head = leaf
			this.head = leaf;
			this.leafs.put(leaf.getInfo(), leaf);
			
		} else if (root==null && this.head != null) {	// si no se el padre y hay head -> root = head
			leaf.setPadre(this.head);
			this.head.addHijo(leaf);
			this.leafs.put(leaf.getInfo(), leaf);
			
		} else if (root!=null && this.head==null) {		// se el padre y no hay head -> head = root / root.addhijo(leaf)
			this.head = root;
			this.leafs.put(root.getInfo(), root);
			
			leaf.setPadre(root);
			this.head.addHijo(leaf);
			this.leafs.put(leaf.getInfo(), leaf);
			
		} else { // (root!=null && this.head!=null) 	hay padre y hay hijo root.addhijo(leaf)
			
			leaf.setPadre(root);
			this.leafs.get(root.getInfo()).addHijo(leaf);
			this.leafs.put(leaf.getInfo(), leaf);
		}
		
		return 0;
	}
	
	
	public String hijos(Node hijo) {
		
		if (hijo.getHijos().size()==0) {
			return Integer.toString(hijo.getInfo())+" ";
		} else {
			String str = "";
			for (Node node : hijo.getHijos()) {
				 str = str + hijos(node);	
			}
			return Integer.toString(hijo.getInfo()) + " - " + str;
		}
	}
	
	public String hijosBlanks(Node hijo, int space) {
		String str = "";

		if (hijo.getHijos().size()==0) {			
			return str + Integer.toString(hijo.getInfo())+"\n";
			
		} else {
			space++;
			for (Node node : hijo.getHijos()) {
				for (int i = 0; i < space-1; i++) {
					str = str +"|   ";
				}
				str = str + "|->";
				str = str + hijosBlanks(node, space);	
			}
			return Integer.toString(hijo.getInfo()) + "\n" + str;
		}
	}
	
	public int deleteLeaf(Node leaf) {
		if (this.head.equals(leaf)) {	// si la leaf == head -> return -1
			return -1;
			
		} else if (leaf.getHijos().size()==0) { // si la hoja no tiene hijos la eliminamos sin mas
			leaf.getPadre().getHijos().remove(leaf);	// eliminamos de los hijos del padre
			leaf.setPadre(null); 						// eliminamos la referencia al padre
			this.leafs.remove(leaf.getInfo());
			
		} else {	// tiene hijos y no es el head -> el padre hereda sus hijos
			for (Node hijo : leaf.getHijos()) {
				hijo.setPadre(leaf.getPadre());
				leaf.getPadre().addHijo(hijo);
			}
			leaf.getPadre().getHijos().remove(leaf);
			this.leafs.remove(leaf);
			
		}

		return 0;
	}
	
	public Node getLeaf(int pid) {
		return this.leafs.get(pid);
	}
}