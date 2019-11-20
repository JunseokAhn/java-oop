package HashSetTest;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(4);
	
		for(Integer i:set) {
			System.out.println(i);
		}
		
		
	}
		

}
