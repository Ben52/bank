package bank;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Bank {

    public static ArrayList<Account> accounts = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Bank().run();


        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        // ArrayList<Account> accounts = new ArrayList<Account>();
       /* 
         Savings s = new Savings("Binny");
         Checking c = new Checking("Obama");
        
        
         accounts.add(c);
         accounts.add(s);
         */

        for (Account account : accounts) {

            System.out.println(account.getUsername());
        }


    }

    public void run() {
        while (true) {
            System.out.println("Enter A to add a user, L to view a list of accounts, Login to login, Q to quit");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Q")) {
                System.exit(0);
            } else if (choice.equals("A")) {
                addAccount();
            } else if (choice.equals("L")) {
                viewAccounts();
            } else if (choice.equals("LOGIN")) {
                login();
            }
        }
    }

    public void addAccount() {
        System.out.println("Would you like to open a Checking or Savings account? Enter C/S");
        String choice = scanner.nextLine().toUpperCase();
        if (choice.equals("C")) {
            System.out.println("Enter a username");
            String username = scanner.nextLine();
            Checking checking = new Checking(username, "Checking");
            accounts.add(checking);
        } else if (choice.equals("S")) {
            System.out.println("Enter a username");
            String username = scanner.nextLine();
            Savings savings = new Savings(username, "Savings");
            accounts.add(savings);
        }
    }
    
    public void login(){
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        for(Account account : accounts){
            if(username.equals(account.getUsername())){
                loggedIn(account);
                break;
            }
        }
    }
    
    public void loggedIn(Account account){
        boolean loggedIn = true;
        while(loggedIn){
            System.out.println("Enter T to add a transaction, V to view your transactions and M to go back to the main menu");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("T")){
                System.out.println("Would you like to enter a withdrawel or a deposit? Enter W/D");
                choice = scanner.nextLine().toUpperCase();
                if(choice.equals("W")){
                    System.out.println("Enter the amount of your withdrawel");
                    Double amount = scanner.nextDouble(); scanner.nextLine();
                    account.transaction(amount, true);
                    System.out.println("Thank you. Your balance is now " + account.getBalance());
                }else if(choice.equals("D")){
                    System.out.println("Enter the amount of your deposit");
                    Double amount = scanner.nextDouble(); scanner.nextLine();
                    account.transaction(amount, false);
                    System.out.println("Thank you for your deposit, your balance is now " + account.getBalance());
                }
            }else if(choice.equals("V")){
                account.viewTransactions();
            }else if(choice.equals("M")){
                break;
            }
        }
    }
    

    public void viewAccounts() {
        for (Account account : accounts) {
            System.out.println(account.getType() + "    " + account.getUsername());
        }
    }
}
