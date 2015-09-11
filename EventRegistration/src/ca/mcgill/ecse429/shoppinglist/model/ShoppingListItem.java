package ca.mcgill.ecse429.shoppinglist.model;

public class ShoppingListItem
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int id;

  //ShoppingListItem Associations
  private Item item;
  private StoreVisit storeVisit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShoppingListItem(Item aItem, StoreVisit aStoreVisit)
  {
    id = nextId++;
    if (!setItem(aItem))
    {
      throw new RuntimeException("Unable to create ShoppingListItem due to aItem");
    }
    if (!setStoreVisit(aStoreVisit))
    {
      throw new RuntimeException("Unable to create ShoppingListItem due to aStoreVisit");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getId()
  {
    return id;
  }

  public Item getItem()
  {
    return item;
  }

  public StoreVisit getStoreVisit()
  {
    return storeVisit;
  }

  public boolean setItem(Item aNewItem)
  {
    boolean wasSet = false;
    if (aNewItem != null)
    {
      item = aNewItem;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setStoreVisit(StoreVisit aNewStoreVisit)
  {
    boolean wasSet = false;
    if (aNewStoreVisit != null)
    {
      storeVisit = aNewStoreVisit;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    item = null;
    storeVisit = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "storeVisit = "+(getStoreVisit()!=null?Integer.toHexString(System.identityHashCode(getStoreVisit())):"null")
     + outputString;
  }
}