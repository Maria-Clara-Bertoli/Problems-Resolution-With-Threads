package projeto_dois;

public class Semaforo extends Thread{
	
	static String status = "livre";

    public synchronized void aquisicao(){
    	System.out.println(Thread.currentThread().getName() + " - " + "verde");
    	try {
        	Thread.sleep(5000);
        }
        catch(InterruptedException e){
        	System.out.println(e.getMessage());
        }
    }
    
    public synchronized void verificacao() {
    	while (status.equals("adquirido")) {
        	try {
        		wait();
        	}
        	catch(InterruptedException e) {
        		System.out.println(e.getMessage());
        	}
        }
    	status = "adquirido";
    }
    
    public synchronized void liberacao() {
    	System.out.println(Thread.currentThread().getName() + " - " + "vermelho");
    	status = "livre";
    	notify();
    }
    
    public void inicializacao() {
    	System.out.println("Thread-1" + " - " + "vermelho");
    	System.out.println("Thread-2" + " - " + "vermelho");
    	System.out.println("Thread-3" + " - " + "vermelho");
    	System.out.println("Thread-4" + " - " + "vermelho");
    }
}
