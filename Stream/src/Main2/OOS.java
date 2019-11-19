package Main2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OOS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectOutputStream OOS = null;
		User kim = new User("±ט", 40, 170, 160, 'M', true);
		User Iee = new User("ÀÌ", 140, 2170, 560, 'F', false);

		try {
			OOS = new ObjectOutputStream(new FileOutputStream("resources/userList.dat"));
			OOS.writeObject(kim);
			OOS.writeObject(Iee);
			System.out.println("dd");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (OOS != null)
				try {
					OOS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
