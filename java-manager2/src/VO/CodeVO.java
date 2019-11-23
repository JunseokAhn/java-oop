package VO;

public class CodeVO{
	private int num;
	private int age;
	private String depart;
	private int days;
	private String code;
	private int pay1;
	private int pay2;
	private int pay3;
	
	public CodeVO(int num, String code, int days, int age) {
		super();
		this.num = num;
		this.age = age;
		this.days = days;
		this.code = code;
		if (code.equals("MI"))
			depart = "�ܰ�";
		if (code.equals("NI"))
			depart = "����";
		if (code.equals("SI"))
			depart = "�Ǻΰ�";
		if (code.equals("TI"))
			depart = "�Ҿư�";
		if (code.equals("WI"))
			depart = "�񴢱��";

		getPay1(age);
		getPay2(depart, days);
		pay3=pay1+pay2;
	}
	

	
	  @Override public String toString() { return "ȯ�ڹ�ȣ: " + num + ", ����: " + age +
	  ", �����μ�: " + depart + ", ������: "+ pay1 + ", �Կ���: " + pay2 + ", �����: " + pay3;
	  }
	 



	public void getPay1(int age) {
		int result;
		if (age < 10)
			result = 7000;
		else if (age < 20)
			result = 5000;
		else if (age < 30)
			result = 8000;
		else if (age < 40)
			result = 7000;
		else if (age < 50)
			result = 4500;
		else
			result = 2300;

		pay1 = result;
	}

	public void getPay2(String depart, int days) {
		double result = 1;
		if (depart.equals("�ܰ�") || depart.equals("����ΰ�"))
			result = 20000;
		if (depart.equals("����"))
			result = 15000;
		if (depart.equals("�Ҿư�") || depart.equals("�񴢱��") || depart.equals("�Ǻΰ�"))
			result = 10000;

		if (days < 4)
			result = 30000;
		else if (days < 10)
			result *= 1.00;
		else if (days < 15)
			result *= 0.85;
		else if (days < 20)
			result *= 0.8;
		else if (days < 30)
			result *= 0.77;
		else if (days < 100)
			result *= 0.72;
		else
			result *= 0.68;

		pay2 = (int) result;
	}
}
