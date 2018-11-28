#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED

//THIS FILE DEFINES THE COMMANDS AVAILABLE IN THE QUEUE INTERFACE
//THEY ARE
//ENQUEUE: ADD A NUMBER TO THE QUEUE
//PRINT: PRINT THE CURRENT QUEUE
//DEQUEUE: DEQUEUES THE OLDEST INPUT AND REMOVES IT FROM THE LIST

#endif // QUEUE_H_INCLUDED

//this will contain each item in the list
typedef struct NodeItem {
    struct NodeItem *nextItem;
    int data;
} NodeItem;

//this struct will contain the entire linked list
typedef struct List
{
    struct nodeItem *head; //head of the list
} List;


//all these functions returns chars since we need to print stuff to an output file

char* enqueue(int x, List intList, char *output); //adds an int to the list

char* print(List intList, char *output); //prints out whatever is in the queue

char* dequeue(List intList, char *output); //dequeues the oldest value, returns "empty" if empty
