package Main3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Counter counter = new Counter();
		
		new Thread(new CounterThread(counter)).start();
		new Thread(new CounterThread(counter)).start();
		new Thread(new CounterThread(counter)).start();
		new Thread(new CounterThread(counter)).start();
		
		
	}

}
