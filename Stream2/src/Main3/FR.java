package Main3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class FR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File a = new File("resources/hello.txt");
		FileReader FR = null;
		FileWriter FW = null;
		InputStreamReader ISR = null;
		
		try {
			ISR = new InputStreamReader(new FileInputStream("resources/hello.txt"), "UTF-8");
//			FR = new FileReader("resources/hello.txt");
			FW = new FileWriter("resources/hello_copy3.txt");
		
			while (true) {
				int data = ISR.read();
				if(data==-1)break;
				
				FW.write(data);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ISR.close();
				FW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
