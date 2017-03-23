package ATM;

public class Account {
//insance variables
//private String type;

    private double balance;
    private int pin;
    private int accountNumber;
//constructors

    public Account(/*String type, */int pin, int accountNumber) {
//this.type = type;
        this.pin = pin;
        this.accountNumber = accountNumber;
        balance = 0.0;
    }
//methods
//print the balance

    public void displayBalance() {
        System.out.println(balance);
    }
//deposit money

    public void deposit(double amount) {
        balance += amount;
    }
//withdraw money

    public void withdraw(double amount) {
        balance -= amount;
    }
//get the account number

    public int getAccountNumber() {
        return accountNumber;
    }
    /*
public String getType() {
return type;
}
     */
}
