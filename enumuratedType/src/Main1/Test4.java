package Main1;

enum Fruit {
	APPLE, PEACH, BANANA;
}
//class Fruit{
//    public static final Fruit APPLE  = new Fruit();
//    public static final Fruit PEACH  = new Fruit();
//    public static final Fruit BANANA = new Fruit();
//}

enum Company {
	GOOGLE, APPLE, ORACLE;
}

//class Company 
//public static final Company GOOGLE = new Company();
//public static final Company APPLE = new Company();
//public static final Company ORACLE = new Company();

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fruit type = Fruit.APPLE;
		switch (type) {
		case APPLE:
			System.out.println(57 + " kcal");
			break;
		case PEACH:
			System.out.println(34 + " kcal");
			break;
		case BANANA:
			System.out.println(93 + " kcal");
			break;
		}

	}

}