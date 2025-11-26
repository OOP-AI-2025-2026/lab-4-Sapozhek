package ua.opnu.java.inheritance.account;

/**
 * Описує операцію зняття коштів з рахунку.
 */
public class Credit {

    private final int amount; // у копійках

    public Credit(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
