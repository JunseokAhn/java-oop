package VO;

public class Staff extends Human {
	private String depart;

	public Staff(String name, int age, int regiNum, String depart) {
		super(name, age, regiNum);
		this.depart = depart;
	}

	@Override
	public String toString() {

		return super.toString() + ", ºÎ¼­: " + depart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

}
