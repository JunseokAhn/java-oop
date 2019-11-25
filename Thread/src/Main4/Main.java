package cake;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cake cake = new Cake();
		
		Thread T1 = new Thread(new Producer(cake));
		Thread T2 = new Thread(new Consumer(cake));
		
		T1.start();
		T2.start();
	}

}
