package CollectionTest;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

public class CollenctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(9);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		Collections.reverse(list);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		Collections.shuffle(list);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		Collections.sort(list);
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
		int a = Integer.parseInt("3");
		System.out.println("Integer.parseInt ="+a);
	}

}
