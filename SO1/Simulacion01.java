package so1;

public class Simulacion01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean filosofos[] = {true,false,false,false,false};
		
		Filosofo f1 = new Filosofo(0,filosofos);
		Filosofo f2 = new Filosofo(1,filosofos);
		Filosofo f3 = new Filosofo(2,filosofos);
		Filosofo f4 = new Filosofo(3,filosofos);
		Filosofo f5 = new Filosofo(4,filosofos);
		
				
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
		
		
		/*
		int N = 5;
		
		for(int i =0;i<N;i++) {
			new Filosofo(i,filosofos).start();	
		}*/
	}

}
