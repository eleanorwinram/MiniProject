
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.*;
import java.util.Random;

public class Main
{

    private static ArrayList<String> ownedshares;
    public static void Main (String [] args)
    {
        Stock fash1 = new Fashion("PLT", 245.00, 0.56, "High Street Fashion");
        Stock t1 = new Tech("HP", 345.00, 0.23, true);
        Stock f3 = new Food("cadbury", 256, 0.45, true);
        Account acc1 = new Account(12345, 210000000.98);
        ownedshares = new ArrayList<String>();
        
       
        System.out.println("Welcome to the Stock market simulator!");
        System.out.println("Press 1 to get info and characteristics on all stocks");
        print("press 2 to buy shares");
        print("press 3 to sell shares");
        System.out.println("press 4 to exit");
        String v = input("Choose one option");
        while(!(v== "4")){
            if(v.equals("1"))
            {
                showinfo(fash1, t1, f3);
            }
            else if(v.equals("4"))
            {break;}
            else if(v.equals("2"))
            {
                buy(fash1, t1, f3, acc1);
            }
            else if(v.equals("3"))
            {
                sell(fash1, t1, f3, acc1);
            }
            System.out.println("Next task");
            System.out.println("Press 1 to get info and characteristics on all stocks");
            print("press 2 to buy shares");
            print("press 3 to sell shares");
            System.out.println("press 4 to exit");
            v = input("Choose one option");
        }
        System.exit(0);
    }

    public static void showinfo(Stock fash1, Stock t1, Stock f3)
    {      
        print(fash1.printinfo());
        print(t1.printinfo());
        print(f3.printinfo());
        
    }

    public static void buy(Stock fash1, Stock t1, Stock f3, Account acc1)
    {
        String m = input("Which stock would you like to buy \n1)PLT \n2)HP \n3)Cadbury");
        if(m.equals("1"))
        {
            double c = fash1.getcost();
            int number = inputint("how many stocks in PLT would you like to buy");
            c = c*number;
            acc1.boughtshares(c);
            print("your new balance is " + acc1.getbalance());
            ownedshares.add("You bought " + number + "in PLT");
        }
        else if(m.equals("2"))
        {
            double c = t1.getcost();
            int number = inputint("how many stocks in HP would you like to buy");
            c = c*number;
            acc1.boughtshares(c);
            print("your new balance is " + acc1.getbalance());
            ownedshares.add("You bought " + number + "in PLT");
        }
        else if(m.equals("3"))
        {
            double c = f3.getcost();
            int number = inputint("how many stocks in Cadbury would you like to buy");
            c = c*number;
            acc1.boughtshares(c);
            print("your new balance is " + acc1.getbalance());
            ownedshares.add("You bought " + number + "in PLT");
        }
        randomnews();
    }

    public static void sell(Stock fash1, Stock t1, Stock f3, Account acc1)
    {
        String m = input("Which stock would you like to sell \n1)PLT \n2)HP \n3)Cadbury");
        if(m.equals("1"))
        {
            double c = fash1.getcost();
            int number = inputint("how many stocks in PLT would you like to sell");
            c = c*number;
            acc1.soldshares(c);
            print("your new balance is " + acc1.getbalance());
        }
        else if(m.equals("2"))
        {
            double c = t1.getcost();
            int number = inputint("how many stocks in HP would you like to sell");
            c = c*number;
            acc1.soldshares(c);
            print("your new balance is " + acc1.getbalance());

        }
        else if(m.equals("3"))
        {
            double c = f3.getcost();
            int number = inputint("how many stocks in Cadbury would you like to sell");
            c = c*number;
            acc1.soldshares(c);
            print("your new balance is " + acc1.getbalance());

        }
        randomnews();
    }

    public static String input(String m)
    {
        String ans;
        Scanner scanner = new Scanner(System.in);
        print(m);
        ans = scanner.nextLine();
        return ans;
    }

    public static int inputint(String m)
    {return Integer.parseInt(input(m));}

    public static void print(String m)
    {
        System.out.println(m);
        return;
    }

    public static void randomnews()
    {
        Random r = new Random();
        int n = r.nextInt(3);

        String [] news = new String [3];
        news[0] = "BREAKING NEWS \n *** The stock for company PLT has just fallen by 4% we would reccomend that you buy ***";
        news[1] ="BREAKING NEWS \n*** Hewlett Packard have released new products and the value of shares has gone up! ***";
        news[2] = "BREAKING NEWS \n*** Cadbury has been taken over by the company Kraft foods. Share values have increased by 2%";

        String var1 = news[n];
        print(var1);
    }
}
