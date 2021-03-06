package ATM;

import java.util.Scanner;

public class Atm {

//method to print the options if pin is valid and return what they want to
    public static int options() {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do?");
//1: check balance
//2: deposit
//3: withdraw
        System.out.println("1:check balance \n 2:deposit \n 3:withdraw ");
        return input.nextInt();
    }

    public static boolean doSomethingElse() {
        Scanner inputContinue = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n)");
        String answer = inputContinue.next();
        if (answer.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean mainContinue = true;
        boolean accountPromptExit = false;
        boolean keepGoing = true;
        boolean correctPin = false;
        int choice;
        Customer c = new Customer(new Checking(1, 0), new Savings(1, 0), 1, 0);

        Database.addAccount(1234, 100, new Checking(1234, 101), new Savings(1234, 102));

//option enter account number or exit
        while (mainContinue) {
//ask the user the account number they are lookig for
            int accountNum = Customer.inputAccountNumber();
//check the account number to see if it is a real account
            if (Database.getAccount(accountNum).getAccountNumber() > 0) {
//ask them for the account pin
                System.out.println("Found a valid account");
//verify the pin the user entered
                correctPin = c.inputPin() == Database.getAccount(accountNum).getPin();
                if (correctPin) {
//make a loop to check if they want to keep doing stuff
                    while (keepGoing) {
//if the pin is correct let them decide what they want to do
//options for what to do if the pin is correct
                        choice = options();
                        switch (choice) {
                            case 1:
                                // FIX: need more options to let the user choose between account types
                                Database.getAccount(accountNum).getSavings().displayBalance();
                                break;
                            case 2:
                                Database.getAccount(accountNum).getSavings().deposit(c.inputAmount());
                                break;
                            case 3:
                                Database.getAccount(accountNum).getSavings().withdraw(c.inputAmount());
                                break;
                            default:
                                System.out.println("that's not a valid response");
                                break;
                        }
//ask them if they want to do anything else to the account
                        if (doSomethingElse()) {
                            mainContinue = true;
                        } else {
                            mainContinue = false;
                            keepGoing = false;
                        }
                    }
                } else {
//else the pin is not correct and they should be alerted
                    System.out.println("Wrong pin number");
//check if they want to try again
                    if (doSomethingElse()) {
                        mainContinue = true;
//correctPin = c.inputPin() == Database.getAccount(accountNum).getPin();
                    } else {
                        mainContinue = false;
                    }
                }
            } else {
                System.out.println("Invalid account");
            }
        }
    }
}
