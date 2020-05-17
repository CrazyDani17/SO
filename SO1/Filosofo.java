package so1;

import java.util.Random;

public class Filosofo extends Thread {
	
	private int estomago;
	private int nfilosofo;
	private boolean [] turnos;
	
	protected Filosofo(int n, boolean[] t) {
        this.nfilosofo = n;
        this.turnos=t;
        this.estomago = 20;
    }
	
	public void run() {
		while(true) {
			comer();
			pensar();
			if(this.estomago<0) {
				System.out.println(this.getName() + " acabo de morir de hambre.");
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void comer() {
		if(this.turnos[this.nfilosofo]) {
			long i;
			long inicio = System.nanoTime();
			System.out.println("");
			System.out.println("Filósofo " + this.getName() + " está comiendo.");
			System.out.println("");
			try {
				this.sleep(new Random().nextInt(2000) + 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("+Se ha producido una excepcion...");
			}
			long despues = System.nanoTime();
			long tiempo = despues - inicio;
			i=tiempo%7;
			this.estomago+=i;
			this.turnos[this.nfilosofo]=false;
			if(this.nfilosofo!=this.turnos.length-1) {
				this.turnos[this.nfilosofo + 1]=true;
			}
			else{
				this.turnos[0]=true;
			}
		}
		else { 
            System.out.println("Filósofo " + this.getName() + " está esperando."); 
        }
	}
	@SuppressWarnings("static-access")
	public void pensar() {
		long i;
		long inicio = System.nanoTime();
		try {
        	System.out.println("Filósofo " + this.getName() + " está pensando."+ this.estomago);
            this.sleep(new Random().nextInt(2000) + 1000);
        } catch (InterruptedException ex) {
        	// TODO Auto-generated catch block
        	System.out.println("+Se ha producido una excepcion...");
        }
		long despues = System.nanoTime();
		long tiempo = despues - inicio;
		i=tiempo%7;
		while(i>0) {
			this.estomago--;
			i--;
		}
	}

}
