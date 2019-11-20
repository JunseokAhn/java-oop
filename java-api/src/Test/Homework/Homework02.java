package Test.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Homework02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~10 반복입력, 중복제거, 셔플, 출력, 0입력되면 종료
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int a;
		while (true) {
			System.out.print("숫자를 입력하세요 : ");
			a = sc.nextInt();
			if (a == 0)
				break;
			
			if (list.contains(a))	continue;
			if (a > 9 || a < 0)
				continue;
			list.add(a);
			
			//HashSet<Integer> tempSet = new HashSet<>(list);
			//list = new ArrayList<>(tempSet);
		}
		Collections.shuffle(list);
		for (int i : list) {
			System.out.println(i);
		}
	}

}
