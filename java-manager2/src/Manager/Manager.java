package Manager;

import java.util.ArrayList;

import VO.CodeVO;
import VO.kanzya;

public class Manager {

	ArrayList<kanzya> list = new ArrayList<>();

	private static int index;

	public boolean Check(int num) {
		for (int i=0; i<list.size(); i++)
			if (list.get(i).getNum() == num) {
				index = i;
				return true;
			}
		return false;
	}

	public boolean register(kanzya K) {
		
		list.add(K);

		return true;
	}

	public boolean search() {

		System.out.println(list.get(index));

		return Check(index);
	}

	public boolean insert(int days, String code) {
		list.get(index).insert(new CodeVO(list.get(index).getNum(), code, days, list.get(index).getAge()));
		return true;
	}

	public void searchAll() {

		for (kanzya i : list) {
			System.out.println(i.print());
		}

	}

	public boolean out() {
		list.remove(index);
		return true;
	}

	public void seisan(int kinngaku) { // TODO Auto-generated method stub
		list.get(index).seisan(kinngaku);

	}
}