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
        sprintf(output, "enqueued first %d", x);
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
    sprintf(output, "enqueued %d", x);
    return output;
}

char* print(List *line, char* output)
{
    NodeItem *item = line->head;
    //char output[900]; //I hope the list never gets this long lmao
    //if the list is empty, print nothing
    if (item == NULL)
    {
        sprintf(output, "");
    }
    printf("here?\n");
    //else go to the front of the list
    /*
    while((item->prevItem) != NULL)
    {
        item = item->prevItem;
    }
    */
    char temp[20]; //hopefully no numbers with more than 20 digits

    //once at the front, just print out the elements
    while((item->nextItem) != NULL)
    {
        printf("%d ", item->data);
        sprintf(temp, "%d ", item->data);
        strcat(output, temp);
        item = item->nextItem;
    }
    //print the last item in the list
    printf("%d ", item->data);
    sprintf(temp, "%d ", item->data);
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
    List *myList = newList();
    sprintf(output, enqueue(x, myList, output));
    printf("%s\n", output);
    sprintf(output, enqueue(y, myList, output));
    printf("%s\n", output);
    sprintf(output, enqueue(z, myList, output));
    printf("%s\n", output);
    printf("%d wheee\n", myList->head);
    sprintf(output, print(myList, output));

}

