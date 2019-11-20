import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello//world/hi//world2";
		
		String [] arr = str.split("/");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		int count=0;
		StringTokenizer token = new StringTokenizer(str, "/");
		while(token.hasMoreTokens()) {
			System.out.println(count+++token.nextToken());
		}
	}
	
}
