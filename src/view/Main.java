package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozimento;

public class Main {

	public static void main(String[] args) {
		int entrega = 1;
		Semaphore semaforo = new Semaphore(entrega);
		for(int idprato = 0; idprato<5;idprato++) {
			Thread tcozinha = new ThreadCozimento(idprato, semaforo);
			tcozinha.start();
		}
		
		

	}

}
