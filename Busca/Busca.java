package Busca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Busca extends Thread{
	
	private String caminhoarquivo;
	private String nome;
	private static Semaphore semaphore = new Semaphore(2);
	
	public Busca(String caminhoarquivo, String nome) {
		this.caminhoarquivo = caminhoarquivo;
		this.nome = nome;
	}
	
	public void buscaArquivo() {
		
		 try (BufferedReader br = new BufferedReader(new FileReader(caminhoarquivo))) {
	            String linha;
	            while ((linha = br.readLine()) != null) {
	            	linha = linha.toLowerCase();
	                if (linha.startsWith(nome)) {
	                    System.out.println(linha);
	                }
	            }
	        } catch (IOException e) {
	        	e.printStackTrace();
	     }
	}
	@Override
	public void run() {
		try {
			semaphore.acquire();
			buscaArquivo();
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		finally {
			semaphore.release();
		}	
	}
}
	
	

