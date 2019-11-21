package vo;

import java.io.Serializable;

public class Furniture implements Serializable {

	private String fCode;// �����ĺ��ڵ�
	private String name;// �����̸�
	private String kind;// ��������
	private int price;// ��������

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
		return "�����ڵ�=" + fCode + ", �̸�=" + name + ", ����=" + kind + ", ����=" + price;
	}

}