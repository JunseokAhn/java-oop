package Main3;

public class Counter {

	private int val;

	public Counter() {
		val = 0;
	}

	public/* synchronized */ void increment() {val++;}

	public /* synchronized */ void decrement() {val--;} //��ũ�γ������ ���̸� ����x

	public int getVal() {	return val;}

	public void setVal(int val) {this.val = val;}
	
	
	
	
	
	
}
