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
				System.out.println("InputMismatchException 발생");
				sc.nextLine();
			}
		}
	}

	public void Menu() {
		System.out.println("==============");
		System.out.println("1. 환자 등록");// 번호,코드,입원일수,나이
		System.out.println("2. 진료차트");// 환자검색, 진료추가,환자삭제
		System.out.println("3. 정산");// +진료비 출력
		System.out.println("4. 프로그램종료");
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
				System.out.println("진료코드를 제대로 입력해주세요");
			}finally {
				break;
			}
			
		case 3:
			seisan();//미구현
			break;

		case 4:
			condition = false;
			System.out.println("프로그램 종료");
			break;

		}

	}

	public void register() {
		System.out.print("번호를 입력하세요 : ");
		num = sc.nextInt();
		if (M.Check(num) == true) {
			System.out.println("중복된 번호입니다. 다시 입력해주세요");
			register();
		} else {
			System.out.println("코드종류 : MI / NI/ SI / TI / VI / WI ");
			System.out.print("진료코드를 입력하세요 : ");
			code = st.nextLine();
			System.out.print("입원일수를 입력하세요 : ");
			days = sc.nextInt();
			System.out.print("나이를 입력하세요 : ");
			age = sc.nextInt();
			kanzya K = new kanzya(num, code, days, age);
			if (M.register(K) == false) {
				System.out.println("등록 실패");
			} else {
				System.out.println("등록 성공");
			}

		}
	}

	public void chart() throws Exception{
		System.out.println("------------------");
		System.out.println("1. 환자 조회");
		System.out.println("2. 진료기록 추가");
		System.out.println("3. 전체 환자 조회");// 진찰부서,진찰비,입원비,진료비
		System.out.println("4. 환자 퇴원시키기");
		System.out.println("------------------");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.print("번호를 입력해주세요 : ");
			num = sc.nextInt();
			System.out.println("1");
			if (M.Check(num) == false) {
				System.out.println("등록되지 않은 환자입니다.");
				break;
			}
			M.search();
			
			break;
		case 2:
			System.out.print("번호를 입력해주세요 : ");
			num = sc.nextInt();
			if (M.Check(num) == false) {
				System.out.println("등록되지 않은 환자입니다.");
				break;
			}
			System.out.print("진료코드를 입력하세요 : ");
			code = st.nextLine();
			System.out.print("입원일수를 입력하세요 : ");
			days = sc.nextInt();
			M.insert(days, code);
			break;

		case 3:
		
			M.searchAll();
			
			break;

		case 4:
			System.out.print("번호를 입력해주세요 : ");
			num = sc.nextInt();
			if (M.Check(num) == false) {
				System.out.println("등록되지 않은 환자입니다.");
				break;
			}
			if (M.out() == false)
				System.out.println("삭제 실패");
			else
				System.out.println("삭제 성공");
			break;

		}
	}

	public void seisan() {
		System.out.print("번호를 입력해주세요 : ");
		num = sc.nextInt();
		if (M.Check(num) == false) {
			System.out.println("등록되지 않은 환자입니다.");
		}
		System.out.println("정산하실 금액을 입력하세요");
		int kinngaku = sc.nextInt();
	
		M.seisan(kinngaku);
		//미구현
	}
}
