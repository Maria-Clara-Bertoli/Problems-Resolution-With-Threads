package dna;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GeraDNAMain {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 10; i++) {
			String caminho_arquivo_atual = "C:\\Users\\User\\eclipse-workspace\\Threads\\src\\dna\\dna-" + i + ".txt";
			String caminho_novo_arquivo = "C:\\Users\\User\\eclipse-workspace\\Threads\\src\\dna\\dna-" + (i + 10) + ".txt";
			GeraDNA tarefa = new GeraDNA(caminho_arquivo_atual, caminho_novo_arquivo);
			executorService.execute(tarefa);
		}
		executorService.shutdown();
	}
}