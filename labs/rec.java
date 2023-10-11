// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

public class Recu{
    int n;
    int f;
    public Recu()
    {
        System.out.println("This is a constructor");
        n = 6;
        f = 1;
    }

    int factorial(int x)
    {
        if(x==0)
        {
            return 1;
        }
        
        if(x==1)
        {
            return 1;
        }
        
        else
        {
            return x*factorial(x-1);
        }
        
//        System.out.println("The new value of c is" + c);
    }

    public static void main(String[] args)
    {
        System.out.println("This is the main function");
        Recu obj = new Recu();
        Scanner inpu = new Scanner(System.in);
        System.out.println("\nEnter a number:");
        int num = inpu.nextInt();

        obj.f = obj.factorial(num);
        System.out.println("Value of factorial = " + obj.f);    }
}
