package codingdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Order {

    private final String id;
    private final Date date;
    private Collection<Product> products = new ArrayList<>();

    public Order(String id, Date date, Product[] products) {
        this.id = id;
        this.date = date;
        addProducts(products);
    }

    public double totalDollars() {
        return products.stream(). //
                mapToDouble(product -> product.getPrice().getAmountInCurrency("USD")). //
                sum();
    }

    @Override
    public String toString() {
        return "Order{" + id + '}';
    }

    public String getId() {
        return id;
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(products);
    }

    public Date getDate() {
        return date;
    }

    public void addProducts(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

}
