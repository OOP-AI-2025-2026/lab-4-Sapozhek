package ua.opnu.java.inheritance.account;

/**
 * Клас зберігає стартову інформацію рахунку клієнта.
 * Баланс задається у копійках.
 */
public class Startup {

    private final int balance;

    public Startup(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}
