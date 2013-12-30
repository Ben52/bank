
package bank;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


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
    
    public String getBalance(){
        return Bank.currency.format(balance).replace('¤', '$');
    } 
    
    public void transaction(Double amount, boolean debit){
        if(debit){
            this.balance = this.balance - amount;
            transactions.add("Debit of " + NumberFormat.getCurrencyInstance().format(amount));
        }else{
            this.balance = this.balance + amount;
            transactions.add("Credit of " + NumberFormat.getCurrencyInstance().format(amount));   
        }
          
    }
    
 
    

    
    
    public void viewTransactions(){
        for(String transaction : transactions){
            System.out.println(transaction);
        }
        System.out.println("Current balance:    " + this.getBalance());
    }
    
    
}
