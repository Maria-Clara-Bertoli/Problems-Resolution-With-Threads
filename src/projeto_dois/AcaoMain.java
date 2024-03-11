package projeto_dois;

import javax.swing.*;
import java.awt.*;

public class AcaoMain {

	public static void main(String[] args) {
		
        JFrame frame = new JFrame("Contagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton botaoIniciarUm = new JButton("Start");
        JButton botaoPausarUm = new JButton("Pause");
        JButton botaoPararUm = new JButton("Stop");
        JLabel labelUm = new JLabel("_______");
        JButton botaoIniciarDois = new JButton("Start");
        JButton botaoPausarDois = new JButton("Pause");
        JButton botaoPararDois = new JButton("Stop");
        JLabel labelDois = new JLabel("_______");
        
        Acao acaothreadum = new Acao();
        Acao acaothreaddois = new Acao();
        
        acaothreadum.setLabel(labelUm);
        acaothreaddois.setLabel(labelDois);

        JPanel painelPrincipalUm = new JPanel();
        painelPrincipalUm.add(botaoIniciarUm);
        painelPrincipalUm.add(botaoPausarUm);
        painelPrincipalUm.add(botaoPararUm);
        painelPrincipalUm.add(labelUm);
        
        JPanel painelPrincipalDois = new JPanel();
        painelPrincipalDois.add(botaoIniciarDois);
        painelPrincipalDois.add(botaoPausarDois);
        painelPrincipalDois.add(botaoPararDois);
        painelPrincipalDois.add(labelDois);

        frame.getContentPane().add(painelPrincipalUm, BorderLayout.NORTH);
        frame.getContentPane().add(painelPrincipalDois, BorderLayout.SOUTH);
        frame.setSize(300, 150);
        frame.setVisible(true);
        
        botaoIniciarUm.addActionListener(e -> {
        	new Thread(() -> {
        		acaothreadum.setStartStop(1);
                acaothreadum.acaoThread();
            }).start();
        });	
        botaoPausarUm.addActionListener(e -> {
        	new Thread(() -> {
        		if(acaothreadum.getEstado() == 1) {
        			acaothreadum.setEstado(0);
        		}
        		else {
        			acaothreadum.setEstado(1);
        		}
            }).start();
        });	
        botaoPararUm.addActionListener(e -> {
        	new Thread(() -> {
        		acaothreadum.setStartStop(0);
            }).start();
        });	
        botaoIniciarDois.addActionListener(e -> {
        	new Thread(() -> {
        		acaothreaddois.setStartStop(1);
                acaothreaddois.acaoThread();
            }).start();
        });	
        botaoPausarDois.addActionListener(e -> {
        	new Thread(() -> {
        		if(acaothreaddois.getEstado() == 1) {
        			acaothreaddois.setEstado(0);
        		}
        		else {
        			acaothreaddois.setEstado(1);
        		}
            }).start();
        });	
        botaoPararDois.addActionListener(e -> {
        	new Thread(() -> {
        		acaothreaddois.setStartStop(0);
            }).start();
        });	
	}
}
