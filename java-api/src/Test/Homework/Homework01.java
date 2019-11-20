package Test.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//0입력할때까지 반복해서 영문자입력받고, 순서대로 정렬하여 정렬한 첫부분, 마지막부분 출력
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.print("영문자 입력 : ");
			String a = sc.next();

			if (a.equals("0")) {
				break;
			}
			list.add(a);
		}

		Collections.sort(list);
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1));
		for(String s:list) {
			System.out.println(s);
		}

	}
}