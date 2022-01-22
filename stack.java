import java.util.Scanner;

public class stack {
    int top;
    int stack[];
    int size;
    stack(int size,int top){
        this.size=size;
        this.top=top;
        this.stack=new int[size];
    }

    public void push(int ele){
        if (top==size-1)
        {
            System.out.println("stqack overflow");
        }
        else {
            stack[++top]=ele;
        }
    }

    public int pop(){
        if (top==-1){
            return -1;
        }
        else {
            return stack[top--];
        }
    }

    public void display(){
        if(top==-1)
            System.out.println("the stack is empty");

    else{
        for(int i=top;i>=0;i--) {
            System.out.print(stack[i] + " ");
        }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the sizeof the stack");
        int size=sc.nextInt();

        stack s1=new stack(size,-1);
        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.dis[;ay");
        System.out.println("4.exit");

        while (true){
            System.out.println("enter choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter elemnts to push");
                    int ele1=sc.nextInt();
                    s1.push(ele1);
                    break;
                case 2:
                    int ele2= s1.pop();
                    if (ele2==-1){
                    System.out.println("stack underflow");}

                    break;
                    case 3:
                        s1.display();
                        break;
                case 4:
                    System.exit(0);
                    break;
                default:System.out.println("invalid choice");

            }
        }
    }
}
