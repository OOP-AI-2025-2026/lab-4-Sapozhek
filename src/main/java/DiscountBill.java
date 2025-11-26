import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item item) {
        super.items.add(item);

        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = 0.0;

        for (Item i : items) {
            if (regularCustomer)
                total += (i.getPrice() - i.getDiscount());
            else
                total += i.getPrice();
        }

        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;

        double full = 0.0;
        double discounted = 0.0;

        for (Item i : items) {
            full += i.getPrice();
            discounted += (i.getPrice() - i.getDiscount());
        }

        if (full == 0.0) return 0.0;

        return 100 - (discounted * 100.0 / full);
    }
}
