package Main;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataInputStream DIS = null;

		try {
			DIS = new DataInputStream(new FileInputStream("resources/primitiveData.bin"));
			System.out.println(DIS.readInt());
			System.out.println(DIS.readDouble());
			System.out.println(DIS.readDouble());
			System.out.println(DIS.readChar());
			System.out.println(DIS.readBoolean());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (DIS != null)
				try {
					DIS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}

}
