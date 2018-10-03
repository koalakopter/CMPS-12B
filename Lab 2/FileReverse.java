//Julian To
//CMPS 12B
//Takes in two files, reverses each word, then splits it onto its own line

import java.io.*;
import java.util.Scanner;

class FileReverse {
	   //method required by lab manual
	   //given a string s, it reverses the order of the string
	   public static String stringReverse(String s)
	   {
		 int length = s.length(); //length of input string
		 int y = 0;
		 String output = "";
		 for (int x = length-1; x >= 0; x--)
		 {
			 //reads the character starting from the right 
			 char c = s.charAt(x);
			 
			 //and puts it onto the left of the output string
			 output = output + c;
			 y++;
		 }
	   	 return output;
	   }
	   public static void main(String[] args) throws IOException{

		      int lineNumber = 0;

		      // check number of command line arguments is at least 2
		      if(args.length < 2){
		         System.out.println("Usage: java –jar FileTokens.jar <input file> <output file>");
		         System.exit(1);
		      }
		      /*
		      // open files
		      Scanner in = new Scanner(new File(args[0]));
		      PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		      // read lines from in, extract and print tokens from each line
		      while( in.hasNextLine() ){
		         lineNumber++;

		         // trim leading and trailing spaces, then add one trailing space so 
		         // split works on blank lines
		         String line = in.nextLine().trim() + " "; 

		         // split line around white space 
		         String[] token = line.split("\\s+");  

		         //print out tokens       
		         int n = token.length;
		         //out.println("Line " + lineNumber + " contains " + n + " tokens:");
		         for(int i=0; i<n; i++){
		            out.println("  "+token[i] + n);
		         }
		      }
			  // close files
		      in.close();
		      out.close();
		      */
		      String fun = "this is fun";
		      fun = stringReverse(fun);
		      System.out.println(fun);
		   }
		}


