package Main4;

public class Producer implements Runnable {

	private cake cake;

	public Producer(cake cake) {
		this.cake = cake;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i > 10; i++) {
			if (cake.isEmpty()) {
				cake.produce(i);
				System.out.println(i + "번 케이크 생성");

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
