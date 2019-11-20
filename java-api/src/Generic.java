import java.util.Scanner;

public class Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ObjectBox O = new ObjectBox(); //타입이 완전하지 않음
		Object a = "hi";
		String aa = (String) a;
		O.putIn(3);
		System.out.println(O.pullOut());
		//String str = (String) O.pullOut(); - 인트에서 스트링, 스트링에서 인트로 형변환x
		int in = (int) O.pullOut();
		GenericBox<String, Integer> strBox = new GenericBox<>(); //스트링,인티저타입
		strBox.setObj("abc");
		System.out.println(strBox.getObj());//앞부분 하나만하는거 가능
		GenericBox objBox = new GenericBox(); //오브젝트타입을 받음
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