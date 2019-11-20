package Array;

import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println(list.size());
		list.add(0, "three");
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.contains("three"));
	}

}
