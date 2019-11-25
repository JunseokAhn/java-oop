package Main;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Thread t1 = new CountdownThread(10000, "T1"); Thread t2 = new
		 * CountdownThread(10000, "\tT2");
		 */
		
		Thread t1 = new Thread(new CountdownThread(10000, "T1"));
		Thread t2 = new Thread(new CountdownThread(10000, "\tT2"));
		t1.setPriority(1);//최소우선순위
		t2.setPriority(10);//최대 우선순위 == t2.MAX_PRIORITY; 
		//기본== NORM_PRIORITY;
		
		t1.start();
		t2.start(); // 두개가 빠르게 번갈아가며 동작 > 사실상 동시동작

	}

}
