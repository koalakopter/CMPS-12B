//LAB 5: It ain't so Bard
//CMPS 12B
//Julian To
//Jcto@ucsc.edu

//import things I might need
import java.io.*;
import java.util.*;

public class Bard {
	//processes the String array
	//turns it into an Array List
	public static String[] process(String input)
	{
		
		
		return output;
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
		
		//first process the entire shakespeare.txt, turning it into a String array
		while (shakespeare.hasNextLine() == true)
		{
			//like reading the input, but with shakespeare instead
			String shake_line = shakespeare.nextLine().trim() + " "; 
			String shake_token = line.split()
		}
		
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
		
	
		/*
		// TESTING CORNER

		*/
	}
	
}
