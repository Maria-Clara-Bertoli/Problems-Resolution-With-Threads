package projeto_dois;

public class Contagem extends Thread{
	
	static int contagem = 0;
	static int limite;
	
	public Contagem() {
		
	}
	
	public Contagem(int limite) {
		this.limite = limite;
	}
	
	public synchronized void contagemNumero() {
		contagem ++;
		System.out.println(contagem);
	}
	
	@Override
	public void run() {
		while (contagem <= limite) {
			contagemNumero();
		}
	}
}
