package Main2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new SleepThread());
		t1.start();
		Thread t2 = new Thread(new SleepThread());
		t2.start();
		t1.interrupt(); 
		
	}

}
