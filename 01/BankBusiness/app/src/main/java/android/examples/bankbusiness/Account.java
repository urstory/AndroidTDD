package android.examples.bankbusiness;

/**
 * Created by kicks_000 on 2015-05-03.
 */
public class Account {

    private int balance;

    public Account(int money ) {
        this.balance = money;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int i) {
        balance -= i;
    }
}
