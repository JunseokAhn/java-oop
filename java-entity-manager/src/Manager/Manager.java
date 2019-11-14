package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import VO.Human;
import VO.Professor;
import VO.Staff;
import VO.Student;

public class Manager {

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	String name;
	private int age;
	private int regiNum;
	private boolean result;
	private int index;
	ArrayList<Human> list = new ArrayList<>();

	public int find(int regiNum) {
		for (Human i : list) {
			if (i.getRegiNum() == regiNum) {
				index = list.indexOf(i);
				return index;
			}
		}
		return -1;
	}

	public int find(String str) {
		for (Human i : list) {
			if (i.getName().equals(str)) {
				index = list.indexOf(i);
				return index;
			}
		}

		return -1;
	}

	public boolean register(int choice) {
		result = false;
		System.out.print("�ֹι�ȣ�� �Է����ּ��� : ");
		regiNum = sc.nextInt();
		if (find(regiNum) != -1) {
			System.out.println("�̹� ��ϵ� ��ȣ�Դϴ�. �ٽ� �Է����ּ���");
			this.register(choice);
		} else {
			System.out.print("�̸��� �Է����ּ��� : ");
			name = st.nextLine();
			System.out.print("���̸� �Է����ּ��� : ");
			age = sc.nextInt();

			switch (choice) {
			case 1:
				stuRegi();
				break;
			case 2:
				proRegi();
				break;

			case 3:
				staRegi();
				break;
			}
		}
		return result;
	}

	public void stuRegi() {
		System.out.print("�й��� �Է����ּ��� : ");
		int stuNum = sc.nextInt();
		Student stu = new Student(name, age, regiNum, stuNum);
		list.add(stu);
		result = true;
	}

	public void proRegi() {
		System.out.print("�����ȣ�� �Է����ּ��� : ");
		int subNum = sc.nextInt();
		Professor pro = new Professor(name, age, regiNum, subNum);
		list.add(pro);
		result = true;
	}

	public void staRegi() {
		System.out.print("�μ��� �Է����ּ��� : ");
		String depart = st.nextLine();
		Staff sta = new Staff(name, age, regiNum, depart);
		list.add(sta);
		result = true;
	}

	public void search(int choice) {

		switch (choice) {
		case 1:
			System.out.print("�ֹι�ȣ�� �Է����ּ��� : ");
			regiNum = sc.nextInt();
			if (find(regiNum) == -1) {
				System.out.println("�������� �ʴ� �ֹι�ȣ�Դϴ�.");
			} else {
				System.out.println(list.get(index));
			}
			break;

		case 2:
			System.out.print("�̸��� �Է����ּ��� : ");
			name = st.nextLine();
			if (find(name) == -1) {
				System.out.println("�������� �ʴ� �̸��Դϴ�.");
			} else {
				System.out.println(list.get(index));
			}
			break;

		case 3:
			for (Human i : list) {
				System.out.println(i);
			}
			break;
		}

	}

	public boolean rename() {
		System.out.print("�ֹι�ȣ�� �Է����ּ��� : ");
		int regiNum = sc.nextInt();
		if (find(regiNum) == -1) {
			System.out.println("��ϵ��� ���� �ֹι�ȣ�Դϴ�.");
		} else {
			System.out.print("������ �̸��� �Է����ּ��� : ");
			name = st.nextLine();
			list.get(index).setName(name);
		}
		return true;
	}

	public boolean replace() {
		System.out.print("�ֹι�ȣ�� �Է����ּ��� : ");
		int regiNum = sc.nextInt();
		if (find(regiNum) == -1) {
			System.out.println("��ϵ��� ���� �ֹι�ȣ�Դϴ�.");
		} else {
			System.out.print("������ �̸��� �Է����ּ��� : ");
			name = st.nextLine();
			list.get(index).setName(name);
			System.out.print("������ ���̸� �Է����ּ��� : " );
			age = sc.nextInt();
			list.get(index).setAge(age);
			if(list.get(index) instanceof Student) {
				System.out.print("������ �й��� �Է����ּ��� : ");
				int stuNum=sc.nextInt();
				((Student)list.get(index)).setStuNum(stuNum);
			}
			if(list.get(index) instanceof Professor) {
				System.out.print("������ �����ȣ�� �Է����ּ��� : ");
				int subNum=sc.nextInt();
				((Professor)list.get(index)).setSubNum(subNum);
			}
			if(list.get(index) instanceof Staff) {
				System.out.print("������ �μ��� �Է����ּ��� : ");
				String depart=st.nextLine();
				((Staff)list.get(index)).setDepart(depart);
			}
		}
		return true;
	}

	public void aging() {
		for (Human i : list) {
			i.setAge(i.getAge() + 1);
		}
	}

	public void delete() {
		list.remove(index);
		System.out.println("��������");
	}
}
