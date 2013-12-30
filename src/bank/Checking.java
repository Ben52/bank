
package bank;


public class Checking extends Account {
    

    public Checking(String username, String type) {
        super(username, type);
    }
    
    @Override
    public void endOfMonth(){
        if(this.balance < 1000.0){
            this.balance -= 10.0;
            transactions.add("Charge of $10 for having a balance of under $1,000");
        }
    }
}
