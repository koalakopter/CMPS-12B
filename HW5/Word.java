//word object that stores a word
class Word {
	String phrase; //the word stored
	int length; //length of said word

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
	public Word(String input, int letters)
	{
		this.phrase = input;
		this.length = letters;
	}
	

}
