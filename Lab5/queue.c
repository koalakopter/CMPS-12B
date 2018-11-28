//QUEUE.C
//LAB 5: QUEUING A LIST OF INTS
//JULIAN TO: JCTO
//CMPS 12B

#include "queue.h"

#include <stdio.h>

//FIRST FUNCTION: ENQUEUE
char* enqueue(int x, List intList, char *output)
{
    //makes a new NodeItem item
    //next item is null since its placed at the head
    //second thing is just the int
    struct NodeItem newData = {NULL, x};

    //encodes the output
    sprintf(output, "enqueued %d", x);
    return output;
}


int main()
{
    int x = 5;
    char output[50];
    sprintf(output, "enqueued %d", x);
    printf("%s",output);
}

