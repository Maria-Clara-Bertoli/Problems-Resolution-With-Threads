package projeto_dois;

import java.util.Scanner;
import java.util.ArrayList;

public class ContagemMain {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Informe o limite da contagem: ");
		int limite = entrada.nextInt();
		
		Contagem contagem = new Contagem(limite);
		
		new Thread(new Contagem()).start();
		new Thread(new Contagem()).start();
		new Thread(new Contagem()).start();
	}

}
