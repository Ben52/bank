
package bank;

import java.util.ArrayList;


public abstract class Account {
    public String username;
    public String type;
    public int accountNumber;
    public Double balance = 0.0;
    public ArrayList<String> transactions = new ArrayList<String>();
    
    public Account (String username, String type){
        this.username = username;
        this.type = type;
    }
    
    
    public String getUsername(){
        return username;
    }
    
    public String getType(){
        return type;
    }
    
    
    public abstract void endOfMonth();
    
    public Double getBalance(){
        return balance;
    } 
    
    public void transaction(Double amount, boolean debit){
        if(debit){
            this.balance = this.balance - amount;
            transactions.add("Debit of $" + amount);
        }else{
            this.balance = this.balance + amount;
            transactions.add("Credit of $" + amount);   
        }
          
    }
    
 
    

    
    
    public void viewTransactions(){
        for(String transaction : transactions){
            System.out.println(transaction);
        }
    }
    
    
}
