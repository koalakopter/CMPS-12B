//LAB 5: It ain't so Bard
//CMPS 12B
//Julian To
//Jcto@ucsc.edu

//import things I might need
//import java.awt.List;
import java.io.*;
import java.util.*;

public class Bard {
	//parses the input to return an output solution
	public static String parse(String input, ArrayList<ArrayList<String>> sortedList, int max)
	{
		//first split around whitespace
		String split[] = input.split("\\s+");
		
		int comm_frequency = Integer.parseInt(split[1]);
		int comm_length = Integer.parseInt(split[0]);
		
		//error checking
		if(comm_length <= 0 || comm_frequency <= -1 || comm_length > max)
		{
			return "-";
		}
		//check if such a word length/frequency can exist
		if(sortedList.get(comm_length).size() <= comm_frequency)
		{
			return "-";
		}
		else {
			return sortedList.get(comm_length).get(comm_frequency);
		}
		//return "-";
	}
	
	//places words in appropriate places
	//inputs are an ArrayList, the generated Hashtable, and the length of the longest word
	public static ArrayList<ArrayList<String>> 
		place(ArrayList<ArrayList<String>> input, Hashtable<String, Integer> hash, int longword)
	{
		//adds each element in the Hashtable to the ArrayList
		int length = 0;
		Set <String> keys = hash.keySet();
		//make x array Lists inside the outer ArrayList, where x = longest word length
		for(int i = 0; i <= longword; i++)
		{
			ArrayList<String> inner = new ArrayList<String>();
			input.add(inner);
		}
		for(String s : keys)
		{
			length = s.length();
			//uh I guess we have blank entries, so we ignore those
			if(length <= 0)
			{
				continue;
			}
			
			//if its the first item in the list, 
			//place the string on the inner list with no problemo
			if(input.get(length).size() == 0)
			{
				//System.out.println(s);
				input.get(length).add(s);
				continue;
			}
			//else add in a sorted manner
			else
			{
				int iterate = 0;
				//adds things to LinkedLists in a sorted manner
				while(true)
				{
					//check for out of bounds cases
					//aka if it reaches the end of the list, just add it
					if(iterate >= input.get(length).size())
					{
						input.get(length).add(iterate, s);
						break;
					}
					//first compare frequencies
					//if word you are trying to add has a lower frequency, move to next element
					if(hash.get(s) < hash.get(input.get(length).get(iterate)))
					{
						iterate++;
						continue;
					}
					//if the frequencies are equal, 
					//check for lexicographic order
					if(hash.get(s).equals(hash.get(input.get(length).get(iterate))))
					{
						/*
						if(s.equals("personal"))
						{
							System.out.println("please ");
						}
						*/
						//System.out.println("TRIGGERED");
						if(s.compareTo(input.get(length).get(iterate)) >= 0)
						{
							//System.out.println("TRIGGERED");
							iterate++;
							continue;
						}
						else
						{
							//System.out.println(s);
							input.get(length).add(iterate, s);
							break;
						}
					}
					//if its in the right place, just add it
					else
					{
						input.get(length).add(iterate, s);
						break;
					}
				}
			}
		}
		//test
		//System.out.println("query: " + input.get(5).get(1));
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
		
		//System.out.println("Done " + words.size());
		int max_length = 0; //max length of any word
		
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
				//finds the max length of any string (its 36 for Shakespeare.txt)
				if(w.phrase.length() > max_length)
				{
					max_length = w.phrase.length();
				}
			}
		}
		
		//TEST ZONE
		/*
		System.out.println("YEET " + max_length);
		System.out.println("wheee " + frequency.get("the"));
		System.out.println("meme " + frequency.get("personal"));
		
		Set <String> keys = frequency.keySet();
		for (String s : keys)
		{
			out.println(s + "   " + frequency.get(s));
		}
		*/
		
		//now we put everything in a 2d LINKED LIST
		//first list (outer Linked List) will be the length of the string
		//second list (inner Linked List) will contain the words in lexicographic order
		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		
		outer = place(outer, frequency, max_length);
		
		//TEST ZONE NUMBA TWO
		//System.out.println("query: " + outer.get(3).get(5));
		//System.out.println("query2 " + outer.get(26).size());
		System.out.println("query: " + frequency.get("personal"));
		String koala = "personal";
		String koala2 = "business";
		System.out.println("query2: " + koala.compareTo(koala2));
		
		
		int breakpoint = 0;
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
				//System.out.println(parse(token[i], outer, max_length));
				out.println(parse(token[i], outer, max_length));
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
