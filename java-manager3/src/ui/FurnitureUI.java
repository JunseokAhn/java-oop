package ui;

import java.util.Scanner;

import manager.FurnitureManager;
import vo.Furniture;

public class FurnitureUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);// nextLine�� Scanner
	private FurnitureManager fm = new FurnitureManager();
	private boolean flag = true;// ���α׷����ۿ���

	public FurnitureUI() {// ���α׷��� ���۵Ǵ� �κ�

		while (flag) {
			menu();// �޴��� ������

			int choice = sc.nextInt();// �޴�����

			switch (choice) {
			case 1:// �������
				insertFurniture();
				break;
			case 2:// �԰�� �� ���� ��� ����
				printAllIn();
				break;
			case 3:// �������� ���� �˻�
				printByKind();
				break;
			case 4:// ���� �Ǹ��ϱ�
				sellFurniture();
				break;
			case 5:// �ǸŵǾ��� ���� ����
				printAllOut();
				break;
			case 6:// ���� ��ϻ���
				deleteFurniture();
				break;
			case 7:// ��ǰ�ڵ�� �˻�
				printByFCode();
				break;
			case 8:// ���� ���� ����
				updateFurniture();
				break;
			case 9:// ���α׷�����
				flag = false;
				break;
			}
		}
	}

	public void menu() {// �޴��� �����ִ� �޼���
		System.out.println("=========���ɾ�=========");
		System.out.println("1.�������");
		System.out.println("2.�԰�� �� ���� ��� ����");
		System.out.println("3.�������� ���� �˻�");
		System.out.println("4.���� �Ǹ��ϱ�");
		System.out.println("5.�ǸŵǾ��� ���� ����");
		System.out.println("6.���� ��ϻ���");
		System.out.println("7.��ǰ�ڵ�� �˻�");
		System.out.println("8. ���� ���� ����");
		System.out.println("9. ���α׷�����");
		System.out.println("=======================");
	}

	public void insertFurniture() {
		System.out.println("��ǰ�ڵ带 �Է� : ");
		String fCode = scLine.nextLine();
		System.out.println("�̸��� �Է� : ");
		String name = scLine.nextLine();
		System.out.println("������ �Է� : ");
		String kind = scLine.nextLine();
		System.out.println("������ �Է� : ");
		int price = sc.nextInt();

		Furniture f = new Furniture(fCode, name, kind, price);

		boolean result = fm.insertFurniture(f);

		if (result) {
			System.out.println("��� �Ϸ�");
		} else {
			System.out.println("ERROR**** �ߺ��� ��ǰ�ڵ��Դϴ�.");
		}
	}

	public void printAllIn() {// �԰��ǰ �� ���

		String info = fm.printAllIn();
		System.out.println(info);

	}

	public void printByKind() {// ������ ���

		System.out.println("�˻��� ������ ������ �Է� : ");
		String kind = scLine.nextLine();

		String result = fm.printByKind(kind);

		System.out.println("�˻� ��� : ");
		System.out.println(result);

	}

	public void sellFurniture() {// ��ǰ �Ǹ�
		System.out.println("�Ǹ��� ��ǰ�� �ڵ带 �Է� : ");
		String fCode = scLine.nextLine();

		boolean result = fm.sellFurniture(fCode);

		if (result) {
			System.out.println("�Ǹż���");
		} else {
			System.out.println("ERROR**** ���� ��ǰ�ڵ��Դϴ�.");
		}

	}

	public void printAllOut() {

		String result = fm.printAllOut();

		System.out.println(result);
	}

	public void deleteFurniture() {
		System.out.println("��ǰ�ڵ� �Է� : ");
		String fCode = scLine.nextLine();

		boolean result = fm.deleteFurniture(fCode);
		if (result) {
			System.out.println("���� ����");
		} else {
			System.out.println("ERROR**** ���� ��ǰ�ڵ��Դϴ�.");
		}

	}

	public void printByFCode() {
		System.out.println("��ǰ �ڵ� �Է� : ");
		String fCode = scLine.nextLine();

		String info = fm.printByFCode(fCode);
		System.out.println(info);
	}

	public void updateFurniture() {
		System.out.println("������ ��ǰ �ڵ带 �Է� ���ּ���.");
		String fCode = scLine.nextLine();

		int inIndex = fm.searchInList(fCode);
		int outIndex = fm.searchOutList(fCode);

		if (inIndex == -1 && outIndex == -1) {
			System.out.println("���� ��ǰ�ڵ� �Դϴ�.");
			return;
		} else if (inIndex != -1) {
			System.out.println("1.�̸� ����");
			System.out.println("2.���� ����");
			System.out.println("3.���� ����");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("������ �̸� �Է� : ");
				String name = scLine.nextLine();
				Furniture f = new Furniture();
				f.setName(name);
				fm.updateInList(inIndex, choice, f);
				break;

			case 2:
				System.out.println("������ ���� �Է� : ");
				String kind = scLine.nextLine();
				f = new Furniture();
				f.setKind(kind);
				fm.updateInList(inIndex, choice, f);
				break;

			case 3:
				System.out.println("������ ���� �Է� : ");
				int price = sc.nextInt();
				f = new Furniture();
				f.setPrice(price);
				fm.updateInList(inIndex, choice, f);
				break;

			}

		} else {

			System.out.println("1.�̸� ����");
			System.out.println("2.���� ����");
			System.out.println("3.���� ����");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("������ �̸� �Է� : ");
				String name = scLine.nextLine();
				Furniture f = new Furniture();
				f.setName(name);
				fm.updateOutList(outIndex, choice, f);
				break;

			case 2:
				System.out.println("������ ���� �Է� : ");
				String kind = scLine.nextLine();
				f = new Furniture();
				f.setKind(kind);
				fm.updateOutList(outIndex, choice, f);
				break;

			case 3:
				System.out.println("������ ���� �Է� : ");
				int price = sc.nextInt();
				f = new Furniture();
				f.setPrice(price);
				fm.updateOutList(outIndex, choice, f);
				break;
			}
		}

	}

}
