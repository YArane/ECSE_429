package ca.mcgill.ecse429.shoppinglist.model;

import java.sql.Date;
import java.sql.Time;

public class StoreVisit
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StoreVisit Attributes
  private String name;
  private Date shoppingDate;
  private Time shoppingStartTime;
  private Time shoppingEndTime;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StoreVisit(String aName, Date aShoppingDate, Time aShoppingStartTime, Time aShoppingEndTime)
  {
    name = aName;
    shoppingDate = aShoppingDate;
    shoppingStartTime = aShoppingStartTime;
    shoppingEndTime = aShoppingEndTime;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setShoppingDate(Date aShoppingDate)
  {
    boolean wasSet = false;
    shoppingDate = aShoppingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setShoppingStartTime(Time aShoppingStartTime)
  {
    boolean wasSet = false;
    shoppingStartTime = aShoppingStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setShoppingEndTime(Time aShoppingEndTime)
  {
    boolean wasSet = false;
    shoppingEndTime = aShoppingEndTime;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Date getShoppingDate()
  {
    return shoppingDate;
  }

  public Time getShoppingStartTime()
  {
    return shoppingStartTime;
  }

  public Time getShoppingEndTime()
  {
    return shoppingEndTime;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "shoppingDate" + "=" + (getShoppingDate() != null ? !getShoppingDate().equals(this)  ? getShoppingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "shoppingStartTime" + "=" + (getShoppingStartTime() != null ? !getShoppingStartTime().equals(this)  ? getShoppingStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "shoppingEndTime" + "=" + (getShoppingEndTime() != null ? !getShoppingEndTime().equals(this)  ? getShoppingEndTime().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}