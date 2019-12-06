package sesoc.english;

public class Dictionary {
	private String word;		// ´Ü¾î
	private String meaning;		// ¶æ
	
	public Dictionary() {
		// TODO Auto-generated constructor stub
	}
	public Dictionary(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	@Override
	public String toString() {
		return  word + ", " + meaning;
	}
	
}
