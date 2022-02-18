import java.util.Scanner;
public class prime {
    public static int i=2;
    public static boolean isPrime(int n){
        if (n==0||n==1)
            return false;
        if (n==i)
            return true;
        if(n%i==0)
            return false;
        i++;
        return isPrime(n);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(isPrime(n))
            System.out.println("prime");
        else
            System.out.println("not prime");
    }
}
