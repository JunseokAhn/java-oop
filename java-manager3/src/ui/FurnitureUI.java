package ui;

import java.util.Scanner;

import manager.FurnitureManager;
import vo.Furniture;

public class FurnitureUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);// nextLine용 Scanner
	private FurnitureManager fm = new FurnitureManager();
	private boolean flag = true;// 프로그램동작여부

	public FurnitureUI() {// 프로그램이 시작되는 부분

		while (flag) {
			menu();// 메뉴를 보여줌

			int choice = sc.nextInt();// 메뉴선택

			switch (choice) {
			case 1:// 가구등록
				insertFurniture();
				break;
			case 2:// 입고된 총 가구 목록 보기
				printAllIn();
				break;
			case 3:// 종류별로 가구 검색
				printByKind();
				break;
			case 4:// 가구 판매하기
				sellFurniture();
				break;
			case 5:// 판매되었던 가구 보기
				printAllOut();
				break;
			case 6:// 가구 기록삭제
				deleteFurniture();
				break;
			case 7:// 제품코드로 검색
				printByFCode();
				break;
			case 8:// 가구 정보 수정
				updateFurniture();
				break;
			case 9:// 프로그램종료
				flag = false;
				break;
			}
		}
	}

	public void menu() {// 메뉴를 보여주는 메서드
		System.out.println("=========아케아=========");
		System.out.println("1.가구등록");
		System.out.println("2.입고된 총 가구 목록 보기");
		System.out.println("3.종류별로 가구 검색");
		System.out.println("4.가구 판매하기");
		System.out.println("5.판매되었던 가구 보기");
		System.out.println("6.가구 기록삭제");
		System.out.println("7.제품코드로 검색");
		System.out.println("8. 가구 정보 수정");
		System.out.println("9. 프로그램종료");
		System.out.println("=======================");
	}

	public void insertFurniture() {
		System.out.println("제품코드를 입력 : ");
		String fCode = scLine.nextLine();
		System.out.println("이름을 입력 : ");
		String name = scLine.nextLine();
		System.out.println("종류를 입력 : ");
		String kind = scLine.nextLine();
		System.out.println("가격을 입력 : ");
		int price = sc.nextInt();

		Furniture f = new Furniture(fCode, name, kind, price);

		boolean result = fm.insertFurniture(f);

		if (result) {
			System.out.println("등록 완료");
		} else {
			System.out.println("ERROR**** 중복된 상품코드입니다.");
		}
	}

	public void printAllIn() {// 입고상품 총 출력

		String info = fm.printAllIn();
		System.out.println(info);

	}

	public void printByKind() {// 종류별 출력

		System.out.println("검색할 가구의 종류를 입력 : ");
		String kind = scLine.nextLine();

		String result = fm.printByKind(kind);

		System.out.println("검색 결과 : ");
		System.out.println(result);

	}

	public void sellFurniture() {// 제품 판매
		System.out.println("판매할 제품의 코드를 입력 : ");
		String fCode = scLine.nextLine();

		boolean result = fm.sellFurniture(fCode);

		if (result) {
			System.out.println("판매성공");
		} else {
			System.out.println("ERROR**** 없는 상품코드입니다.");
		}

	}

	public void printAllOut() {

		String result = fm.printAllOut();

		System.out.println(result);
	}

	public void deleteFurniture() {
		System.out.println("제품코드 입력 : ");
		String fCode = scLine.nextLine();

		boolean result = fm.deleteFurniture(fCode);
		if (result) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("ERROR**** 없는 상품코드입니다.");
		}

	}

	public void printByFCode() {
		System.out.println("제품 코드 입력 : ");
		String fCode = scLine.nextLine();

		String info = fm.printByFCode(fCode);
		System.out.println(info);
	}

	public void updateFurniture() {
		System.out.println("수정할 제품 코드를 입력 해주세요.");
		String fCode = scLine.nextLine();

		int inIndex = fm.searchInList(fCode);
		int outIndex = fm.searchOutList(fCode);

		if (inIndex == -1 && outIndex == -1) {
			System.out.println("없는 제품코드 입니다.");
			return;
		} else if (inIndex != -1) {
			System.out.println("1.이름 수정");
			System.out.println("2.종류 수정");
			System.out.println("3.가격 수정");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("수정될 이름 입력 : ");
				String name = scLine.nextLine();
				Furniture f = new Furniture();
				f.setName(name);
				fm.updateInList(inIndex, choice, f);
				break;

			case 2:
				System.out.println("수정될 종류 입력 : ");
				String kind = scLine.nextLine();
				f = new Furniture();
				f.setKind(kind);
				fm.updateInList(inIndex, choice, f);
				break;

			case 3:
				System.out.println("수정될 가격 입력 : ");
				int price = sc.nextInt();
				f = new Furniture();
				f.setPrice(price);
				fm.updateInList(inIndex, choice, f);
				break;

			}

		} else {

			System.out.println("1.이름 수정");
			System.out.println("2.종류 수정");
			System.out.println("3.가격 수정");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("수정될 이름 입력 : ");
				String name = scLine.nextLine();
				Furniture f = new Furniture();
				f.setName(name);
				fm.updateOutList(outIndex, choice, f);
				break;

			case 2:
				System.out.println("수정될 종류 입력 : ");
				String kind = scLine.nextLine();
				f = new Furniture();
				f.setKind(kind);
				fm.updateOutList(outIndex, choice, f);
				break;

			case 3:
				System.out.println("수정될 가격 입력 : ");
				int price = sc.nextInt();
				f = new Furniture();
				f.setPrice(price);
				fm.updateOutList(outIndex, choice, f);
				break;
			}
		}

	}

}
