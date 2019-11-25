package Main4;

public class Consumer implements Runnable {

	private cake cake;

	public Consumer(cake cake) {
		this.cake = cake;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (!cake.isEmpty()) {
				int cakeNum = cake.counsume();
				System.out.println(cakeNum + "번 케이크 소비");
				try {
					Thread.sleep((long) (Math.random() * 100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				i--;
			}
		}
	}

}
