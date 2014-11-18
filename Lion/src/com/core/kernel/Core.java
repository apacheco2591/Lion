package com.core.kernel;

import java.util.HashMap;

import com.core.sync.Lock;
import com.core.utilities.Console;

public class Core implements Runnable{
	
	Context context;
	
	public Core() {
		super();
	}
	
	public Core(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void run() {
		
		init();	// inicializamos el programa
		
		
		
	}
	
	
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
	
	public void init() {

		// locks
		
		Lock lockPrincipal = new Lock();
		Lock lockContext = new Lock();
		Lock lockKill = new Lock();
		
		Lock lockConsola = new Lock();
		
		// Lista locks
		HashMap<String, Lock> listaLocks = new HashMap<String, Lock>();
		listaLocks.put("lockPrincipal", lockPrincipal);
		listaLocks.put("lockContext", lockContext);
		listaLocks.put("lockKill", lockKill);
		listaLocks.put("lockConsola", lockConsola);
		
		// Consola Principal
		Console consola = new Console("Mi Programa", 1, lockConsola);
		
		
		// Contexto
		Context context = new Context(lockContext, listaLocks, consola);
		this.context = context;
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("INICIO DE LA EJECUCION");
		
		Thread core = new Thread(new Core());
		core.start();
		core.join();
			
		
		System.out.println("FIN DE LA EJECUCION");
	}

}
