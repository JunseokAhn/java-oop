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
	private int code; // 제품을 사면 0부터 1씩 올라감
	private String name;
	private int nedan;
	private int money;
	HashMap<Integer, String> HashList = new HashMap<>();

	public UI() {
		HashList.put(1, "의자");
		HashList.put(2, "베개");
		HashList.put(3, "침대");
		HashList.put(4, "소파");
		HashList.put(5, "책상");
		HashList.put(6, "식탁");

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
		System.out.println("1. 제품 구매");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 조회");
		System.out.println("4. 가격 변경"); // 코드기본키
		System.out.println("5. 잔액 조회");
		System.out.println("6. 내역 조회");// 판매내역, 구매내역
		System.out.println("7. 내역 삭제");
		System.out.println("9. 종료");
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
			System.out.println("프로그램 종료");
			System.exit(0);
			break;

		default:
			System.out.println("입력 오류, 다시 입력해주세요");
			break;

		}
	}


	private void syouhinMenu() {

		System.out.println("-----------  상품 list  -----------");
		System.out.println("1. 의자 - 25,000원");
		System.out.println("2. 베개 - 10,000원");
		System.out.println("3. 침대 - 1,200,000원");
		System.out.println("4. 소파 - 800,000원");
		System.out.println("5. 책상 - 200,000원");
		System.out.println("6. 식탁 - 80,000원");

	}

	private void register() {

		syouhinMenu();
		choice = sc.nextInt();
		name = HashList.get(choice);
		if (M.resister(name) == false) {
			System.out.println("등록 실패");
		} else {
			System.out.println("등록 성공");
		}
	}

	private void sell() {
		System.out.print("제품 코드를 입력하세요 : ");
		if (M.sell(sc.nextInt()) == false) {
			System.out.println("코드가 일지하지 않습니다");
		} else {
			System.out.println("삭제 성공");
		}

	}

	private void search() {
		System.out.println("1. 종류별 검색");
		System.out.println("2. 전체검색");

		switch (sc.nextInt()) {
		case 1:
			System.out.print("종류를 입력하세요 : ");
			M.search(st.nextLine());
			break;

		case 2:
			M.searchAll();
			break;

		default:
			System.out.println("입력 오류, 다시 입력해주세요");
			break;

		}
	}
	private void change() {
		System.out.print("코드를 입력해주세요 : ");
		if(M.change(sc.nextInt())==false) {
			System.out.println("변경 실패");
		}else {
			System.out.println("변경 성공");
		}
	}

	private void remove() {
		// TODO Auto-generated method stub
		System.out.print("코드를 입력해주세요 : ");
		M.remove(sc.nextInt());
	}
}
