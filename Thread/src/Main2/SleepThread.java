package Main2;

public class SleepThread implements Runnable {
	private int count;
	
	public SleepThread() {
		count = 5;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("start");
		while(count>0) {
			System.out.println(count--);
			try {
				Thread.sleep(1000);//슬립 - 일시중지
				
			} catch (InterruptedException e) { //인터럽트 - 중지
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		System.out.println("end");
	}
	
	
	
	
}