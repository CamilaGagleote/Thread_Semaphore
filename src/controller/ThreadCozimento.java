package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class ThreadCozimento extends Thread{

		private int idprato;
		private Semaphore semaforo;
		
	public ThreadCozimento(int idprato, Semaphore semaforo) {
		this.idprato = idprato;
		this.semaforo = semaforo;
		
	}
	public void run() {
		inicio();
		try {
			semaforo.acquire();
			entrega();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}

	private void inicio() {
		double tempoCozimento = 0;
		double tempo= 100;
		int tempoTotalP = (int)((Math.random()*601) + 600);
		int tempoTotalI = (int)((Math.random()*501) + 300);
		DecimalFormat f = new DecimalFormat("0.00");
		
		if(idprato % 2 == 0 || idprato == 0) {
			System.out.println("O prato par " + idprato + " iniciou");
			while(tempo < tempoTotalP) {
				tempoCozimento = (double)(tempo/tempoTotalP) *100;
				System.out.println("O prato par " +idprato+" de Lasanha a bolonhesa está " + f.format(tempoTotalI) + "% cozido");
				tempo+= 100;
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				
			}
			System.out.println("O prato par " + idprato+ " de Lasanha a bolonhesa está pronto" );
		}
		if(idprato % 2 != 0) {
			System.out.println("O prato ímpar " + idprato + " iniciou");
			while(tempo < tempoTotalI) {
				tempoCozimento = (double)(tempo/tempoTotalI) *100;
				System.out.println("O prato  ímpar " +idprato+" de Sopa de Cebola está " + f.format(tempoCozimento) + "% cozido");
				tempo+= 100;
	
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
			System.out.println("O prato ímpar " + idprato+ " de Sopa de cebola está pronto" );
		}
		
	}
	
	private void entrega() {
		System.out.println("O prato " + idprato + " foi entregue");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
