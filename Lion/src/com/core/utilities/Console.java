package com.core.utilities;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.core.sync.Lock;

public class Console implements Runnable{
	
	String title;
	int fontSize;
	Font font;
	Color background;
	Color fontcolor;
	
	ArrayList<String> msg;
	int priority;
	Lock lockConsola;
	
	public Console(String title, int priority, Lock lockConsola) {
		super();
		this.title = title;
		this.priority = priority;
		this.msg = new ArrayList<String>();
		this.lockConsola = lockConsola;
	}
	
	public JFrame create() {
		JFrame frame = new JFrame(this.title);
		
		frame.setDefaultCloseOperation(this.exit());
		frame.setVisible( true );
		frame.setSize(400, 250);
		
		JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta); 
		ta.setBackground(Color.BLACK);
		ta.setFont(new Font("Courier New", Font.ITALIC, 14));
		ta.setForeground(Color.GREEN);
		
		frame.add(sp);
		frame.validate();
		
		return frame;
	}

	private int exit() {
		if (priority>=2) {
			return JFrame.DISPOSE_ON_CLOSE;
		} else {
			return JFrame.EXIT_ON_CLOSE;
		}
	}

	@Override
	public void run() {
		this.lockConsola.unlock();
		
	}
	
	public void print(String str) {
		try {
			this.lockConsola.lock();
			this.msg.add(str);
			this.lockConsola.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}