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

	public void seisan(int kinngaku) {
		for (CodeVO i : list2) {
			if (i.getPay3() >= kinngaku) {
				i.setPay3(i.getPay3()-kinngaku);
				i.setSeisan(kinngaku);
				break;
			} else {
				kinngaku-=i.getPay3();
				i.setSeisan(i.getPay3());
				i.setPay3(0);
				
			}
		}
	}
}
