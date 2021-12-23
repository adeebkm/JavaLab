//circular linked list iwth recursive functions wherever necessary
//first we do doubly linked list implementation since its easier to do so
//creation and search can be via recursion while deletion and insertion can be normal functions which use search function to manipulate the circular linked list
#include <stdio.h>

typedef struct doubly{
    int data;
    struct doubly* prev;
    struct doubly* next;
}dll;

dll* head = NULL;
//dll* ptr;
dll* displayPtr;
dll* temp = NULL;
int n;
//lets do create function first?
//we take data within the function
//returns a pointer to the head of the circular linked list

dll* createNode(){
    dll* ptr;
    if(head == NULL){
        printf("Enterting first node in circular linked list\n");
        head = (dll*) malloc(sizeof(dll));
        printf("please enter the data to be put into the new node\n");
        scanf("%d",&n);
        head -> data =n;
        ptr = head;
    }
    else{
    printf("please enter the data to be put into the new node\n");
    scanf("%d",&n);
    ptr = (dll*) malloc(sizeof(dll));
    ptr ->data = n;
    }
    printf("do you want to enter more nodes into this circular linked list?\n1.Yes\n2.No\n");
    int choice;
    scanf("%d",&choice);
    switch (choice)
    {
    case 1:

        ptr -> next = createNode();
        //temp = ptr -
        ptr ->next ->prev = ptr;
        break;

    case 2:
        ptr ->next = head;
        head -> prev = ptr;
        break;

    default:
        printf("please enter a valid option\n");
        break;
    }
    return ptr;
}
void display(){
    if(head == NULL){
        printf("list is empty\n");
        return;
    }
    displayPtr = head;
    do{
        printf("the data in node is %d \n",displayPtr->data);
        displayPtr = displayPtr ->next;
    }while(displayPtr != head);
} 

//saerch function using recursion

dll* search(dll* ptr,int n){
    if(ptr ->data == n){
        return ptr;
    }
    if(ptr->next == head){
        return NULL;
    }
    return search(ptr->next,n);
}

//insert function using search function which is recursive

void insert(){
    dll* searchPtr;
    printf("enter the node you want to insert around\n");
    int n;
    scanf("%d",&n);
    searchPtr = search(head,n);
    if (searchPtr == NULL){
        printf("the node you specified isnt found,please try again\n");
        return;
    }
    dll* before;
    dll* after;
    int data;
    printf("enter the data you want to insert\n");
    scanf("%d",&data);
    dll* insertN = (dll*) malloc(sizeof(dll));
    insertN -> data = data;
    printf("do you want to insert the node before or after your selected node?\n1.before\n2.after\n");
    int check;
    scanf("%d",&check);
    switch (check)
    {
    case 1:
        //dll* insertN = createNode();
        before = searchPtr ->prev;
        before ->next = insertN;
        searchPtr->prev = insertN;
        insertN -> next = searchPtr;
        insertN -> prev = before;
        break;

    case 2:
        after = searchPtr->next;
        searchPtr ->next = insertN;
        insertN ->next = after;
        after->prev = insertN;
        insertN ->prev = searchPtr;
        break;

    default:
        printf("please enter a valid option\n");
        break;
    }
}

//delete funciton which uses the recursive search function

void delete(int n){
    dll* deletePtr;
    deletePtr = search(head,n);
    if(deletePtr == NULL){
        printf("the node wasnt found in the list please try again\n");
        return;
    }
    dll* before;
    dll* after;
    before = deletePtr -> prev;
    after = deletePtr ->next;
    before->next = after;
    after->prev = before;
    if(deletePtr == head){
        head = head -> next;
    }
    free(deletePtr);
}

int main(){
    head = createNode();
    display();
    insert();
    display();
    printf("enter what you want to delete\n");
    int temp3;
    scanf("%d",&temp3);
    delete(temp3);
    display();
}
//create,search,display,main,insert,delete
