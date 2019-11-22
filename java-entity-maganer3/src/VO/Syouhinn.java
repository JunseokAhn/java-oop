package VO;

import java.io.Serializable;

public class Syouhinn implements Serializable {
	private int code;
	private String name;
	private int nedan;
	
	public Syouhinn(int code, String name, int nedan) {
		super();
		this.code = code;
		this.name = name;
		this.nedan = nedan;
	}
	@Override
	public String toString() {
		return "Syouhinn [code=" + code + ", name=" + name + ", nedan=" + nedan + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNedan() {
		return nedan;
	}
	public void setNedan(int nedan) {
		this.nedan = nedan;
	}

}
