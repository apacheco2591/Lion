package com.core.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.core.sync.Lock;

public class Log implements Runnable {
	
	String PATH = "./logs/";
	String[] cola = new String[50];

	@Override
	public void run() {
		
		File file = null;
		FileOutputStream fop = null;
		String finalPath;
		
		if (PATH.charAt(PATH.length()-1)!='/') {
			PATH = PATH+"/";
		}
	
		finalPath = PATH + "Log."+ new Date().toString()+".txt";
		
		try {
			file = new File(finalPath);
			file.createNewFile();
			fop = new FileOutputStream(file);
			
			// get the content in bytes
			byte[] contentInBytes = "hola que ase".getBytes();
			 
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fop.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public Log(String path, Lock lock) {
		super();
		this.PATH = path;
	}


	public Log(Lock lock) {
		
	}
	
}
