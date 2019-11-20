package Main3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File a = new File("resources/test.txt");
		BufferedWriter BW = null;
		try {
			BW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resources/test.txt")));
			if (a.exists() == false)
				a.createNewFile();
			String b = "a";
			int cnt = 0;
			while (cnt < 5) {
				BW.write(b);
				BW.write(cnt);
				cnt++;
			}
			System.out.println("절대경로 : " + a.getAbsolutePath());
			System.out.println("상대경로 : " + a.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				BW.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
