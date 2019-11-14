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
		System.out.print("주민번호를 입력해주세요 : ");
		regiNum = sc.nextInt();
		if (find(regiNum) != -1) {
			System.out.println("이미 등록된 번호입니다. 다시 입력해주세요");
			this.register(choice);
		} else {
			System.out.print("이름을 입력해주세요 : ");
			name = st.nextLine();
			System.out.print("나이를 입력해주세요 : ");
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
		System.out.print("학번을 입력해주세요 : ");
		int stuNum = sc.nextInt();
		Student stu = new Student(name, age, regiNum, stuNum);
		list.add(stu);
		result = true;
	}

	public void proRegi() {
		System.out.print("과목번호를 입력해주세요 : ");
		int subNum = sc.nextInt();
		Professor pro = new Professor(name, age, regiNum, subNum);
		list.add(pro);
		result = true;
	}

	public void staRegi() {
		System.out.print("부서를 입력해주세요 : ");
		String depart = st.nextLine();
		Staff sta = new Staff(name, age, regiNum, depart);
		list.add(sta);
		result = true;
	}

	public void search(int choice) {

		switch (choice) {
		case 1:
			System.out.print("주민번호를 입력해주세요 : ");
			regiNum = sc.nextInt();
			if (find(regiNum) == -1) {
				System.out.println("존재하지 않는 주민번호입니다.");
			} else {
				System.out.println(list.get(index));
			}
			break;

		case 2:
			System.out.print("이름을 입력해주세요 : ");
			name = st.nextLine();
			if (find(name) == -1) {
				System.out.println("존재하지 않는 이름입니다.");
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
		System.out.print("주민번호를 입력해주세요 : ");
		int regiNum = sc.nextInt();
		if (find(regiNum) == -1) {
			System.out.println("등록되지 않은 주민번호입니다.");
		} else {
			System.out.print("변경할 이름을 입력해주세요 : ");
			name = st.nextLine();
			list.get(index).setName(name);
		}
		return true;
	}

	public boolean replace() {
		System.out.print("주민번호를 입력해주세요 : ");
		int regiNum = sc.nextInt();
		if (find(regiNum) == -1) {
			System.out.println("등록되지 않은 주민번호입니다.");
		} else {
			System.out.print("변경할 이름을 입력해주세요 : ");
			name = st.nextLine();
			list.get(index).setName(name);
			System.out.print("변경할 나이를 입력해주세요 : " );
			age = sc.nextInt();
			list.get(index).setAge(age);
			if(list.get(index) instanceof Student) {
				System.out.print("변경할 학번을 입력해주세요 : ");
				int stuNum=sc.nextInt();
				((Student)list.get(index)).setStuNum(stuNum);
			}
			if(list.get(index) instanceof Professor) {
				System.out.print("변경할 과목번호를 입력해주세요 : ");
				int subNum=sc.nextInt();
				((Professor)list.get(index)).setSubNum(subNum);
			}
			if(list.get(index) instanceof Staff) {
				System.out.print("변경할 부서를 입력해주세요 : ");
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
		System.out.println("삭제성공");
	}
}
