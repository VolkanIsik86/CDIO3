package domain;

//Formålet med account-klassen er at holde styr på spillernes point

class Account {
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
    
    //Subtracts no more than the legal amount
    public void withdraw(int amount){
        if (amount > balance){
            balance = 0;
        } else {
            balance = balance - amount;
        }
    }
    
    public void deposit(int addition){
        balance = balance + addition;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
