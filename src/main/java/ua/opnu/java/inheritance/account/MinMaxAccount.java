package ua.opnu.java.inheritance.account;

/**
 * Рахунок, який пам'ятає мінімальний та максимальний баланс.
 * Баланс змінюється тільки в debit() та credit().
 */
public class MinMaxAccount extends BankingAccount {

    // мінімальний та максимальний баланс у копійках
    private int min;
    private int max;

    /**
     * Створює рахунок на основі стартових даних
     * і ініціалізує min/max поточним балансом.
     */
    public MinMaxAccount(Startup s) {
        super(s);                   // створюємо "звичайний" BankingAccount
        int startBalance = getBalance();
        this.min = startBalance;
        this.max = startBalance;
    }

    /** Повертає мінімальний зафіксований баланс (у копійках). */
    public int getMin() {
        return min;
    }

    /** Повертає максимальний зафіксований баланс (у копійках). */
    public int getMax() {
        return max;
    }

    /**
     * Поповнення рахунку.
     * Після операції оновлюємо min/max.
     */
    @Override
    public void debit(Debit d) {
        super.debit(d);     // BankingAccount сам змінює баланс
        updateMinMax();
    }

    /**
     * Зняття коштів.
     * Після операції оновлюємо min/max.
     */
    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    /** Оновлює мінімальне та максимальне значення балансу. */
    private void updateMinMax() {
        int current = getBalance();
        if (current < min) {
            min = current;
        }
        if (current > max) {
            max = current;
        }
    }
}
