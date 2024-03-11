package projeto_dois;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Acao {
	
	private int contador = 0;
	private int start_stop = 0;
	private int estado = 1;
	private JLabel label;
	private JButton botaoIniciar;
    private JButton botaoPausar;
    private JButton botaoParar;
	
	public JButton getBotaoIniciar() {
		return botaoIniciar;
	}

	public JButton getBotaoPausar() {
		return botaoPausar;
	}

	public JButton getBotaoParar() {
		return botaoParar;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getEstado() {
		return this.estado;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public void setStartStop(int start_stop) {
		this.start_stop = start_stop;
	}
	
	public synchronized void acaoThread() {
		while (start_stop == 1){
			
			if(estado == 1) {
				contador ++;
				label.setText(String.valueOf(contador));
			}
			
			else if(estado == 0) {
				label.setText(String.valueOf(contador));
			}
			
			else if(start_stop == 0) {
				break;
			}
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.getMessage();			
			}
		}
	}
}
