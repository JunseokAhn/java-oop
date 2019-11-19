package Main2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectInputStream OIS = null;
		
		try {
			OIS = new ObjectInputStream(new FileInputStream("resources/userList.dat"));
			
			User Iee = (User) OIS.readObject();
			User kim = (User) OIS.readObject();
			
			System.out.println(kim);
			System.out.println(Iee);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
