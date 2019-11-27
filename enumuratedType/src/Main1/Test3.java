package Main1;

public class Test3 {

	interface FRUIT {
		int APPLE = 1, PEACH = 2, BANANA = 3;
	}

	interface COMPANY {
		int GOOGLE = 1, APPLE = 2, ORACLE = 3;
	}

	public static void main(String[] args) {

		int type = FRUIT.APPLE;
		switch (type) {
		case FRUIT.APPLE:
			System.out.println(57 + " kcal");
			break;
		case FRUIT.PEACH:
			System.out.println(34 + " kcal");
			break;
		case FRUIT.BANANA:
			System.out.println(93 + " kcal");
			break;
		}

	}
}
