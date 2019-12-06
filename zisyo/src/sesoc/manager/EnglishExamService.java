package sesoc.manager;

import java.io.IOException;

import sesoc.english.Dictionary;

public interface EnglishExamService {
	
	/**
	 * dicList에 저장된 모든 단어들을 대상으로 섞어 dicExam List에 저장한다.
	 */
	public void suffle() ;
	
	/** 문제를 내고 답을 입력 받는다.
	 *  맞출거나 틀릴 경우 그 문제에 대한 결과를 ox 배열에 저장한다. 
	 *  맞춘 개수만 rightCount 변수에 카운트한다. 
	 * @throws IOException
	 */
	public void solution() throws IOException;

	/**
	 * 점수 출력을 위한 메소드
	 */
	public void score() ;
	/**
	 * keyIn, br 등 사용한 resource를 반납
	 */
	public void closeAll() ;
}
