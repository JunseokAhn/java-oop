package VO;

import java.util.ArrayList;

public class kanzya {

	private int num;
	ArrayList<CodeVO> list2 = new ArrayList<>();
	private int age;

	public kanzya() {
	}

	public kanzya(int num, String code, int days, int age) {
		super();
		this.num = num;
		this.age = age;
		list2.add(new CodeVO(num, code, days, age));
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean insert(CodeVO C) {
		list2.add(C);
		return true;
	}

	public String print() {
		String result = "";
		for (CodeVO i : list2)
			result += i;
		return result;
	}
	
	
}
