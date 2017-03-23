package ATM;

import java.util.Scanner;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer {
//instance variables

    int pinGuess;
    Checking checking;
    Savings savings;
    int customerNumber;
    int pin;
//int pin;
//constructor
/*public Customer(int pin){
this.pin = pin;
System.out.println(pin);
}*/
    public Customer(Checking checking, Savings savings, int customerNumber, int pin) {
        this.checking = checking;
        this.savings = savings;
        this.customerNumber = customerNumber;
        this.pin = pin;
    }
//methods
//gets the users pin guess and and returns it

    public int inputPin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a pin number");
        pinGuess = input.nextInt();
        System.out.println("Pin guess is " + pinGuess);
        return pinGuess;
    }

    public double inputAmount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount ");
        return (input.nextDouble());
    }

    public static int inputAccountNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the account number ");
        return (input.nextInt());
    }

    public int getPin() {
        return pin;
    }

    public int getAccountNumber() {
        return customerNumber;
    }
}
