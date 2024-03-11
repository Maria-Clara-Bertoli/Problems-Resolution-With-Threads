package projeto_dois;

import java.util.Random;

import javax.swing.JLabel;

public class Incrementador {
	
	private int start_stop = 0;
	private int contagem = 0;
	private int incrementa = 2;
	private JLabel label;

	public void setStartStop(int start_stop) {
		this.start_stop = start_stop;
	}
	
	public int getStartStop() {
		return this.start_stop;
	}

	public void setIncrementa(int incrementa) {
		this.incrementa = incrementa;
	}

	Random random = new Random();
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public synchronized void incrementaValor() {
		while(start_stop == 1) {
			if(incrementa == 1) {
				int valor = random.nextInt(5) + 1;
				contagem = contagem + valor;
				label.setText(String.valueOf(contagem));
			}
			else if(incrementa == 0) {
				int valor = random.nextInt(5) + 1;
				contagem = contagem - valor;
				label.setText(String.valueOf(contagem));
			}
			else if(incrementa == 2) {
				label.setText(String.valueOf(contagem));
			}
			else if(start_stop == 0) {
				break;
			}
		}
	}

}
