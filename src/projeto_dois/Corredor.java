package projeto_dois;

import java.util.Random;

public class Corredor extends Thread{
	
	String str;
	static int contador = 1;
	
	Random random = new Random();
	
	public Corredor(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			if (i == 9) {
				System.out.println(str + " - " + contador + " lugar");
				contador ++;
			}
			int numero = random.nextInt(5000);
			Thread.currentThread();
			try {
				Thread.sleep(numero);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
