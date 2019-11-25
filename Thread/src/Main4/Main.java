package Main4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cake cake = new cake();
		new Thread(new Producer(cake)).start();
		new Thread(new Consumer(cake)).start();
	}

}
