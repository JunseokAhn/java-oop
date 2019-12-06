package sesoc.manager;

import java.io.IOException;

import sesoc.english.Dictionary;

public interface EnglishExamService {
	
	/**
	 * dicList�� ����� ��� �ܾ���� ������� ���� dicExam List�� �����Ѵ�.
	 */
	public void suffle() ;
	
	/** ������ ���� ���� �Է� �޴´�.
	 *  ����ų� Ʋ�� ��� �� ������ ���� ����� ox �迭�� �����Ѵ�. 
	 *  ���� ������ rightCount ������ ī��Ʈ�Ѵ�. 
	 * @throws IOException
	 */
	public void solution() throws IOException;

	/**
	 * ���� ����� ���� �޼ҵ�
	 */
	public void score() ;
	/**
	 * keyIn, br �� ����� resource�� �ݳ�
	 */
	public void closeAll() ;
}
