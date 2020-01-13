package collections.SortedCollectionsChallenge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 16/02/2016.
 */
public class StockList {
	private final Map<String, StockItem> list;

	public StockList() {
		this.list = new LinkedHashMap<>(); // Can be a Unsorted Collection like HashMap or a Sorted one like
											// LinkedHashMap
	}

	public int addStock(StockItem item) {
		if (item != null) { // if item is null -> We dont do anything!

			// check if list already has quantities of this item :-
			StockItem inStock = list.getOrDefault(item.getName(), item);
			// returns value at item.getName() if item.getName() is a
			// valid key in list, otherwise it returns item
			// Three cases arise after the above line
			// 1. item.getName() is not present as a key in list - > item is not present,
			// hence we need to just add item to list
			// 2. item.getName() is a key in list and its value which is a StockItem
			// reference points to the same StockItem object which item points to, then we
			// don't need to adjust the quantity as both are inherently the same object and
			// we can just add the new item to list.
			// 3. item.getName() is a key in list, but its value is not pointing to the
			// object item is pointing to ie. item and object at that key have same name but
			// are different objects, then we just add the quantities of both using
			// adjustStock and add the new item to the list, replacing the older one

			// If there are already stocks on this item, adjust the quantity
			if (inStock != item) {
				item.addStock(inStock.quantityInStock());
			}

			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		return 0;
	}

	public int sellStock(String item) {
		StockItem inStock = list.getOrDefault(item, null);
		if (inStock != null) {
			inStock.sellStock();
			return 1;
		}
		return 0;
	}

	public int releaseStock(String item) {
		System.out.println("Removing stock of " + item + " from basket.");
		StockItem inStock = list.getOrDefault(item, null);
		if (inStock != null) {
			inStock.releaseStock();
			return 1;
		}
		return 0;
	}

	public void sellBasket(Basket basket) {
		System.out.println("Checking out your basket....");
		if (basket != null) {
			Map<StockItem, Integer> basketItems = basket.Items(); // get items in the basket

			// sell each item of the basket
			for (Map.Entry<StockItem, Integer> item : basketItems.entrySet()) {
				sellStock(item.getKey().getName()); // send item name and item quantity to sellStock
			}
		} else {
			System.out.println("Basket is empty!");
		}
	}

	public StockItem get(String key) {
		return list.get(key);
	}

	public Map<String, StockItem> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for (Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();

			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}

		return s + "Total stock value " + String.format("%.2f", totalCost) + "\n\n";
	}

	public Map<String, Double> PriceList() {
		Map<String, Double> prices = new LinkedHashMap<>();
		for (Map.Entry<String, StockItem> item : list.entrySet()) {
			prices.put(item.getKey(), item.getValue().getPrice());
		}
		return Collections.unmodifiableMap(prices);
	}
}
