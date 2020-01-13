package timbuchalka.Collections.SortedCollections;

public class StockItem implements Comparable<StockItem> {
	private final String name;
	private double price;
	private int quantityStock = 0;

	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0; // or initialize here (but you wouldn't normally do both).
	}

	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int quantityInStock() {
		return quantityStock;
	}

	public void setPrice(double price) {
		if (price > 0.0) {
			this.price = price;
		}
	}

	public void adjustStock(int quantity) {
		int newQuantity = this.quantityStock + quantity;
		if (newQuantity >= 0) {
			this.quantityStock = newQuantity;
		}
	}

	@Override
	public boolean equals(Object obj) { // needed by Sets and Maps
		// Used to compare object equality. Only tells if two given objects are equal or
		// not
		// Default equals method only checks for referential equality but we can
		// implement
		// to check for actual values as well.
		System.out.println("Entering StockItem.equals");
		if (obj == this) {
			return true;
		}

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		String objName = ((StockItem) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 31;
	}

	@Override
	public int compareTo(StockItem o) { // used by the Collections class for sort and searchmethod
		// Part of Comparable interface
		// Tells if the value of an object is >, = or < the current object.
		System.out.println("Entering StockItem.compareTo");
		if (this == o) {
			return 0;
		}

		if (o != null) {
			return this.name.compareTo(o.getName());
		}

		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return this.name + " : price " + this.price;
	}
}
