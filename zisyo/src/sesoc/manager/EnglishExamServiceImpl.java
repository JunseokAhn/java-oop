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

	List<Dictionary> dicList = new ArrayList<>(); // 모든 영어 단어
	List<Dictionary> dicExam = new ArrayList<>(); // 오늘 풀어야 할 영어 단어. dicList의 단어를 섞은 후 20개만 간추려 담은 List

	String answer = null; // 답을 입력받기 위한 변수
	int rightCount = 0; // 맞은 개수를 세기 위한 변수
	final int EXAM_COUNT = 20; // 풀어야 할 문제 수
	String[] ox = new String[EXAM_COUNT]; // O, X 여부를 넣기 위한 배열

	/**
	 * 파일에 있는 모든 단어를 읽어 들여 ArrayList에 저장한다. 단어와 의미는 '#'으로 구분되어 있다. 단어를 일거 ArrayList에
	 * 담고 나면 그 중 중복되지 않는 단어 20개를 섞어서 고른후 dicExam에 저장한다 : suffle() 섞는 작업이 끝나면 문제를 푼다.
	 * solution() 문제를 다 해결하고 난 이후에는 오늘의 점수와 20문제에 대한 결과를 출력한다. 모든 자원을 반납한다.
	 */
	public EnglishExamServiceImpl() throws Exception {
		// Code Here
		File f = new File("C:\\Users\\user\\Google 드라이브\\eclipse space\\syuugyou\\Homework_38_JavaIO\\english.txt");
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
			System.out.println("파일이 없습니다");
		}
	}

	/**
	 * dicList에 저장된 모든 단어들을 대상으로 섞어 dicExam List에 저장한다.
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
	 * 문제를 내고 답을 입력 받는다. 맞출거나 틀릴 경우 그 문제에 대한 결과를 ox 배열에 저장한다. 맞춘 개수만 rightCount 변수에
	 * 카운트한다.
	 * 
	 * @throws IOException
	 */
	@Override
	public void solution() throws IOException {
		// Code Here

		for (int i = 0; i < EXAM_COUNT; i++) {
			System.out.println("문제 " + (i + 1) + ") " + dicExam.get(i).getMeaning());
			String temp = dicExam.get(i).getWord();
			System.out.println("[ hint ]  길이 : " + temp.length() + ", 첫 글자 : " + temp.charAt(0));
			System.out.print("답 > ");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();
			if (answer.equals(temp)) {
				System.out.println("맞았습니다.");
				rightCount++;
				ox[i] = "O";
			} else {
				System.out.println("틀렸습니다.");
				ox[i] = "X";
			}
		}

		score();

	}

	/**
	 * 점수 출력을 위한 메소드
	 */
	@Override
	public void score() {
		// Code Here
		System.out.println(">>당신의 점수 : " + rightCount * 5);
		for (int i = 0; i < EXAM_COUNT; i++) {
			System.out.println(
					(i + 1) + "번) " + dicExam.get(i).getWord() + ", " + dicExam.get(i).getMeaning() + ",  " + ox[i]);
		}
	}

	/**
	 * keyIn, br 등 사용한 resource를 반납
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
