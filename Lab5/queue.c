//QUEUE.C
//LAB 5: QUEUING A LIST OF INTS
//JULIAN TO: JCTO
//CMPS 12B

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "queue.h"

//structs
//this will contain each item in the list

typedef struct NodeItem {
    struct NodeItem *nextItem;
    struct NodeItem *prevItem;
    int data;
} NodeItem;

struct queue {
    NodeItem *head;
};

//HELPER FUNCTIONS
//creates a new list to be used
queue *newList(void)
{
    queue *newQueue = malloc(sizeof(queue));
    newQueue->head = NULL;
    return newQueue;
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
char* enqueue(int x, queue *line, char* output)
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
char* print(queue *line, char* output)
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
char* dequeue(queue *line, char* output) //dequeues the oldest value, returns "empty" if empty
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

//process each individual line
//handles 3 commands: enqueue, print, and dequeue
//returns a formatted string
//pass in the linkedList thing too
char* process(char* input, queue *line)
{
    char* split; //for splits
    char* output[99]; //output string
    //split = strtok(input, " "); //split around the space

    //printf("here?\n");
    //read in the command
    char command = input[0];
    //printf("input: %c\n", command);
    //enqueue
    if(command == 'e')
    {
        char numInput[200]; //hope there are no 200 digit numbers lol
        int x = 1; //incrementer
        while(input[x+1] != NULL)
        {
            //printf("reading: %c\n", input[x+1]);
            numInput[x-1] = input[x+1]; //plus one b/c there is a space
            x++;
        }

        int number = atoi(numInput);
        //printf("number! %d\n", number);
        //return the output string
        sprintf(input, enqueue(number, line, output));
        return input;
    }
    //print routine
    else if(command == 'p')
    {
        sprintf(input, print(line, output));
        return input;
    }
    //dequeue routine
    else if(command == 'd')
    {
        sprintf(input, dequeue(line, output));
        return input;
    }
    //this ought not to happen
    printf("\nBAD INPUT\n");
    sprintf(output, "BAD INPUT");
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
    queue *myList = newList();

    /*
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
    */

    //testing with actual inputs now
    char test[20] = "e 50";
    char test2[20] = "e 42";
    char test3[3] = "p";

    sprintf(output, process(test, myList));
    printf("%s", output);
    sprintf(output, process(test2, myList));
    printf("%s", output);
    sprintf(output, process(test3, myList));
    printf("%s", output);


}

