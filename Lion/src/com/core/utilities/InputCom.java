package com.core.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputCom implements Runnable {

	boolean in = true;
	
	@Override
	public void run() {
		
		InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStream);
		
		while (in) {
			try {
				String input = buffer.readLine().trim();
				
				if (input.equals("exit") || input.equals("quit")) {
					in = false;
					// signal
				}
				
				Thread.sleep(100);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
