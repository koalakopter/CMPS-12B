//QUEUE.C
//LAB 5: QUEUING A LIST OF INTS
//JULIAN TO: JCTO
//CMPS 12B

#include "queue.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//HELPER FUNCTIONS
//creates a new list to be used
List *newList()
{
    List *new = malloc(sizeof(List));
    new->head = NULL;
    return new;
}

NodeItem *newNode(int *data)
{
    NodeItem *newItem = malloc(sizeof (NodeItem));
    //check if malloc fails
    if(newItem != NULL)
    {
        newItem->nextItem = NULL;
        newItem->prevItem = NULL;
        newItem->data = data;
        return newItem;
    }
}

//FIRST FUNCTION: ENQUEUE
char* enqueue(int x, List *line, char* output)
{
    struct NodeItem *item;
    item = line->head;
    //if this is the first item in the list, make a new list
    if(item == NULL)
    {
        NodeItem *newData = newNode(x);
        newData->data = x;
        newData->nextItem = NULL;
        newData->prevItem = NULL;
        line->head = newData;
        sprintf(output, "enqueued %d\n", x);
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
    NodeItem *newData = newNode(x);
    newData->data = x;
    newData->nextItem = NULL;
    newData->prevItem = item;
    item->nextItem = newData;

    //encodes the output
    //char output[69];
    sprintf(output, "enqueued %d\n", x);
    return output;
}

//SECOND FUNCTION: PRINT THE LIST
char* print(List *line, char* output)
{
    NodeItem *item = line->head;
    //char output[900]; //I hope the list never gets this long lmao
    //if the list is empty, print nothing
    if (item == NULL)
    {
        sprintf(output, "\n");
        return output;
    }
    //printf("here?\n");
    //else go to the front of the list
    /*
    while((item->prevItem) != NULL)
    {
        item = item->prevItem;
    }
    */
    char temp[20]; //hopefully no numbers with more than 20 digits

    //clear output string?
    sprintf(output, "");
    //once at the front, just print out the elements
    while((item->nextItem) != NULL)
    {
        //printf("%d ", item->data);
        sprintf(temp, "%d ", item->data);
        //printf("%s\n", temp);
        strcat(output, temp);
        //printf("%s\n", output);
        item = item->nextItem;
    }
    //print the last item in the list
    //printf("%d ", item->data);
    sprintf(temp, "%d\n", item->data);
    strcat(output, temp);

    //printf("output of print: %s", output);
    //sprintf(output, "why %s", output);
    return output;
}

//LAST FUNCTION: DEQUEUE AN INT
//(the oldest one put in)
char* dequeue(List *line, char* output) //dequeues the oldest value, returns "empty" if empty
{
    //printf("fuggggg\n");

    NodeItem *item = line->head;
    //check for empty list first
    if(item == NULL)
    {
        sprintf(output, "empty");
        return output;
    }
    int value = item->data;

    //if only one item in the list
    if(item->nextItem == NULL && item->prevItem == NULL)
    {
        line->head = NULL;
        sprintf(output, "%d\n", value);
        return output;
    }
    //next, dequeue the oldest int (the head)
    line->head = item->nextItem; //set the head to the next Item on the List
    item = item->nextItem->prevItem = NULL; //delete the next Item's way back to the deleted item

    //return the data value
    sprintf(output, "%d\n", value);
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
    //TESTING WOOHOO
    int x = 50;
    int y = 40;
    int z = 30;
    char output[69];
    printf("STARTING TESTS!!!\n");
    //char output2[69];
    List *myList = newList();

    //test enqueue and dequeue
    sprintf(output, enqueue(x, myList, output));
    printf("%s", output);
    sprintf(output, dequeue(myList, output));
    printf("%s", output);

    //print from empty list
    sprintf(output, dequeue(myList, output));
    printf("%s\n", output);

    //dequeue from empty list
    sprintf(output, dequeue(myList, output));
    printf("%s\n", output);

    sprintf(output, enqueue(x, myList, output));
    printf("%s", output);
    sprintf(output, enqueue(y, myList, output));
    printf("%s", output);
    sprintf(output, enqueue(z, myList, output));
    printf("%s", output);
    //testing print
    sprintf(output, print(myList, output));
    printf("%s", output);
    sprintf(output, dequeue(myList, output));
    printf("%s", output);
    sprintf(output, print(myList, output));
    printf("%s", output);

}

