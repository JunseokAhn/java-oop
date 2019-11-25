package Main;

public class CountdownThread /* extends Thread */ implements Runnable {

	private int count;
	private String name;

	public CountdownThread(int count, String name) {
		this.count = count;
		this.name = name;

	}

	@Override
	public void run() {

		while (count > 0) {
			System.out.println(name + ": " + count--);
		}
		System.out.println("end");
		// TODO Auto-generated method stub
//		super.run();
	}

}
