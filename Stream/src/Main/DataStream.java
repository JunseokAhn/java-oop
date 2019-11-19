package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 34;
		double height = 165.5;
		double weight = 45.3;
		char gender = 'M';
		boolean marriage = true;

		DataOutputStream DOS = null;
		DataInputStream DIS = null;

		try {
			DOS = new DataOutputStream(new FileOutputStream("resources/primitiveData.bin"));
			DOS.writeInt(age);
			DOS.writeDouble(height);
			DOS.writeDouble(weight);
			DOS.writeChar(gender);
			DOS.writeBoolean(marriage);
			int count=0;
			DIS = new DataInputStream(new FileInputStream("resources/primitiveData.bin"));
			while(count<5) {
				System.out.println(DIS.read());
				count++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (DOS != null)
					DOS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
