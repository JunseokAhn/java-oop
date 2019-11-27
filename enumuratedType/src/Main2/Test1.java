package Main2;


enum Fruit{
	Banana, Apple, Mango;
	
	Fruit() {
		System.out.println("constructor "+this);
	}
}

enum Company{
	Google, Apple, Oracle
	
}

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fruit type = Fruit.Apple;
		switch(type) {
		case Banana:
			System.out.println(36+"kcal");
			break;
			
		case Apple:
			System.out.println(57+"kcal");
			break;
			
		case Mango:
			System.out.println(76+"kcal");
			break;
		}
	}

}
