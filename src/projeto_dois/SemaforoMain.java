package projeto_dois;

public class SemaforoMain {

	public static void main(String[] args) {
		
		Semaforo semaforo = new Semaforo();
		
		semaforo.inicializacao();

		new Thread(() -> {
            semaforo.verificacao();
            semaforo.aquisicao();
            semaforo.liberacao();
        }).start();

        new Thread(() -> {
        	semaforo.verificacao();
            semaforo.aquisicao();
            semaforo.liberacao();
        }).start();
        
        new Thread(() -> {
        	semaforo.verificacao();
            semaforo.aquisicao();
            semaforo.liberacao();
        }).start();
        
        new Thread(() -> {
        	semaforo.verificacao();
            semaforo.aquisicao();
            semaforo.liberacao();
        }).start();
	}
}
