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

	private ArrayList<Furniture> inList = new ArrayList<>();// �԰�Ȼ�ǰ
	private ArrayList<Furniture> outList = new ArrayList<>();// �ǸŵȻ�ǰ

	private FileOutputStream fos; // ���� ����� ��Ʈ��
	private ObjectOutputStream oos;// ��ü ����	�� ��Ʈ��

	private FileInputStream fis;// ���� ��������� ��Ʈ��
	private ObjectInputStream ois;// ��ü ��������� ��Ʈ��

	public FurnitureManager() {// �޴��� ������, ���α׷� ���۽� ȣ��
		loadFile();// ���� �ε�
	}

	public void saveFile() {// ���� ���� �޼���

		try {
			fos = new FileOutputStream("inListSave.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(inList); // �԰�� ��ǰ ��������
			oos.close();

			fos = new FileOutputStream("outListSave.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(outList); // ���� ��ǰ ��������
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadFile() {// ���� �ε� �޼���, ���α׷� ���۽� 1ȸ ȣ��

		File in = new File("inListSave.dat");
		File out = new File("outListSave.dat");

		if (in.exists() && out.exists()) {

			try {

				fis = new FileInputStream(in);
				ois = new ObjectInputStream(fis);
				inList = (ArrayList<Furniture>) ois.readObject();// �԰����ǰ�ε�
				ois.close();

				fis = new FileInputStream(out);
				ois = new ObjectInputStream(fis);
				outList = (ArrayList<Furniture>) ois.readObject();// ������ǰ�ε�
				ois.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean insertFurniture(Furniture f) {// ���� ���
		boolean result = false;

		int inResult = searchInList(f.getfCode());
		int outResult = searchOutList(f.getfCode());

		if (inResult == -1 && outResult == -1) {// ��ǰ�ڵ尡 ���,�԰�� ��ǰ�� �������� ����
			inList.add(f);
			result = true;// ���, ������
			saveFile();// ���Ͽ� ����
		}

		return result;
	}

	public String printAllIn() {// �԰��ǰ ��ü ���
		String result = "";

		for (int i = 0; i < inList.size(); i++) {

			result += inList.get(i) + "\n";

		}

		return result;
	}

	public String printAllOut() {// �Ǹŵ� ��ǰ ��ü ���
		String result = "";

		for (int i = 0; i < outList.size(); i++) {

			result += outList.get(i) + "\n";

		}
		return result;
	}

	public int searchInList(String fCode) {// �԰�� ��ǰ���� ��ǰ�ڵ� �˻�, �����ϸ� index ��ȯ, �������� ������ -1 ��ȯ
		int result = -1;// �ʱⰪ -1, �������� �ʴ´ٸ� �״�� ��ȯ

		for (int i = 0; i < inList.size(); i++) {
			if (inList.get(i).getfCode().equals(fCode)) {
				result = i;
			}
		}
		return result;
	}

	public int searchOutList(String fCode) {// ���� ��ǰ���� ��ǰ�ڵ� �˻�, �����ϸ� index ��ȯ, �������� ������ -1 ��ȯ
		int result = -1;// �ʱⰪ -1, �������� �ʴ´ٸ� �״�� ��ȯ

		for (int i = 0; i < outList.size(); i++) {
			if (outList.get(i).getfCode().equals(fCode)) {
				result = i;
			}
		}
		return result;
	}

	public String printByKind(String kind) {// ������ ���
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

		if (inIndex == -1 && outIndex == -1) {// �������� �ʴ� ��ǰ�ڵ�
			return false;
		} else if (inIndex != -1) {
			inList.remove(inIndex);// ��� ��ǰ�ڵ� ����
			saveFile();
			return true;
		} else {
			outList.remove(outIndex);// �Ǹŵ� ��ǰ�� ��ǰ�ڵ� ����
			saveFile();
			return true;
		}

	}

	public String printByFCode(String fCode) {
		String result = "";

		int inIndex = searchInList(fCode);
		int outIndex = searchOutList(fCode);

		if (inIndex > -1) {// �԰��ǰ�� ����

			result = "�԰��ǰ : " + inList.get(inIndex) + "\n";

		} else if (outIndex > -1) {// �Ǹŵ� ��ǰ�� �����ϴ� ���

			result = "�ǸŵȻ�ǰ : " + outList.get(outIndex) + "\n";
		} else {

			result = "�������� �ʴ� ��ǰ �Դϴ�.";
		}

		return result;
	}

	public void updateInList(int index, int which, Furniture f) {// ��� �ִ� ��, ������ �ٲٴ���, ��� �ٲٴ���

		if (which == 1) {// �̸��� �ٲ�
			inList.get(index).setName(f.getName());
		} else if (which == 2) {// ������ �ٲ�
			inList.get(index).setKind(f.getKind());
		} else {// ������ �ٲ�
			inList.get(index).setPrice(f.getPrice());
		}
		saveFile();
	}

	public void updateOutList(int index, int which, Furniture f) {// ��� �ִ� ��, ������ �ٲٴ���, ��� �ٲٴ���

		if (which == 1) {// �̸��� �ٲ�
			outList.get(index).setName(f.getName());
		} else if (which == 2) {// ������ �ٲ�
			outList.get(index).setKind(f.getKind());
		} else {// ������ �ٲ�
			outList.get(index).setPrice(f.getPrice());
		}

		saveFile();
	}

}
