package Main4;

public class cake {

	private int cakeNum;
	private boolean empty;
	
	
	public cake() {
		cakeNum=0;	
		empty=true;
	}
	
	
	public void produce(int cakeNum) {
		while(!empty) {
			
		}
		
		this.cakeNum = cakeNum;
	}
	
	public int counsume() {
		while(empty) {
			
		}
		empty = true;
		
		return cakeNum;
	}
	
	public int getCakeNum() {
		return cakeNum;
	}

	public void setCakeNum(int cakeNum) {
		this.cakeNum = cakeNum;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	
}
