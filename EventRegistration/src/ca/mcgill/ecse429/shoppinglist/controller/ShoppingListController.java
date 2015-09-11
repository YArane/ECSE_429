package ca.mcgill.ecse429.shoppinglist.controller;

import java.sql.Date;
import java.sql.Time;

import ca.mcgill.ecse429.shoppinglist.model.Item;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListManager;
import ca.mcgill.ecse429.shoppinglist.model.StoreVisit;
import ca.mcgill.ecse429.shoppinglist.persistence.PersistenceXStream;

public class ShoppingListController {
	
	public ShoppingListController () 
	{
	}
	
	public String createItem(String name)
	{
		Item newItem = new Item(name);
		ShoppingListManager slm = ShoppingListManager.getInstance();
		slm.addItem(newItem);
		PersistenceXStream.saveToXMLwithXStream(slm);
		return null;
	}

	public String createStoreVisit(String name, Date date, Time startTime, Time endTime)
	{
		// TODO test-driven development
		return null;
	}
	
	public String addToShoppingList(Item item, StoreVisit storeVisit)
	{
		// TODO test-driven development
		return null;
	}

}
