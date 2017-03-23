package ATM;

import java.util.ArrayList;

public class Database {

    static ArrayList<Customer> accounts = new ArrayList<>();

    public static void addAccount(int pin, int accountNumber, Checking check, Savings save) {
        accounts.add(new Customer(check, save, accountNumber, pin));
    }

    public static void addAccount(Customer c) {
        accounts.add(c);
    }

    /*
public static Account getAccount(int i) {
return accounts.get(i);
}
     */
    public static Customer getAccount(int accountNumberInput) {
        for (Customer c : accounts) {
            if (accountNumberInput == c.getAccountNumber()) {
                return c;
            }
        }
        System.out.println("not a valid accountNumber");
        return new Customer(new Checking(-1, -1), new Savings(-1, -1), -1, -1);
    }
}
