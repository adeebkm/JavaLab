

import java.util.Scanner;

public class prime {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number to check");
        int n = sc.nextInt();
        int flag = 0;
        for (int i = 2;
             i <= n / 2;
             i++) {
            if (n % i == 0) {
                flag = 1;
                break;

            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            System.out.println("the number is not prime number");
        } else if (n != 1 && n != 0) {
            System.out.println("entered number is a prime number");
        } else {
            System.out.println("entered number is neither prime nor composite");
        }

    }
}


