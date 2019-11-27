package Main3;

enum Fruit {

	Banana("Yello"), Apple("red"), Mango("2");

	public String color;

	Fruit(String color) {
		this.color = color;
		System.out.println("constructor " + this+ " " + this.color);
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}

enum Company {
	Google, Apple, Oracle

}

public class Test2 {

	public static void main(String[] args) {
		Fruit type = Fruit.Apple;
		switch (type) {
		case Banana:
			System.out.println(36 + "kcal"+" "+Fruit.Banana.color);
			break;

		case Apple:
			System.out.println(57 + "kcal"+" "+Fruit.Apple.getColor());
			break;

		case Mango:
			System.out.println(76 + "kcal"+" "+Fruit.Mango.name());
			break;
		}
		
		type.setColor("set");
		
		for(Fruit f : Fruit.values())
			System.out.println(f+" "+ f.getColor());
	}

}
