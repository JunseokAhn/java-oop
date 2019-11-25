package cake;

public class Consumer implements Runnable {
	private Cake cake;

	public Consumer(Cake cake) {
		this.cake = cake;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			cake.consumeCake();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
