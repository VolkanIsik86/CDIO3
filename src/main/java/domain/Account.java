package domain;

//Formålet med account-klassen er at holde styr på spillernes point

public class Account {
    private int balance;
    
    public Account(int balance){
        this.balance = balance;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void setBalance(int balance){
        this.balance = balance;
    }
    
    //Subtracts the legal amount.
    //Returns false if withdrawal > balance, otherwise true.
    public boolean withdraw(int withdrawal){
        if (withdrawal > balance){
            balance = 0;
            return false;
        } else {
            balance = balance - withdrawal;
            return true;
        }
    }
    
    public void deposit(int addition){
        balance = balance + addition;
    }
    
    
    public String toString(){
        return "Balance: " + balance;
    }
    
}
