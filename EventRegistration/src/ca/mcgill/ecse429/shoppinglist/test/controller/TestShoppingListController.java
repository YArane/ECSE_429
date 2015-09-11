package ca.mcgill.ecse429.shoppinglist.test.controller;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse429.shoppinglist.controller.ShoppingListController;
import ca.mcgill.ecse429.shoppinglist.model.Item;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListItem;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListManager;
import ca.mcgill.ecse429.shoppinglist.model.StoreVisit;
import ca.mcgill.ecse429.shoppinglist.persistence.PersistenceXStream;

public class TestShoppingListController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersistenceXStream.setFilename("src\\ca\\mcgill\\ecse429\\shoppinglist\\test\\controller\\data.xml");
		PersistenceXStream.setAlias("storevisit", StoreVisit.class);
		PersistenceXStream.setAlias("item", Item.class);
		PersistenceXStream.setAlias("shoppinglistitem", ShoppingListItem.class);
		PersistenceXStream.setAlias("manager", ShoppingListManager.class);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCreateItem() {
		ShoppingListManager slm= ShoppingListManager.getInstance();
		assertEquals(0, slm.getItems().size());
		String name= "Oranges";
		ShoppingListController slc= new ShoppingListController();
		String error= slc.createItem(name);
		
		// check error
		assertNull(error);
		
		// check model in memory
		testItemModel(slm, name);
		
		ShoppingListManager slm2 = (ShoppingListManager)PersistenceXStream.loadFromXMLwithXStream();
		// check file content
		testItemModel(slm2, name);
	}
	
	private void testItemModel(ShoppingListManager slm, String name){
		assertEquals(1, slm.getItems().size());
		assertEquals(name, slm.getItem(0).getName());
		assertEquals(0, slm.getStoreVisits().size());
		assertEquals(0, slm.getShoppingListItems().size());
	}
	
	@Test
	public void testCreateStoreVisit(){
		ShoppingListManager slm = ShoppingListManager.getInstance();
		assertEquals(true, slm.getStoreVisits().isEmpty());
		
		String name = "provigo";
		Date date = new Date(0l);
		Time startTime = new Time(0l);
		Time endTime = new Time(0l);
		
		ShoppingListController slc = new ShoppingListController();
		String error = slc.createStoreVisit(name, date, startTime, endTime);
		
		//check error
		assertNull(error);
		
		// check model in memory
		testStoreVisitModel(slm, name, date, startTime, endTime);
				
		ShoppingListManager slm2 = (ShoppingListManager)PersistenceXStream.loadFromXMLwithXStream();
		// check file content
		testStoreVisitModel(slm2, name, date, startTime, endTime);
	}
	
	private void testStoreVisitModel(ShoppingListManager slm, String name, Date date, Time startTime, Time endTime){
		assertEquals(1, slm.getStoreVisits().size());
		assertEquals(name, slm.getStoreVisit(0).getName());
		assertEquals(date, slm.getStoreVisit(0).getShoppingDate());
		assertEquals(startTime, slm.getStoreVisit(0).getShoppingStartTime());
		assertEquals(endTime, slm.getStoreVisit(0).getShoppingEndTime());
		assertEquals(0, slm.getItems().size());
		assertEquals(0, slm.getShoppingListItems().size());
	}

}
