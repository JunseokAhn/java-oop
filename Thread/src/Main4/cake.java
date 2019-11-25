package cake;

public class Cake {

	private int cakeNum=0;
	private boolean flag;
	

	public synchronized void produceCake() {

		while (flag == true) {

			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = true;

		System.out.println(++cakeNum + "�� ����ũ ����");
		notifyAll();

	}

	public synchronized void consumeCake() {

		while (flag == false) {

			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;
		notifyAll();
		
		System.out.println(cakeNum + "�� ����ũ �Һ�");
	}

	public int getCakeNum() {
		return cakeNum;
	}

	public void setCakeNum(int cakeNum) {
		this.cakeNum = cakeNum;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
