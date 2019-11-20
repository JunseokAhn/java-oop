package Test;

import java.util.Scanner;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("데이터 세 개를 입력하세요");
		Scanner sc = new Scanner(System.in);
		Object a = sc.next();
		Object b = sc.next();
		Object c = sc.next();
	
		GenericBox<Object, Object, Object> Box = new GenericBox<>();
		
		
		GenericBox newBox = Box.setBox(a, b, c);
		System.out.println(newBox);
		
		
		GenericBox<Integer, Integer, Integer> intBox = new GenericBox<>();
		System.out.println(intBox.setBox(a, b, c));
		
		
		GenericBox<String, String, String> StringBox = new GenericBox<>();
		System.out.println(StringBox.setBox(a, b, c));
	}

}

class GenericBox<A, B, C> {
	private A a;
	private B b;
	private C c;

	@Override
	public String toString() {
		return "a=" + a + ", b=" + b + ", c=" + c;
	}

	public static <A, B, C> GenericBox<A, B, C> setBox(A a, B b, C c) {
		GenericBox<A, B, C> tempBox = new GenericBox<>();
		tempBox.setA(a);
		tempBox.setB(b);
		tempBox.setC(c);
		
		return tempBox;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

}