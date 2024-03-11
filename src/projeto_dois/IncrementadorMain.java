package projeto_dois;

import javax.swing.*;

public class IncrementadorMain {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Incrementador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton botaoIniciarParar = new JButton("Iniciar/Parar");
        JButton botaoIncrementar = new JButton("Inc.");
        JButton botaoDecrementar = new JButton("Dec.");
        JLabel label = new JLabel("_______");
        
        Incrementador incrementador = new Incrementador();
        
        incrementador.setLabel(label);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(botaoIniciarParar);
        painelPrincipal.add(botaoIncrementar);
        painelPrincipal.add(botaoDecrementar);
        painelPrincipal.add(label);
        
        frame.getContentPane().add(painelPrincipal);
        frame.setSize(300, 150);
        frame.setVisible(true);
        
        botaoIniciarParar.addActionListener(e -> {
        	new Thread(() -> {
        		if(incrementador.getStartStop() == 0) {
        			incrementador.setStartStop(1);
        		}
        		else {
        			incrementador.setStartStop(0);
        		}
                incrementador.incrementaValor();
            }).start();
        });	
        botaoIncrementar.addActionListener(e -> {
        	new Thread(() -> {
                incrementador.setIncrementa(1);
                incrementador.setIncrementa(2);
            }).start();
        });	
        botaoDecrementar.addActionListener(e -> {
        	new Thread(() -> {
        		incrementador.setIncrementa(0);
        		incrementador.setIncrementa(2);
            }).start();
        });	
	}
}
