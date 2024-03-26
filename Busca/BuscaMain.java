package Busca;

public class BuscaMain {

	public static void main(String[] args) {
		
		String nome = "Ad";
		
		for(int i = 0; i < 10; i++) {
			String caminhoarquivo = "C:\\Users\\User\\eclipse-workspace\\Threads\\src\\Busca\\nomescompletos-0" + i + ".txt";
			new Thread(new Busca(caminhoarquivo, nome.toLowerCase())).start();
		}
	}
}
