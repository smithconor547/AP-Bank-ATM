package ATM;

public class Checking extends Account {

    public Checking(int pin, int accountNumber) {
        super(pin, accountNumber);
    }

    public String getType() {
        return "checking";
    }
}
