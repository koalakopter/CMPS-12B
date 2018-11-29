//LAB 5: ENQUEUE SOME INTS
//JULIAN TO
//JCTO
//CMPS 12B
//MAIN FILE

//header file with all the things
#include "queue.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define ARBITRARY_LENGTH 50

//main file woohoo
int main(int argc, char* argv[]) {
    FILE* in; /* file handle for input */
	FILE* out; /* file handle for output */

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

	char* line; /* char array to read the input line from the file */
	char* output; //output string

	//make the LinkedList
	queue *myList = newList();
    //stolen from Lab4
    line = calloc(ARBITRARY_LENGTH, sizeof(char));
    output = calloc(1000, sizeof(char));
	//reads lines in while they still exist
	while (fgets(line, ARBITRARY_LENGTH, in) != NULL) {
        sprintf(output, process(line, output));
        fprintf(out, "%s/n", output);
	}

	/* close input and output files */
	fclose(in);
	fclose(out);


}
