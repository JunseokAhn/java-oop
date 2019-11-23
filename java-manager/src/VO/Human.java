package VO;

public class Human {

	private String name;
	private int age;
	private int regiNum;

	public Human() {
	}

	public Human(String name, int age, int regiNum) {
		super();
		this.name = name;
		this.age = age;
		this.regiNum = regiNum;
	}

	@Override
	public String toString() {
		return "�̸�: " + name + ", ����: " + age + ", �ֹι�ȣ: " + regiNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRegiNum() {
		return regiNum;
	}

	public void setRegiNum(int regiNum) {
		this.regiNum = regiNum;
	}

}
