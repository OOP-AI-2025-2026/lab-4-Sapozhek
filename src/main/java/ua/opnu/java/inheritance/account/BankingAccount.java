package ua.opnu.java.inheritance.account;

/**
 * Клас, який моделює банківський рахунок клієнта.
 */
public class BankingAccount {

    private int balance; // у копійках

    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }

    /** Поповнення рахунку. */
    public void debit(Debit d) {
        if (d == null) return;
        balance += d.getAmount();
    }

    /** Зняття коштів з рахунку. */
    public void credit(Credit c) {
        if (c == null) return;
        balance -= c.getAmount();
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingAccount)) return false;
        BankingAccount that = (BankingAccount) o;
        return balance == that.balance;
    }

    @Override
    public String toString() {
        return "BankingAccount{balance=" + balance + "}";
    }
}
