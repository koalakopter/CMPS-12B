//LAB 5: It ain't so Bard
//CMPS 12B
//Julian To
//Jcto@ucsc.edu

//import things I might need
import java.io.*;
import java.util.*;

public class Bard {

	//main function that parses strings
	public static void main(String[] args) throws IOException {

		// check number of command line arguments is at least 2

	
		if (args.length < 2) {
			System.out.println("Usage: java -jar Bard.jar <input file> <output file>");
			System.exit(1);
		}

		// Copied from Lab 2
		// open files
		Scanner in = new Scanner(new File(args[0]));
		Scanner shakespeare = new Scanner(new File("shakespeare.txt"));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		
		//new Hashtables
		//one stores frequency, the other the length
		//hashtable constructor is key, value
		Hashtable <String, Integer> frequency = new Hashtable<String, Integer> ();
		Hashtable <String, Integer> length = new Hashtable<String, Integer> ();
		
		//ArrayList of word objects
		ArrayList <Word> words = new ArrayList<Word>();
		
		//first process the entire shakespeare.txt, turning it into a String array
		while (shakespeare.hasNextLine() == true)
		{
			//like reading the input, but with shakespeare instead
			String shake_line = shakespeare.nextLine().trim() + " "; 
			 //split around punctuation and white space
			String[] shake_token = shake_line.split("[\\s\\?\\,\\.\\!\\:\\;\\[\\]]+");
			
			//lowercases all tokens
			//and puts them into an Array List for good measure?
			for (String x : shake_token)
			{
				x = x.toLowerCase();
				//constructors are string and length of string
				words.add(new Word(x, x.length()));
			}
		}
		
		//loops through ArrayList and adds words
		for(Word w : words)
		{
			//number of times a word appeared
			int count = 0;
			//check if we have counted a word yet
			if(frequency.containsKey(w) == false)
			{
				//double for loop counts the times that word has appeared
				for(Word t : words)
				{
					//check if the words are equal, then count up
					if(t.equals(w))
					{
						count++;
					}
				}
				//then add stuff to hashtable
				length.put(w.phrase, w.length);
				frequency.put(w.phrase, count);
			}
		}
		/*
		//le test
		//901,724 words btw
		int wa2k = 0;
		for (Word x : words)
		{
			out.println(x.phrase);
			if(x.phrase.equals("business"))
			{
				wa2k++;
			}
		}
		System.out.println("this word appeared: " + wa2k + " times");
		*/
		
		
		
		// read lines from in, extract and print tokens from each line
		while (in.hasNextLine()) {
			// lineNumber++; //what does this even do

			// trim leading and trailing spaces, then add one trailing space so
			// split works on blank lines
			String line = in.nextLine().trim() + " ";

			// split line around white space
			//String[] token = line.split("\\s+");
			String[] token = line.split("\\r?\\n\"");

			int n = token.length;


			
			for (int i = 0; i < n; i++) {

			}
		}
		
		// close files
		in.close();
		out.close();
		shakespeare.close();
		
	
		/*
		// TESTING CORNER
			String[] token = new String[3];
			token[0] = "FUGG";
			token[1] = "KOALA";
			token[2] = "MEME";
			for(String x : token)
			{
				x = x.toLowerCase();
				System.out.println(x);
			}
		*/
	}
	
}
