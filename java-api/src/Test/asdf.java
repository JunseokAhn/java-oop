package Test;

public class asdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A A = new A();
		B B = new B();
		System.out.println(A.a==B.a);
		System.out.println(A.b==B.b);
		System.out.println(A.b.equals(B.b));
		System.out.println(A.b.contains(B.b));
		System.out.println(A.equals(B));
		Object C = 1;
		System.out.println(C instanceof Integer);
		Object D = "a";
		System.out.println(D instanceof String);
	}

}

class A {
	int a = 1;
	String b = "a";
}

class B{
	int a = 1;
	String b = "a";
}