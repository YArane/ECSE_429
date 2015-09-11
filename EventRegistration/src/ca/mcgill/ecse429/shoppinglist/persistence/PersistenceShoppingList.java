package ca.mcgill.ecse429.shoppinglist.persistence;

import java.util.Iterator;

import ca.mcgill.ecse429.shoppinglist.model.Item;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListItem;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListManager;
import ca.mcgill.ecse429.shoppinglist.model.StoreVisit;

public class PersistenceShoppingList {

	private static void initializeXStream() {
		PersistenceXStream.setFilename("shoppinglist.xml");
		PersistenceXStream.setAlias("storevisit", StoreVisit.class);
		PersistenceXStream.setAlias("item", Item.class);
		PersistenceXStream.setAlias("shoppinglistitem", ShoppingListItem.class);
		PersistenceXStream.setAlias("manager", ShoppingListManager.class);
	}

	public static void loadEventRegistrationModel() {
		ShoppingListManager rm = ShoppingListManager.getInstance();
		PersistenceShoppingList.initializeXStream();
		ShoppingListManager rm2 = (ShoppingListManager) PersistenceXStream.loadFromXMLwithXStream();
		if (rm2 != null) {
			// unfortunately, this creates a second ShoppingListManager object, even though it is a singleton
			// copy loaded model into singleton instance of ShoppingListManager, because this will be used throughout the application
			Iterator<Item> iIt = rm2.getItems().iterator();
			while (iIt.hasNext())
				rm.addItem(iIt.next());
			Iterator<StoreVisit> svIt = rm2.getStoreVisits().iterator();
			while (svIt.hasNext())
				rm.addStoreVisit(svIt.next());
			Iterator<ShoppingListItem> sliIt = rm2.getShoppingListItems().iterator();
			while (sliIt.hasNext())
				rm.addShoppingListItem(sliIt.next());
		}
	}

}
