package com.core.main;

import com.core.main.Process;

public class Core implements Runnable {
	
	@Override
	public void run() {
		
		Thread proc = new Thread(new Process(2));
		proc.start();
		try {
			proc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("INICIO DE LA EJECUCION");
		
		Thread core = new Thread(new Core());
		
		core.start();
		core.join();
		
		System.out.println("FIN DE LA EJECUCION");
	}

}
