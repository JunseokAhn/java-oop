package sesoc.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import sesoc.english.Dictionary;

public class EnglishExamServiceImpl implements EnglishExamService {
	BufferedReader br = null;
	BufferedReader keyIn = null;

	List<Dictionary> dicList = new ArrayList<>(); // ��� ���� �ܾ�
	List<Dictionary> dicExam = new ArrayList<>(); // ���� Ǯ��� �� ���� �ܾ�. dicList�� �ܾ ���� �� 20���� ���߷� ���� List

	String answer = null; // ���� �Է¹ޱ� ���� ����
	int rightCount = 0; // ���� ������ ���� ���� ����
	final int EXAM_COUNT = 20; // Ǯ��� �� ���� ��
	String[] ox = new String[EXAM_COUNT]; // O, X ���θ� �ֱ� ���� �迭

	/**
	 * ���Ͽ� �ִ� ��� �ܾ �о� �鿩 ArrayList�� �����Ѵ�. �ܾ�� �ǹ̴� '#'���� ���еǾ� �ִ�. �ܾ �ϰ� ArrayList��
	 * ��� ���� �� �� �ߺ����� �ʴ� �ܾ� 20���� ��� ���� dicExam�� �����Ѵ� : suffle() ���� �۾��� ������ ������ Ǭ��.
	 * solution() ������ �� �ذ��ϰ� �� ���Ŀ��� ������ ������ 20������ ���� ����� ����Ѵ�. ��� �ڿ��� �ݳ��Ѵ�.
	 */
	public EnglishExamServiceImpl() throws Exception {
		// Code Here
		File f = new File("C:\\Users\\user\\Google ����̺�\\eclipse space\\syuugyou\\Homework_38_JavaIO\\english.txt");
		if (f.exists()) {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

			while (true) {
				String temp2 = br.readLine();
				if (temp2 == null)
					break;
				String temp3[] = temp2.split("#");
				dicList.add(new Dictionary(temp3[0], temp3[1]));

			}

			suffle();
		} else {
			System.out.println("������ �����ϴ�");
		}
	}

	/**
	 * dicList�� ����� ��� �ܾ���� ������� ���� dicExam List�� �����Ѵ�.
	 */
	@Override
	public void suffle() {
		// Code Here

//		dicExam = dicList;
//		Collections.shuffle(dicExam);
		Random R = new Random();

		for (int i = 0; i < EXAM_COUNT; i++) {

			int b = R.nextInt(dicList.size());
			dicExam.add(dicList.get(b));

			for (int j = 0; j < i; j++) {

				if (dicExam.get(j) == dicExam.get(i)) {
					i--;

				}
			}
		}

		try {
			solution();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * ������ ���� ���� �Է� �޴´�. ����ų� Ʋ�� ��� �� ������ ���� ����� ox �迭�� �����Ѵ�. ���� ������ rightCount ������
	 * ī��Ʈ�Ѵ�.
	 * 
	 * @throws IOException
	 */
	@Override
	public void solution() throws IOException {
		// Code Here

		for (int i = 0; i < EXAM_COUNT; i++) {
			System.out.println("���� " + (i + 1) + ") " + dicExam.get(i).getMeaning());
			String temp = dicExam.get(i).getWord();
			System.out.println("[ hint ]  ���� : " + temp.length() + ", ù ���� : " + temp.charAt(0));
			System.out.print("�� > ");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();
			if (answer.equals(temp)) {
				System.out.println("�¾ҽ��ϴ�.");
				rightCount++;
				ox[i] = "O";
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				ox[i] = "X";
			}
		}

		score();

	}

	/**
	 * ���� ����� ���� �޼ҵ�
	 */
	@Override
	public void score() {
		// Code Here
		System.out.println(">>����� ���� : " + rightCount * 5);
		for (int i = 0; i < EXAM_COUNT; i++) {
			System.out.println(
					(i + 1) + "��) " + dicExam.get(i).getWord() + ", " + dicExam.get(i).getMeaning() + ",  " + ox[i]);
		}
	}

	/**
	 * keyIn, br �� ����� resource�� �ݳ�
	 */
	@Override
	public void closeAll() {
		// Code Here
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
