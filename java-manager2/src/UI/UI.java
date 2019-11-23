package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import Manager.Manager;
import VO.CodeVO;
import VO.kanzya;

public class UI {

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	Manager M = new Manager();
	private int choice;
	private int num;
	private int age;
	private String code;
	private int days;
	private boolean condition = true;

	public UI() {
		while (condition) {
			try {
				Menu();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("InputMismatchException �߻�");
				sc.nextLine();
			}
		}
	}

	public void Menu() {
		System.out.println("==============");
		System.out.println("1. ȯ�� ���");// ��ȣ,�ڵ�,�Կ��ϼ�,����
		System.out.println("2. ������Ʈ");// ȯ�ڰ˻�, �����߰�,ȯ�ڻ���
		System.out.println("3. ����");// +����� ���
		System.out.println("4. ���α׷�����");
		System.out.println("==============");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			register();
			break;
		case 2:
			try {
				chart();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("�����ڵ带 ����� �Է����ּ���");
			}finally {
				break;
			}
			
		case 3:
			seisan();//�̱���
			break;

		case 4:
			condition = false;
			System.out.println("���α׷� ����");
			break;

		}

	}

	public void register() {
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		num = sc.nextInt();
		if (M.Check(num) == true) {
			System.out.println("�ߺ��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���");
			register();
		} else {
			System.out.println("�ڵ����� : MI / NI/ SI / TI / VI / WI ");
			System.out.print("�����ڵ带 �Է��ϼ��� : ");
			code = st.nextLine();
			System.out.print("�Կ��ϼ��� �Է��ϼ��� : ");
			days = sc.nextInt();
			System.out.print("���̸� �Է��ϼ��� : ");
			age = sc.nextInt();
			kanzya K = new kanzya(num, code, days, age);
			if (M.register(K) == false) {
				System.out.println("��� ����");
			} else {
				System.out.println("��� ����");
			}

		}
	}

	public void chart() throws Exception{
		System.out.println("------------------");
		System.out.println("1. ȯ�� ��ȸ");
		System.out.println("2. ������ �߰�");
		System.out.println("3. ��ü ȯ�� ��ȸ");// �����μ�,������,�Կ���,�����
		System.out.println("4. ȯ�� �����Ű��");
		System.out.println("------------------");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.print("��ȣ�� �Է����ּ��� : ");
			num = sc.nextInt();
			System.out.println("1");
			if (M.Check(num) == false) {
				System.out.println("��ϵ��� ���� ȯ���Դϴ�.");
				break;
			}
			M.search();
			
			break;
		case 2:
			System.out.print("��ȣ�� �Է����ּ��� : ");
			num = sc.nextInt();
			if (M.Check(num) == false) {
				System.out.println("��ϵ��� ���� ȯ���Դϴ�.");
				break;
			}
			System.out.print("�����ڵ带 �Է��ϼ��� : ");
			code = st.nextLine();
			System.out.print("�Կ��ϼ��� �Է��ϼ��� : ");
			days = sc.nextInt();
			M.insert(days, code);
			break;

		case 3:
		
			M.searchAll();
			
			break;

		case 4:
			System.out.print("��ȣ�� �Է����ּ��� : ");
			num = sc.nextInt();
			if (M.Check(num) == false) {
				System.out.println("��ϵ��� ���� ȯ���Դϴ�.");
				break;
			}
			if (M.out() == false)
				System.out.println("���� ����");
			else
				System.out.println("���� ����");
			break;

		}
	}

	public void seisan() {
		System.out.print("��ȣ�� �Է����ּ��� : ");
		num = sc.nextInt();
		if (M.Check(num) == false) {
			System.out.println("��ϵ��� ���� ȯ���Դϴ�.");
		}
		System.out.println("�����Ͻ� �ݾ��� �Է��ϼ���");
		int kinngaku = sc.nextInt();
	
		M.seisan(kinngaku);
		//�̱���
	}
}
