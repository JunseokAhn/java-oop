package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import VO.Syouhinn;

public class Manager {

	private int choice;
	private int code; // 제품을 사면 0부터 1씩 올라감
	private String name;
	private int nedan;
	private int money;
	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);

	ArrayList<Syouhinn> sellList;
	ArrayList<Syouhinn> soldList;

	ObjectInputStream OIS;
	ObjectOutputStream OOS;

	public Manager() {
		sellList = new ArrayList<>();
		soldList = new ArrayList<>();
		money = 1000000;
		code = 0;
		load();
	}

	public boolean save() {

		try {
			OOS = new ObjectOutputStream(new FileOutputStream("SaveFile/sellList.dat"));
			OOS.writeObject(sellList);
			OOS.close();
			OOS = new ObjectOutputStream(new FileOutputStream("SaveFile/soldList.dat"));
			OOS.writeObject(soldList);
			OOS.close();
			OOS = new ObjectOutputStream(new FileOutputStream("SaveFile/money"));
			OOS.writeInt(money);
			OOS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean load() {
		try {
			File a = new File("SaveFile/sellList.dat");
			File b = new File("SaveFile/soldList.dat");
			if (a.exists() || b.exists() == false) {
			} else {
				OIS = new ObjectInputStream(new FileInputStream("SaveFile/sellList.dat"));
				sellList = (ArrayList<Syouhinn>) OIS.readObject();
				OIS.close();
				OIS = new ObjectInputStream(new FileInputStream("SaveFile/soldList.dat"));
				soldList = (ArrayList<Syouhinn>) OIS.readObject();
				OIS.close();
				OIS = new ObjectInputStream(new FileInputStream("SaveFile/money"));
				money = OIS.readInt();
				OIS.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void nedan(String name) {

		if (name.equals("의자"))
			nedan = 25000;
		if (name.equals("배게"))
			nedan = 10000;
		if (name.equals("침대"))
			nedan = 1200000;
		if (name.equals("소파"))
			nedan = 800000;
		if (name.equals("책상"))
			nedan = 200000;
		if (name.equals("식탁"))
			nedan = 80000;

	}

	public boolean resister(String name) {
		nedan(name);
		if (nedan > money) {
			System.out.println("자금이 부족합니다.");
			return false;
		}
		System.out.print("판매가를 입력해주세요 : ");
		int nedan2 = sc.nextInt();
		money -= nedan;
		getMoney();
		Syouhinn S = new Syouhinn(code++, name, nedan2);
		sellList.add(S);
		save();
		return true;
	}

	public boolean sell(int code) {
		for (Syouhinn i : sellList) {
			if (i.getCode() == (code)) {
				soldList.add(sellList.get(code));
				money += i.getNedan();
				getMoney();
				sellList.remove(code);
				save();
				return true;
			}
		}
		return false;
	}

	public boolean search(String name) {
		boolean result = false;
		for (Syouhinn i : sellList) {
			if (i.getName().equals(name)) {
				System.out.println(i.getName());
				result = true;
			}
		}
		return result;
	}

	public void searchAll() {
		for (Syouhinn i : sellList)
			System.out.println(i);
	}

	public boolean change(int code) {
		for (Syouhinn i : sellList) {
			if (i.getCode() == code) {
				System.out.print("변경할 가격을 입력하세요 : ");
				i.setNedan(sc.nextInt());
				save();
				return true;
			}
		}
		return false;
	}

	public void getMoney() {
		// TODO Auto-generated method stub
		System.out.println("현재 금액 : " + money);
	}

	public void getSoldList() {
		// TODO Auto-generated method stub
		for (Syouhinn i : soldList)
			System.out.println(i);
	}

	public boolean remove(int nextInt) {
		// TODO Auto-generated method stub
		for (Syouhinn i : soldList) {
			if (i.getCode() == nextInt) {
				soldList.remove(i);
				save();
				return true;
			}
		}
		return false;
	}
}
