package VO;

public class Student extends Human {
	private int stuNum;

	public Student(String name, int age, int regiNum, int stuNum) {
		super(name, age, regiNum);
		this.stuNum = stuNum;
	}

	@Override
	public String toString() {
		return super.toString()+", �й�: " + stuNum;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	

}
