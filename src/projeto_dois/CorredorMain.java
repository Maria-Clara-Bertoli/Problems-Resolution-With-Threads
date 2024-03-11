package projeto_dois;
import java.util.Scanner;

public class CorredorMain {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int contagem = 0;
		System.out.println("Informe o número de corredores: ");
		int contador = entrada.nextInt();
		
		while (contagem < contador){
			System.out.println("Informe o nome do corredor: ");
			String nome = entrada.next();
			new Thread(new Corredor(nome)).start();
			contagem ++;
		}	
	entrada.close();
	}
}
