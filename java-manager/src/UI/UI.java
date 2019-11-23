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
		System.out.println("1. 신규등록");
		System.out.println("2. 신원조회");
		System.out.println("3. 개인정보수정");
		System.out.println("4. 개인정보삭제");
		System.out.println("5. 프로그램 종료");
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
			System.out.println("프로그램 종료");
			break;

		}

	}

	public void regiMenu() {
		System.out.println("--------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 교수 등록");
		System.out.println("3. 직원 등록");
		System.out.println("--------------");
		int choice = sc.nextInt();
		if (M.register(choice) == false) {
			System.out.println("등록실패");
		} else {
			System.out.println("등록성공");
		}

	}

	public void searchMenu() {
		System.out.println("--------------");
		System.out.println("1. 주민번호로 조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("3. 전체 조회");
		System.out.println("--------------");
		int choice = sc.nextInt();
		M.search(choice);
	}

	public void updateMenu() {
		System.out.println("--------------");
		System.out.println("1. 개명");
		System.out.println("2. 전부변경(주민번호제외");
		System.out.println("3. 전체 나이+1");
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
		System.out.print("주민번호를 입력해주세요 : ");
		regiNum = sc.nextInt();
		if (M.find(regiNum) == -1) {
			System.out.println("등록되지 않은 주민번호입니다.");
		} else {
			M.delete();
		}
	}
}
