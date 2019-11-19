package Main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedInputStream BIS = null;
		BufferedOutputStream BOS = null;
		FileInputStream FIS = null;
		FileOutputStream FOS = null;
		try {

			BIS = new BufferedInputStream(FIS = new FileInputStream("resources/hello.txt"));
			BOS = new BufferedOutputStream(FOS = new FileOutputStream("resources/hello_copy2.txt"));
		
			while (true) {
				int data = BIS.read();
				if (data == -1)
					break;
//				System.out.println((char) data);
				BOS.write(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (BIS != null)
					BIS.close();
				if (BOS != null)
					BOS.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
