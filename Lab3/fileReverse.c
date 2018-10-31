/*
 * by: Julian To, (jcto@ucsc.edu)
 * for: CMPS 12B
 * Lab 3
 *  fileReverse
 *  Reads input file and prints each word on a separate line of
 *  the output file, but REVERSED.
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//takes in a String, then reverses it
void stringReverse(char* s)
{
    //printf("yeahhh %s\n", s);
    int size = strlen(s);
    //printf("size of string: %d\n", size);
    char newString[size];
    int counter = 0;
    //first, stores the reversed string in a temporary char array
    for (int i = 0, j = size-1; i < size; i++, j--)
    {

        newString[j] = s[i];
        counter++;
    }
    //then, copies the characters back to the original input string pointed to by pointer s
    while (counter > 0)
    {
        s[counter-1] = newString[counter-1];
        counter--;
    }
    //printf("OUTPUT: %s \n", s);
}

int main(int argc, char* argv[]) {
	FILE* in; /* file handle for input */
	FILE* out; /* file handle for output */
	char word[256]; /* char array to store words from input file */

	/* check command line for correct number of arguments */
	if (argc != 3) {
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	/* open input file for reading */
	in = fopen(argv[1], "r");
	if (in == NULL) {
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	/* open output file for writing */
	out = fopen(argv[2], "w");
	if (out == NULL) {
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	/* read words from input file, print on separate lines to output file*/
	while (fscanf(in, " %s", word) != EOF) {
		//printf("fuck");
		stringReverse(word);
		fprintf(out, "%s\n", word);
	}

	/* close input and output files */
	fclose(in);
	fclose(out);

	return (EXIT_SUCCESS);
}

