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
		t1.setPriority(1);//�ּҿ켱����
		t2.setPriority(10);//�ִ� �켱���� == t2.MAX_PRIORITY; 
		//�⺻== NORM_PRIORITY;
		
		t1.start();
		t2.start(); // �ΰ��� ������ �����ư��� ���� > ��ǻ� ���õ���

	}

}
