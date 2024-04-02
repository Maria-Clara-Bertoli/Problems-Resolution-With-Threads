package dna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class GeraDNA implements Runnable{

	private String caminho_arquivo_atual;
	private String caminho_novo_arquivo;
	private static Semaphore semaphore = new Semaphore(1);
	final char A = 'A';
	final char T = 'T';
	final char G = 'G';
	final char C = 'C';

	public GeraDNA(String caminho_arquivo_atual, String caminho_novo_arquivo) {
		this.caminho_arquivo_atual = caminho_arquivo_atual;
		this.caminho_novo_arquivo = caminho_novo_arquivo;
	}

	public void geraArquivo() {

		try (BufferedReader atual = new BufferedReader(new FileReader(this.caminho_arquivo_atual));
				BufferedWriter novo = new BufferedWriter(new FileWriter(this.caminho_novo_arquivo))) {

			String linha;
			while ((linha = atual.readLine()) != null) {
				if (!linha.matches("[ATGC]+")) {
                    novo.write("****FITA INVALIDA-" + linha);
                }
				else {
					for (char valor : linha.toCharArray()) {
						switch(valor) {
						case 'A':
							novo.write('T');
							break;
						case 'T':
							novo.write('A');
							break;
						case 'G':
							novo.write('C');
							break;
						default:
							novo.write('G');	
						}
					}	
				}
				novo.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void contagem() {
		
		try (BufferedReader atual = new BufferedReader(new FileReader(this.caminho_novo_arquivo))) {
			
			int total_fita = 0;
			int fita_invalida = 0;
			int fita_valida = 0;
			int linha_arquivo = 0;
			ArrayList<Integer> linhainvalida = new ArrayList<Integer>();
			String linha;

			while ((linha = atual.readLine()) != null) {
				linha_arquivo ++;
				if (linha.startsWith("*")) {
					fita_invalida ++;
					linhainvalida.add(linha_arquivo);
                }
				else {
					fita_valida ++;
				}
				total_fita ++;
			}
			
			System.out.println();
			System.out.println();
			System.out.println(caminho_novo_arquivo);
			System.out.println("Total Fita");
			System.out.println(total_fita);
			System.out.println("Fita Valida");
			System.out.println(fita_valida);
			System.out.println("Fita Inválida");
			System.out.println(fita_invalida);
			System.out.println("Linhas Inválidas");
			for(int i = 0; i < linhainvalida.size(); i++) {
				System.out.print(linhainvalida.get(i) + "; ");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			geraArquivo();
			contagem();
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		finally {
			semaphore.release();
		}	
	}
}
