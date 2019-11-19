package Main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class BufferedOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedInputStream BIS = null;
		BufferedOutputStream BOS = null;

		try {
			BIS = new BufferedInputStream(new FileInputStream("resources/KakaoTalk.jpg"));
			BOS = new BufferedOutputStream(new FileOutputStream("resources/KakaoTalk_copy.jpg"));
			int data;
			while (true) {
				data = BIS.read();
				if (data == -1) {
					break;
				}
			
			}
			BOS.write(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (BOS != null) {
					BOS.close();
				}
				if (BIS != null) {
					BIS.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
