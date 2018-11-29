#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED

//THIS FILE DEFINES THE COMMANDS AVAILABLE IN THE QUEUE INTERFACE
//THEY ARE
//ENQUEUE: ADD A NUMBER TO THE QUEUE
//PRINT: PRINT THE CURRENT QUEUE
//DEQUEUE: DEQUEUES THE OLDEST INPUT AND REMOVES IT FROM THE LIST

//this struct will contain the entire linked list (maybe)
typedef struct queue queue;

queue *newList(void);

//all these functions returns chars since we need to print stuff to an output file

char* enqueue(int x, queue *line, char* output); //adds an int to the list

char* print(queue *line, char* output); //prints out whatever is in the queue

char* dequeue(queue *line, char* output); //dequeues the oldest value, returns "empty" if empty

#endif // QUEUE_H_INCLUDED
