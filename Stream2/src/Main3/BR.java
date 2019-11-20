package Main3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class BR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader BR = null;
		BufferedWriter BW = null;

		try {
			BR = new BufferedReader(new InputStreamReader(new FileInputStream("resources/hello.txt"), "UTF-8"));
			BW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resources/hello_copy4.txt")));

			while (true) {
				int data = BR.read();
				if (data == -1)
					break;
				BW.write(data);
			}
				BW.newLine();
				BW.write("meatarasii");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (BR != null || (BW != null))
				try {
					BR.close();
					BW.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
