package ca.mcgill.ecse429.shoppinglist.application;

import ca.mcgill.ecse429.shoppinglist.persistence.PersistenceShoppingList;
import ca.mcgill.ecse429.shoppinglist.view.ShoppingListPage;

public class ShoppingList {
	
	public static void main(String[] args) {
		// load model
		PersistenceShoppingList.loadEventRegistrationModel();
		
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingListPage().setVisible(true);
            }
        });
        
	}
}
