//word object that stores a word
class Word {
	String phrase; //the word stored

	public String getWord()
	{
		return this.phrase;
	}
	
	//compares two words
	boolean compare(String other)
	{
		return false;
	}
	//constructor
	public Word(String input)
	{
		this.phrase = input;
	}
	

}
