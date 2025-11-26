package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    protected List<Item> items = new ArrayList<>();

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public Employee getClerk() {
        return clerk;
    }

    public void add(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double sum = 0.0;
        for (Item i : items) sum += i.getPrice();
        return sum;
    }
}
