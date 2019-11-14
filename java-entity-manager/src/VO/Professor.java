package VO;

public class Professor extends Human {
	private int subNum;

	public Professor(String name, int age, int regiNum, int subNum) {
		super(name, age, regiNum);
		this.subNum = subNum;
	}

	@Override
	public String toString() {
		return super.toString() + ", 과목번호: " + subNum;
	}

	public int getSubNum() {
		return subNum;
	}

	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}

}
