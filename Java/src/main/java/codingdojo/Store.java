package codingdojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a physical Store where you can go and buy
 * products and attend events.
 */
public class Store {

    private final Map<String, Product> itemsInStock = new HashMap<>();
    private final String name;

    public Store(String name, Product[] products) {
        this.name = name;
        this.addStockedItems(products);
    }

    public void addStockedItems(Product... items) {
        for (Product item: items) {
            this.itemsInStock.put(item.getName(), item);
        }
    }

    public void addStoreEvent(StoreEvent storeEvent) {
        this.itemsInStock.put(storeEvent.getName(), storeEvent);
    }

    @Override
    public String toString() {
        return "Store{" + name + '}';
    }

    public String getName() {
        return name;
    }

    public Collection<Product> getStock() {
        return Collections.unmodifiableCollection(this.itemsInStock.values());
    }
}
