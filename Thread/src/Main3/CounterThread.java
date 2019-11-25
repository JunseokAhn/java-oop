package Main3;

public class CounterThread implements Runnable {

	private Counter counter;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<100000; i++) {
			synchronized (counter) {
				counter.increment();
				counter.decrement();
			}
			if(i%10==0)
				System.out.println(counter.getVal());
		}
	}

}
