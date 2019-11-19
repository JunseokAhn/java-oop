package Main2;

import java.io.Serializable;

public class User implements Serializable{

	private String name;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private boolean marriage;
	public User(String name, int age, double height, double weight, char gender, boolean marriage) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.marriage = marriage;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", gender="
				+ gender + ", marriage=" + marriage + "]";
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isMarriage() {
		return marriage;
	}
	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}
	
	
}
