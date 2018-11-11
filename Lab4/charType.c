//Julian To
//Jcto
//Lab3: charType.c
//Goal: Sort characters from a file based on type

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define MAX_LINE_LENGTH 257 //257 since 256 + 1

//function prototypes
int checkChar(char input);
void placeChars(char* in, char* out_a, char* out_n, char* out_p, char* out_w);
char* print(char* output, char* in, char* out_a, char* out_n, char* out_p, char* out_w);

int main(int argc, char* argv[]) {
	FILE* in; /* file handle for input */
	FILE* out; /* file handle for output */

	char* line; /* char array to read the input line from the file */
	char* alpha; //stores alphabetical character
	char* number; //stores numbers
	char* punct; //stores punctuation
	char* white; //stores whitespace
	char* output; //output string

	int lineCount; //counts the line

	/* check command line for correct number of arguments */
	if (argc != 3) {
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		//exit(EXIT_FAILURE);
	}

	/* open input file for reading */
	in = fopen(argv[1], "r");
	if (in == NULL) {
		printf("Unable to read from file %s\n", argv[1]);
		//exit(EXIT_FAILURE);
	}

	/* open output file for writing */
	out = fopen(argv[2], "w");
	if (out == NULL) {
		printf("Unable to write to file %s\n", argv[2]);
		//exit(EXIT_FAILURE);
	}

	//allocate memory for strings
	line = calloc(MAX_LINE_LENGTH, sizeof(char));
	alpha = calloc(MAX_LINE_LENGTH, sizeof(char));
	number = calloc(MAX_LINE_LENGTH, sizeof(char));
	punct = calloc(MAX_LINE_LENGTH, sizeof(char));
	white = calloc(MAX_LINE_LENGTH, sizeof(char));
	output = calloc(1000, sizeof(char));

	//stolen from Lab3
	//reads lines in while they still exist
	while (fgets(line, MAX_LINE_LENGTH, in) != NULL) {
        placeChars(line, alpha, number, punct, white);
        fprintf(out, "line %d contains:", lineCount);
        print(output, line, alpha, number, punct, white);
        fprintf(out, "%s/n", output);
	}

	/* close input and output files */
	fclose(in);
	fclose(out);

	//frees the memory
	free(output);
	free(line);
	free(alpha);
	free(number);
	free(punct);
	free(white);

	//return (EXIT_SUCCESS);
}

//Takes in a character, then returns an int based on the type of char it is
//0: if alphanumeric
//1: if numeric
//2: if punctuation
//3: if whitespace
int checkChar(char input)
{
    //if alphabetical
    if (isalpha(input) != 0)
    {
        return 0;
    }
    //if numeric
    if (isdigit(input) != 0)
    {
        return 1;
    }
    //check for whitespace
    if (isspace(input) != 0)
    {
        return 3;
    }
    //else its something else (punctuation)
    return 2;
}

//makes an array
//takes in 5 character pointer arguments:
//in is the input
//out_a is the output for alphabetical
//out_n is for numbers
//out_p is for punctuation
//out_w is for whitespace
void placeChars(char* in, char* out_a, char* out_n, char* out_p, char* out_w)
{
    int a = 0, b = 0, c = 0, d = 0, e = 0; //counters for traversing arrays

    while(in[a] != '\0' && a < MAX_LINE_LENGTH)
    {
        //if alphabetical
        if(checkChar(in[a]) == 0)
        {
            out_a[b] = in[a];
            b++;
        }
        //numeric
        else if(checkChar(in[a]) == 1)
        {
            out_n[c] = in[a];
            c++;
        }
        //punctuation
        else if(checkChar(in[a]) == 2)
        {
            out_p[d] = in[a];
            d++;
        }
        //whitespace
        else if(checkChar(in[a]) == 3)
        {
            out_w[e] = in[a];
            e++;
        }
        a++; //increments the traversal of the input array
    }
    //adds terminating char at the end of the array
    out_a[b] = '\0';
    out_n[c] = '\0';
    out_p[d] = '\0';
    out_w[e] = '\0';
}

//prints the result string, all nice and formatted
char* print(char* output, char* in, char* out_a, char* out_n, char* out_p, char* out_w)
{
    //clear the output string
    strcpy(output, "");
    //must check for length of each string to see if you should print out plural or not
    if(strlen(out_a) != 1)
    {
        sprintf(output, "%d alphabetical characters: %s\n", (int)strlen(out_a), out_a);
    }
    else
    {
        sprintf(output, "%d alphabetical character: %s\n", (int)strlen(out_a), out_a);
    }

    if(strlen(out_n) != 1)
    {
        sprintf(output, "%d numeric characters: %s\n", (int)strlen(out_n), out_n);
    }
    else
    {
        sprintf(output, "%d numeric character: %s\n", (int)strlen(out_n), out_n);
    }

    if(strlen(out_p) != 1)
    {
        sprintf(output, "%d punctuation characters: %s\n", (int)strlen(out_p), out_p);
    }
    else
    {
        sprintf(output, "%d punctuation character: %s\n", (int)strlen(out_p), out_p);
    }

    if(strlen(out_w) != 1)
    {
        sprintf(output, "%d whitespace characters: %s\n", (int)strlen(out_w), out_w);
    }
    else
    {
        sprintf(output, "%d whitespace character: %s\n", (int)strlen(out_w), out_w);
    }
}
