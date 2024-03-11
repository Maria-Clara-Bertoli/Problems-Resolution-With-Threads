package projeto_dois;

public class BuscaMain {

	public static void main(String[] args) {
		
		int inicio_thread_um = 0;
		int inicio_thread_dois = 3;
		int fim_thread_um = 2;
		int fim_thread_dois = 4;
		int valor_busca = 8;
		int vet [] = {7, 4, 3, 8, 6};
		
		new Busca(vet);
		new Thread(new Busca(inicio_thread_um, fim_thread_um, valor_busca)).start();
		new Thread(new Busca(inicio_thread_dois, fim_thread_dois, valor_busca)).start();
	}
}
