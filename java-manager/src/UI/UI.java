package UI;

import java.util.Scanner;

import Manager.Manager;

public class UI {
	boolean mainFlag = true;
	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	Manager M = new Manager();
	private int regiNum;

	public UI() {
		while (mainFlag) {
			mainMenu();
		}
	}

	public void mainMenu() {
		System.out.println("================");
		System.out.println("1. �űԵ��");
		System.out.println("2. �ſ���ȸ");
		System.out.println("3. ������������");
		System.out.println("4. ������������");
		System.out.println("5. ���α׷� ����");
		System.out.println("================");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			regiMenu();
			break;

		case 2:
			searchMenu();
			break;

		case 3:
			updateMenu();
			break;

		case 4:
			deleteMenu();
			break;

		case 5:
			mainFlag = false;
			System.out.println("���α׷� ����");
			break;

		}

	}

	public void regiMenu() {
		System.out.println("--------------");
		System.out.println("1. �л� ���");
		System.out.println("2. ���� ���");
		System.out.println("3. ���� ���");
		System.out.println("--------------");
		int choice = sc.nextInt();
		if (M.register(choice) == false) {
			System.out.println("��Ͻ���");
		} else {
			System.out.println("��ϼ���");
		}

	}

	public void searchMenu() {
		System.out.println("--------------");
		System.out.println("1. �ֹι�ȣ�� ��ȸ");
		System.out.println("2. �̸����� ��ȸ");
		System.out.println("3. ��ü ��ȸ");
		System.out.println("--------------");
		int choice = sc.nextInt();
		M.search(choice);
	}

	public void updateMenu() {
		System.out.println("--------------");
		System.out.println("1. ����");
		System.out.println("2. ���κ���(�ֹι�ȣ����");
		System.out.println("3. ��ü ����+1");
		System.out.println("--------------");
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			M.rename();
			break;

		case 2:
			M.replace();
			break;

		case 3:
			M.aging();
			break;

		}
	}

	public void deleteMenu() {
		System.out.print("�ֹι�ȣ�� �Է����ּ��� : ");
		regiNum = sc.nextInt();
		if (M.find(regiNum) == -1) {
			System.out.println("��ϵ��� ���� �ֹι�ȣ�Դϴ�.");
		} else {
			M.delete();
		}
	}
}
