package Test.Homework;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> dict = new HashMap<>();
		
		String a = "a"; String b = "b";
		int c = 1; int d = 2;
		
		dict.put(a, c);
		dict.put(b, d);
		
		Set<String> keySet = dict.keySet();
		for(Object key : keySet) {
			System.out.println(key +" "+ dict.get(key));
		}
	}

}

	