package ca.mcgill.ecse429.shoppinglist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingListManager
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ShoppingListManager theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ShoppingListManager Associations
  private List<ShoppingListItem> shoppingListItems;
  private List<Item> items;
  private List<StoreVisit> storeVisits;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ShoppingListManager()
  {
    shoppingListItems = new ArrayList<ShoppingListItem>();
    items = new ArrayList<Item>();
    storeVisits = new ArrayList<StoreVisit>();
  }

  public static ShoppingListManager getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ShoppingListManager();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ShoppingListItem getShoppingListItem(int index)
  {
    ShoppingListItem aShoppingListItem = shoppingListItems.get(index);
    return aShoppingListItem;
  }

  public List<ShoppingListItem> getShoppingListItems()
  {
    List<ShoppingListItem> newShoppingListItems = Collections.unmodifiableList(shoppingListItems);
    return newShoppingListItems;
  }

  public int numberOfShoppingListItems()
  {
    int number = shoppingListItems.size();
    return number;
  }

  public boolean hasShoppingListItems()
  {
    boolean has = shoppingListItems.size() > 0;
    return has;
  }

  public int indexOfShoppingListItem(ShoppingListItem aShoppingListItem)
  {
    int index = shoppingListItems.indexOf(aShoppingListItem);
    return index;
  }

  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }

  public StoreVisit getStoreVisit(int index)
  {
    StoreVisit aStoreVisit = storeVisits.get(index);
    return aStoreVisit;
  }

  public List<StoreVisit> getStoreVisits()
  {
    List<StoreVisit> newStoreVisits = Collections.unmodifiableList(storeVisits);
    return newStoreVisits;
  }

  public int numberOfStoreVisits()
  {
    int number = storeVisits.size();
    return number;
  }

  public boolean hasStoreVisits()
  {
    boolean has = storeVisits.size() > 0;
    return has;
  }

  public int indexOfStoreVisit(StoreVisit aStoreVisit)
  {
    int index = storeVisits.indexOf(aStoreVisit);
    return index;
  }

  public static int minimumNumberOfShoppingListItems()
  {
    return 0;
  }

  public boolean addShoppingListItem(ShoppingListItem aShoppingListItem)
  {
    boolean wasAdded = false;
    if (shoppingListItems.contains(aShoppingListItem)) { return false; }
    shoppingListItems.add(aShoppingListItem);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShoppingListItem(ShoppingListItem aShoppingListItem)
  {
    boolean wasRemoved = false;
    if (shoppingListItems.contains(aShoppingListItem))
    {
      shoppingListItems.remove(aShoppingListItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShoppingListItemAt(ShoppingListItem aShoppingListItem, int index)
  {  
    boolean wasAdded = false;
    if(addShoppingListItem(aShoppingListItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShoppingListItems()) { index = numberOfShoppingListItems() - 1; }
      shoppingListItems.remove(aShoppingListItem);
      shoppingListItems.add(index, aShoppingListItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShoppingListItemAt(ShoppingListItem aShoppingListItem, int index)
  {
    boolean wasAdded = false;
    if(shoppingListItems.contains(aShoppingListItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShoppingListItems()) { index = numberOfShoppingListItems() - 1; }
      shoppingListItems.remove(aShoppingListItem);
      shoppingListItems.add(index, aShoppingListItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShoppingListItemAt(aShoppingListItem, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfItems()
  {
    return 0;
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (items.contains(aItem))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfStoreVisits()
  {
    return 0;
  }

  public boolean addStoreVisit(StoreVisit aStoreVisit)
  {
    boolean wasAdded = false;
    if (storeVisits.contains(aStoreVisit)) { return false; }
    storeVisits.add(aStoreVisit);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStoreVisit(StoreVisit aStoreVisit)
  {
    boolean wasRemoved = false;
    if (storeVisits.contains(aStoreVisit))
    {
      storeVisits.remove(aStoreVisit);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStoreVisitAt(StoreVisit aStoreVisit, int index)
  {  
    boolean wasAdded = false;
    if(addStoreVisit(aStoreVisit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStoreVisits()) { index = numberOfStoreVisits() - 1; }
      storeVisits.remove(aStoreVisit);
      storeVisits.add(index, aStoreVisit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStoreVisitAt(StoreVisit aStoreVisit, int index)
  {
    boolean wasAdded = false;
    if(storeVisits.contains(aStoreVisit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStoreVisits()) { index = numberOfStoreVisits() - 1; }
      storeVisits.remove(aStoreVisit);
      storeVisits.add(index, aStoreVisit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStoreVisitAt(aStoreVisit, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    shoppingListItems.clear();
    items.clear();
    storeVisits.clear();
  }

}