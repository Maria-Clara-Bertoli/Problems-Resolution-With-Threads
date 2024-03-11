package projeto_dois;

public class Busca extends Thread{
	
	static int vet[] = new int[5];
	private int inicio;
	private int fim;
	private int valor_busca;
	
	public Busca(int[]vet) {
		this.vet = vet;
	}
	
	public Busca(int inicio, int fim, int valor_busca) {
		this.inicio = inicio;
		this.fim = fim;
		this.valor_busca = valor_busca;
	}
	
	public synchronized void busca() {
		for(int i = this.inicio; i <= this.fim; i++) {
			if(vet[i] == valor_busca) {
				System.out.println("Valor encontrado!" + " Valor: " + vet[i]);
				break;
			}
		}
	}
	
	@Override
	public void run() {
		busca();
	}
}
