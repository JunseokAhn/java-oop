package Test.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//0�Է��Ҷ����� �ݺ��ؼ� �������Է¹ް�, ������� �����Ͽ� ������ ù�κ�, �������κ� ���
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.print("������ �Է� : ");
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