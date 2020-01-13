package collections.SortedCollectionsChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dev on 17/02/2016.
 */
public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list; // <item,quantityInBasket>

	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}

	public int addToBasket(StockItem item, int quantity) {
		if ((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item, 0); // getting the quantity of item, if it is already in the list
			list.put(item, inBasket + quantity); // adding to it the quantity passed to this method
			return inBasket;
		}
		return 0;
	}

	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
		double totalCost = 0.0;
		for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
			s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		return s + "Total cost " + totalCost;
	}
}
