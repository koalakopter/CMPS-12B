//LAB 5: It ain't so Bard
//CMPS 12B
//Julian To
//Jcto@ucsc.edu

//import things I might need
import java.awt.List;
import java.io.*;
import java.util.*;

public class Bard {
	//parses the input to return an output solution
	public static String parse(String input)
	{
		//first split around whitespace
		String split[] = input.split("\\s+");
		
		int comm_frequency = Integer.parseInt(split[1]);
		int comm_length = Integer.parseInt(split[0]);
		
		//error checking
		if(comm_length <= 0 || comm_frequency <= -1)
		{
			return "-";
		}
		
		
		return "-";
	}
	
	//places words in appropriate places
	//inputs are an ArrayList and the generated Hashtable
	public static ArrayList<ArrayList<String>> 
		place(ArrayList<ArrayList<String>> input, Hashtable<String, Integer> hash)
	{
		//adds each element in the Hashtable to the ArrayList
		Set<String> keys = hash.keySet();
		int length = 0;
		for(String s : keys)
		{
			System.out.println("what?");
			length = s.length();
			//if ArrayList (outer value), or length, doesn't exist, add it
			try
			{
				input.get(length);
			}
			catch (IndexOutOfBoundsException e)
			{
				ArrayList <String> inner = new ArrayList<String>();
				input.add(length, inner);
				inner.add(s);
				continue;
			}
			//if the outer value does exist, just add the String into the inner Linked List
			input.get(length).add(s);
		}
		
		return input;
	}

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
		
		//ArrayList of word objects
		ArrayList <Word> words = new ArrayList<Word>();
		
		//first process the entire shakespeare.txt, turning it into a String array
		while (shakespeare.hasNextLine() == true)
		{
			//like reading the input, but with shakespeare instead
			String shake_line = shakespeare.nextLine().trim() + " "; 
			 //replace each special character with whitespace
			//shake_line = shake_line.replaceAll("\\?\\,\\.\\:\\;\\[\\]", " ");
			
			shake_line = shake_line.replaceAll("\\?", " ");
			shake_line = shake_line.replaceAll("\\,", " ");
			shake_line = shake_line.replaceAll("\\.", " ");
			shake_line = shake_line.replaceAll("\\!", " ");
			shake_line = shake_line.replaceAll("\\:", " ");
			shake_line = shake_line.replaceAll("\\;", " ");
			shake_line = shake_line.replaceAll("\\[", " ");
			shake_line = shake_line.replaceAll("\\]", " ");
			
			String[] shake_token = shake_line.trim().split("\\s+"); //split around white space
			//String[] shake_token = shake_line.split("[\\s\\?\\,\\.\\!\\:\\;\\[\\]]+");
			
			//lowercases all tokens
			//and puts them into an Array List for good measure?
			for (String x : shake_token)
			{
				x = x.toLowerCase();
				//constructors are string and length of string
				words.add(new Word(x, x.length()));
			
			}
		}
		
		/*
		//check if words were read right
		for (Word f : words)
		{
			out.println(f.phrase);
		}
		*/
		
		System.out.println("Done " + words.size());
		//loops through ArrayList and adds words to Hashtable
		//int meme = 0;
		for(Word w : words)
		{
			//31504 unique words wtf my computer is dying
			//check if we have counted a word yet
			//if we have, update the existing key
			if(frequency.containsKey(w.phrase) == true)
			{
				int count = frequency.get(w.phrase);
				//System.out.println(count + " ");
				frequency.put(w.phrase, count+1); //if the word is present, we increase the count by 1
				
			}
			//if not present, initialize the key phrase with value 1, (cause it appeared once)
			else {
				//meme++;
				frequency.put(w.phrase, 1);
			}
		}
		
		//TEST ZONE
		//System.out.println("YEET " + meme);
		System.out.println("wheee " + frequency.get("the"));
		System.out.println("meme " + frequency.get("personal"));
		
		//now we put everything in a 2d LINKED LIST
		//first list (outer Linked List) will be the length of the string
		//second list (inner Linked List) will contain the words in lexicographic order
		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		
		outer = place(outer, frequency);
		
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
				System.out.println(parse(token[i]));
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
