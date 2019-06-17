package com.Collections.SortedCollectionsChallenge;

public class Main {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		StockItem temp = new StockItem("bread", 0.86, 100);
		stockList.addStock(temp);

		temp = new StockItem("cake", 1.10, 7);
		stockList.addStock(temp);

		temp = new StockItem("car", 12.50, 2);
		stockList.addStock(temp);

		temp = new StockItem("chair", 62.0, 10);
		stockList.addStock(temp);

		temp = new StockItem("cup", 0.50, 200);
		stockList.addStock(temp);
		temp = new StockItem("cup", 0.45, 7);
		stockList.addStock(temp);

		temp = new StockItem("door", 72.95, 4);
		stockList.addStock(temp);

		temp = new StockItem("juice", 2.50, 36);
		stockList.addStock(temp);

		temp = new StockItem("phone", 96.99, 35);
		stockList.addStock(temp);

		temp = new StockItem("towel", 2.40, 80);
		stockList.addStock(temp);

		temp = new StockItem("vase", 8.76, 40);
		stockList.addStock(temp);

		System.out.println(stockList);

		Basket timsBasket = new Basket("Tim");
		addIntoBasket(timsBasket, "vase", 5);
		addIntoBasket(timsBasket, "vase", 5);
		addIntoBasket(timsBasket, "vase", 25);
		addIntoBasket(timsBasket, "vase", 6);
		stockList.sellBasket(timsBasket);
		System.out.println(stockList);
		stockList.releaseStock("vase");
		System.out.println(stockList);

	}

	public static int addIntoBasket(Basket basket, String item, int quantity) {
		System.out.println("Booking "+ quantity + " " + item + "(s).....");
		StockItem stockItem = stockList.get(item);
		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		if ((stockItem.quantityInStock() >= quantity) && quantity > 0) {
			stockItem.reserveStock(quantity);
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		System.out.println("Your request of " + quantity + " "+ item+"(s) cannot be processed as store has "
				+ stockItem.quantityInStock() + " left.");
		return 0;

	}

}
