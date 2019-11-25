package UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import Manager.Manager;

public class UI {

	Manager M = new Manager();

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);

	private int choice;
	private int code; // ��ǰ�� ��� 0���� 1�� �ö�
	private String name;
	private int nedan;
	private int money;
	HashMap<Integer, String> HashList = new HashMap<>();

	public UI() {
		HashList.put(1, "����");
		HashList.put(2, "����");
		HashList.put(3, "ħ��");
		HashList.put(4, "����");
		HashList.put(5, "å��");
		HashList.put(6, "��Ź");

		while (true) {
			try {
				mainMenu();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				st.nextLine();
			}
		}
	}

	private void mainMenu() {
		System.out.println("====================");
		System.out.println("1. ��ǰ ����");
		System.out.println("2. ��ǰ �Ǹ�");
		System.out.println("3. ��ǰ ��ȸ");
		System.out.println("4. ���� ����"); // �ڵ�⺻Ű
		System.out.println("5. �ܾ� ��ȸ");
		System.out.println("6. ���� ��ȸ");// �Ǹų���, ���ų���
		System.out.println("7. ���� ����");
		System.out.println("9. ����");
		System.out.println("====================");

		switch (sc.nextInt()) {
		case 1:
			register();
			break;

		case 2:
			sell();
			break;

		case 3:
			search();
			break;

		case 4:
			change();
			break;

		case 5:
			M.getMoney();
			break;

		case 6:
			M.getSoldList();
			break;

		case 7:
			remove();
			break;

		case 9:
			System.out.println("���α׷� ����");
			System.exit(0);
			break;

		default:
			System.out.println("�Է� ����, �ٽ� �Է����ּ���");
			break;

		}
	}


	private void syouhinMenu() {

		System.out.println("-----------  ��ǰ list  -----------");
		System.out.println("1. ���� - 25,000��");
		System.out.println("2. ���� - 10,000��");
		System.out.println("3. ħ�� - 1,200,000��");
		System.out.println("4. ���� - 800,000��");
		System.out.println("5. å�� - 200,000��");
		System.out.println("6. ��Ź - 80,000��");

	}

	private void register() {

		syouhinMenu();
		choice = sc.nextInt();
		name = HashList.get(choice);
		if (M.resister(name) == false) {
			System.out.println("��� ����");
		} else {
			System.out.println("��� ����");
		}
	}

	private void sell() {
		System.out.print("��ǰ �ڵ带 �Է��ϼ��� : ");
		if (M.sell(sc.nextInt()) == false) {
			System.out.println("�ڵ尡 �������� �ʽ��ϴ�");
		} else {
			System.out.println("���� ����");
		}

	}

	private void search() {
		System.out.println("1. ������ �˻�");
		System.out.println("2. ��ü�˻�");

		switch (sc.nextInt()) {
		case 1:
			System.out.print("������ �Է��ϼ��� : ");
			M.search(st.nextLine());
			break;

		case 2:
			M.searchAll();
			break;

		default:
			System.out.println("�Է� ����, �ٽ� �Է����ּ���");
			break;

		}
	}
	private void change() {
		System.out.print("�ڵ带 �Է����ּ��� : ");
		if(M.change(sc.nextInt())==false) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}

	private void remove() {
		// TODO Auto-generated method stub
		System.out.print("�ڵ带 �Է����ּ��� : ");
		M.remove(sc.nextInt());
	}
}
