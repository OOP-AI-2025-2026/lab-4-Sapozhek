package ua.opnu.java.inheritance.account;

/**
 * Описує операцію поповнення рахунку.
 */
public class Debit {

    private final int amount; // у копійках

    public Debit(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
