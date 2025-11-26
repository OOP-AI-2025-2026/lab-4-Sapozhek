import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Startup;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Credit;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int start = getBalance();
        this.minBalance = start;
        this.maxBalance = start;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        int current = getBalance();
        if (current < minBalance) {
            minBalance = current;
        }
        if (current > maxBalance) {
            maxBalance = current;
        }
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
