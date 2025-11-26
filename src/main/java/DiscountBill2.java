import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DiscountBill2 – реалізація завдання 1 через композицію.
 * Всередині тримає GroceryBill, а знижки рахує самостійно.
 */
public class DiscountBill2 {

    private final GroceryBill bill;
    private final boolean regularCustomer;

    // сума всіх товарів без урахування знижок
    private BigDecimal totalBeforeDiscount = BigDecimal.ZERO;
    // загальна сума знижки
    private BigDecimal totalDiscount = BigDecimal.ZERO;
    // кількість товарів зі знижкою (> 0)
    private int discountCount = 0;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public void add(Item item) {
        // додаємо товар у «звичайний» чек
        bill.add(item);

        BigDecimal price = BigDecimal.valueOf(item.getPrice());
        BigDecimal discount = BigDecimal.valueOf(item.getDiscount());

        // завжди додаємо повну ціну до загальної суми
        totalBeforeDiscount = totalBeforeDiscount.add(price);

        // якщо клієнт постійний і на товар є знижка
        if (regularCustomer && discount.compareTo(BigDecimal.ZERO) > 0) {
            discountCount++;
            totalDiscount = totalDiscount.add(discount);
        }
    }

    public double getTotal() {
        BigDecimal totalToPay;
        if (regularCustomer) {
            totalToPay = totalBeforeDiscount.subtract(totalDiscount);
        } else {
            totalToPay = totalBeforeDiscount;
        }
        return totalToPay.doubleValue();
    }

    public int getDiscountCount() {
        // для непостійного клієнта знижки якби «нема»
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) {
            return 0.0;
        }
        return totalDiscount.doubleValue();
    }

    public double getDiscountPercent() {
        if (!regularCustomer) {
            return 0.0;
        }
        if (totalBeforeDiscount.compareTo(BigDecimal.ZERO) == 0 ||
                totalDiscount.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }

        BigDecimal hundred = new BigDecimal("100");

        // сума, яку реально платимо
        BigDecimal discountedTotal = totalBeforeDiscount.subtract(totalDiscount);

        // скільки % від повної суми ми заплатили
        BigDecimal percentPaid = discountedTotal
                .multiply(hundred)
                .divide(totalBeforeDiscount, 13, RoundingMode.HALF_UP);

        // відсоток знижки = 100 - percentPaid
        BigDecimal percentDiscount = hundred.subtract(percentPaid);

        return percentDiscount.doubleValue();
    }
}
