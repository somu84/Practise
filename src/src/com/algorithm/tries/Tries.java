package src.com.algorithm.tries;

public class Tries {
	private int NUMBER_OF_CHARS = 26;
	char c;
	Tries[] children = new Tries[NUMBER_OF_CHARS];
	boolean word;
	int size;
	
	public Tries(){
		this.c = 0;
		this.word = false;
		this.size = 0;
	}
	
	public void add(String s){
		if(s.isEmpty()){
			this.word = false;
			return;
		}
		
		char letter = s.charAt(0);
		int index = letter - 'a'; //ascii index
		
		if(this.children[index] == null)
		{
			this.children[index] = new Tries();
		}
		this.children[index].add(s.substring(1));
	}
	
	public boolean isWord(String s)
	{
		if(s.isEmpty())
		{
			return this.word;
		}
		char letter = s.charAt(0);
		int index = letter - 'a';
		
		if(this.children[index] == null) return false;
		
		return this.children[index].isWord(s.substring(1));
	}
	
	public void printAllWords(){
		
	}
}


