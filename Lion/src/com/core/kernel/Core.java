package com.core.kernel;

import java.util.HashMap;

import com.core.process.InputCom;
import com.core.process.Log;
import com.core.process.Tree;
import com.core.sync.Lock;

public class Core {
	
	Tree threadTree;
	Core core;
	
	public void run() {
		
		
		
	}
	
	public void init() {
		
		/**
		 * 
		 * ...
		 * configuracion inicial
		 * 		lectura de ficheros
		 * 		comprobacion de parametros
		 * 		*MD5 o SHA1
		 * 
		 * ficheros de salida (logs del sistema)
		 * 
		 * iniciar hilos de comunicaciones
		 */
		
		try {
			
			// Arbol de Hilos
			threadTree = new Tree();
			System.out.println("ThreadTree -> Done");
			
			// locks
			Lock lockPrincipal = new Lock();
			
			// Lista locks
			HashMap<String, Lock> listaLocks = new HashMap<String, Lock>();
			listaLocks.put("lockPrincipal", lockPrincipal);
			System.out.println("listaLocks ->Done");
			
			// Contexto
			Context context = new Context(listaLocks, threadTree);
			
			
			
			// ficheros de log
			Thread log = new Thread(new Log(lockPrincipal));
			System.out.println(log.getId());
			log.start();
			
			// entrada por teclado
			Thread teclado = new Thread(new InputCom());
			teclado.start();
			teclado.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("INICIO DE LA EJECUCION");
		
		Core core = new Core();
		
		core.init();
		
		
/*		ArrayList<Lock> listLock = new ArrayList<Lock>();
		Lock lockPrincipal = new Lock();
		listLock.add(lockPrincipal);
		
		Process<Core> core = new Process<Core>(listLock, new Core());
		
*/		core.run();
		
		System.out.println("FIN DE LA EJECUCION");
	}

}
