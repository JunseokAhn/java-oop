package vo;

import java.io.Serializable;

public class Furniture implements Serializable {

	private String fCode;// 가구식별코드
	private String name;// 가구이름
	private String kind;// 가구종류
	private int price;// 가구가격

	public Furniture(String fCode, String name, String kind, int price) {
		super();
		this.fCode = fCode;
		this.name = name;
		this.kind = kind;
		this.price = price;
	}

	public Furniture() {
		super();
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "가구코드=" + fCode + ", 이름=" + name + ", 종류=" + kind + ", 가격=" + price;
	}

}