import java.util.Scanner;

public class Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ObjectBox O = new ObjectBox(); //Ÿ���� �������� ����
		Object a = "hi";
		String aa = (String) a;
		O.putIn(3);
		System.out.println(O.pullOut());
		//String str = (String) O.pullOut(); - ��Ʈ���� ��Ʈ��, ��Ʈ������ ��Ʈ�� ����ȯx
		int in = (int) O.pullOut();
		GenericBox<String, Integer> strBox = new GenericBox<>(); //��Ʈ��,��Ƽ��Ÿ��
		strBox.setObj("abc");
		System.out.println(strBox.getObj());//�պκ� �ϳ����ϴ°� ����
		GenericBox objBox = new GenericBox(); //������ƮŸ���� ����
		GenericBox<Double, String> doubleBox = WrapBox.wrap(4.12, "wow"); 
		//==GenericBox<Double, String> doubleBox = WrapBox.<Double,String>wrap(4.12, "wow"); 
		
		
	}

}

class ObjectBox {
	private Object obj;
	
	public Object pullOut() {
		return obj;
	}
	public void putIn(Object obj) {
		this.obj=obj;
	}
}

class GenericBox<T,V>{
	private T obj;
	private V obj2;

	public V getObj2() {
		return obj2;
	}

	public void setObj2(V obj2) {
		this.obj2 = obj2;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}

class WrapBox{
	public static <T,V> GenericBox<T,V> wrap(T obj, V obj2){
		GenericBox<T,V> tempBox = new GenericBox<>();
		tempBox.setObj(obj);
		tempBox.setObj2(obj2);
		
		return tempBox;
	}
}