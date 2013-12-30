
package bank;

public class Savings extends Account {
    
   

    public Savings(String username, String type) {
        super(username, type);
    }
    
    @Override
    public void endOfMonth(){
        if(this.balance > 0.0){
           Double interest = this.balance * .05;
           this.balance = this.balance + interest;
           transactions.add("Interest payment of $" + interest + " was credited to your account");
        
        }
    }
}
