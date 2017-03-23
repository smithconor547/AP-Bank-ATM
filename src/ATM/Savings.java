package ATM;

public class Savings extends Account {

    public Savings(int pin, int accountNumber) {
        super(pin, accountNumber);
    }

    public String getType() {
        return "savings";
    }
}
