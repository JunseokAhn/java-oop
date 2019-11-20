package Main3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStreamReader ISR = null; //���� ��Ʈ���̶� �ѱ۵� ����

		try {
			ISR = new InputStreamReader(new FileInputStream("resources/hello.txt"), "UTF-8");//���� ���ڵ��� UTF8�� ������, ,"UTF-8"�� �޾ƿ´�.
			while (true) {
				int cnt = ISR.read();
				if (cnt == -1)
					break;
				System.out.print((char)cnt);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ISR!=null)
				try {
					ISR.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
