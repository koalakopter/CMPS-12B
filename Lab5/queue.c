//QUEUE.C
//LAB 5: QUEUING A LIST OF INTS
//JULIAN TO: JCTO
//CMPS 12B

#include "queue.h"

#include <stdio.h>
#include <string.h>

//FIRST FUNCTION: ENQUEUE
char* enqueue(int x, NodeItem *item, char* output)
{
    //if this is the first item in the list, make a new list
    if(item == NULL)
    {
        struct NodeItem *newData;
        newData->data = x;
        newData->nextItem = NULL;
        newData->prevItem = NULL;
        sprintf(output, "enqueued %d", x);
        return output;
    }
    //first, go to the end of the list
    while(item->nextItem != NULL)
    {
        item = item->nextItem;
    }

    //makes a new NodeItem item
    //next item is null since its placed at the head
    //prev item is the end of the list
    //data is just the int you want to enqueue
    struct NodeItem *newData;
    newData->data = x;
    newData->nextItem = NULL;
    newData->prevItem = item;

    item->prevItem = newData;

    //encodes the output
    //char output[69];
    sprintf(output, "enqueued %d", x);
    return output;
}

char* print(NodeItem *item, char* output)
{
    //char output[900]; //I hope the list never gets this long lmao
    //if the list is empty, print nothing
    if (item == NULL)
    {
        sprintf(output, "");
    }
    //else go to the front of the list
    while((item->prevItem) != NULL)
    {
        item = item->prevItem;
    }
    char temp[20]; //hopefully no numbers with more than 20 digits

    //once at the front, just print out the elements
    while((item->nextItem) != NULL)
    {
        sprintf(temp, "%d ", item->data);
        strcat(output, temp);
        item->nextItem;
    }
    return output;
}

//testing shtuff
int main()
{
    /*
    int x = 5;
    char output[50];
    sprintf(output, "enqueued %d ", x);
    strcat(output, "I am YeTI");
    printf("%s",output);
    */
    int x = 50;
    int y = 40;
    char output[69];
    sprintf(output, enqueue(x, NULL, output));
    sprintf(output, enqueue(x, NULL, output));
    printf("%s", output);
}

