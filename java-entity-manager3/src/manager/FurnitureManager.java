package manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Furniture;

public class FurnitureManager {

	private ArrayList<Furniture> inList = new ArrayList<>();// 입고된상품
	private ArrayList<Furniture> outList = new ArrayList<>();// 판매된상품

	private FileOutputStream fos; // 파일 저장용 스트림
	private ObjectOutputStream oos;// 객체 저장	용 스트림

	private FileInputStream fis;// 파일 가져오기용 스트림
	private ObjectInputStream ois;// 객체 가져오기용 스트림

	public FurnitureManager() {// 메니저 생성자, 프로그램 시작시 호출
		loadFile();// 파일 로드
	}

	public void saveFile() {// 파일 저장 메서드

		try {
			fos = new FileOutputStream("inListSave.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(inList); // 입고된 상품 파일저장
			oos.close();

			fos = new FileOutputStream("outListSave.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(outList); // 출고된 상품 파일저장
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadFile() {// 파일 로드 메서드, 프로그램 시작시 1회 호출

		File in = new File("inListSave.dat");
		File out = new File("outListSave.dat");

		if (in.exists() && out.exists()) {

			try {

				fis = new FileInputStream(in);
				ois = new ObjectInputStream(fis);
				inList = (ArrayList<Furniture>) ois.readObject();// 입고된제품로드
				ois.close();

				fis = new FileInputStream(out);
				ois = new ObjectInputStream(fis);
				outList = (ArrayList<Furniture>) ois.readObject();// 출고된제품로드
				ois.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean insertFurniture(Furniture f) {// 가구 등록
		boolean result = false;

		int inResult = searchInList(f.getfCode());
		int outResult = searchOutList(f.getfCode());

		if (inResult == -1 && outResult == -1) {// 제품코드가 출고,입고된 상품에 존재하지 않음
			inList.add(f);
			result = true;// 등록, 성공적
			saveFile();// 파일에 저장
		}

		return result;
	}

	public String printAllIn() {// 입고상품 전체 출력
		String result = "";

		for (int i = 0; i < inList.size(); i++) {

			result += inList.get(i) + "\n";

		}

		return result;
	}

	public String printAllOut() {// 판매된 상품 전체 출력
		String result = "";

		for (int i = 0; i < outList.size(); i++) {

			result += outList.get(i) + "\n";

		}
		return result;
	}

	public int searchInList(String fCode) {// 입고된 상품에서 제품코드 검색, 존재하면 index 반환, 존재하지 않으면 -1 반환
		int result = -1;// 초기값 -1, 존재하지 않는다면 그대로 반환

		for (int i = 0; i < inList.size(); i++) {
			if (inList.get(i).getfCode().equals(fCode)) {
				result = i;
			}
		}
		return result;
	}

	public int searchOutList(String fCode) {// 출고된 상품에서 제품코드 검색, 존재하면 index 반환, 존재하지 않으면 -1 반환
		int result = -1;// 초기값 -1, 존재하지 않는다면 그대로 반환

		for (int i = 0; i < outList.size(); i++) {
			if (outList.get(i).getfCode().equals(fCode)) {
				result = i;
			}
		}
		return result;
	}

	public String printByKind(String kind) {// 종류별 출력
		String result = "";
		for (int i = 0; i < inList.size(); i++) {

			if (inList.get(i).getKind().equals(kind)) {
				result += inList.get(i) + "\n";
			}
		}
		return result;
	}

	public boolean sellFurniture(String fCode) {
		boolean result = false;

		int inIndex = searchInList(fCode);

		if (inIndex > -1) {
			result = true;
			Furniture sold = inList.get(inIndex);
			outList.add(sold);
			inList.remove(inIndex);
			saveFile();
		}

		return result;
	}

	public boolean deleteFurniture(String fCode) {
		int inIndex = searchInList(fCode);
		int outIndex = searchOutList(fCode);

		if (inIndex == -1 && outIndex == -1) {// 존재하지 않는 제품코드
			return false;
		} else if (inIndex != -1) {
			inList.remove(inIndex);// 재고에 제품코드 존재
			saveFile();
			return true;
		} else {
			outList.remove(outIndex);// 판매된 상품에 제품코드 존재
			saveFile();
			return true;
		}

	}

	public String printByFCode(String fCode) {
		String result = "";

		int inIndex = searchInList(fCode);
		int outIndex = searchOutList(fCode);

		if (inIndex > -1) {// 입고상품에 존재

			result = "입고상품 : " + inList.get(inIndex) + "\n";

		} else if (outIndex > -1) {// 판매된 상품에 존재하는 경우

			result = "판매된상품 : " + outList.get(outIndex) + "\n";
		} else {

			result = "존재하지 않는 상품 입니다.";
		}

		return result;
	}

	public void updateInList(int index, int which, Furniture f) {// 어디에 있는 지, 무엇을 바꾸는지, 어떻게 바꾸는지

		if (which == 1) {// 이름을 바꿈
			inList.get(index).setName(f.getName());
		} else if (which == 2) {// 종류를 바꿈
			inList.get(index).setKind(f.getKind());
		} else {// 가격을 바꿈
			inList.get(index).setPrice(f.getPrice());
		}
		saveFile();
	}

	public void updateOutList(int index, int which, Furniture f) {// 어디에 있는 지, 무엇을 바꾸는지, 어떻게 바꾸는지

		if (which == 1) {// 이름을 바꿈
			outList.get(index).setName(f.getName());
		} else if (which == 2) {// 종류를 바꿈
			outList.get(index).setKind(f.getKind());
		} else {// 가격을 바꿈
			outList.get(index).setPrice(f.getPrice());
		}

		saveFile();
	}

}
