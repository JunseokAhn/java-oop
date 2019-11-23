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
			depart = "외과";
		if (code.equals("NI"))
			depart = "내과";
		if (code.equals("SI"))
			depart = "피부과";
		if (code.equals("TI"))
			depart = "소아과";
		if (code.equals("WI"))
			depart = "비뇨기과";

		getPay1(age);
		getPay2(depart, days);
		pay3=pay1+pay2;
	}
	

	
	  @Override public String toString() { return "환자번호: " + num + ", 나이: " + age +
	  ", 진찰부서: " + depart + ", 진찰비: "+ pay1 + ", 입원비: " + pay2 + ", 진료비: " + pay3;
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
		if (depart.equals("외과") || depart.equals("산부인과"))
			result = 20000;
		if (depart.equals("내과"))
			result = 15000;
		if (depart.equals("소아과") || depart.equals("비뇨기과") || depart.equals("피부과"))
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
