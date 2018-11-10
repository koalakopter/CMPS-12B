//Julian To
//Jcto
//Lab3: charType.c
//Goal: Sort characters from a file based on type

#include <stdio.h>
#include <ctype.h>

#define MAX_LINE_LENGTH 256

//function prototypes
int checkChar(char input);
void placeChars(char* in, char* out_a, char* out_n, char* out_p, char* out_w);

int main(void)
{
    //printf("yelloworld");
    char test = ']';
    //int koala = isalnum(test);
    //printf("What is the character: %d" ,koala);
    int koala = checkChar(test);
    printf("Testing! %d", koala);
    int* meme;

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