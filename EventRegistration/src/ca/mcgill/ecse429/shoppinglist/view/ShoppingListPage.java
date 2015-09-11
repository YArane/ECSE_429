package ca.mcgill.ecse429.shoppinglist.view;

import java.awt.Color;
import java.awt.Font;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ca.mcgill.ecse429.shoppinglist.controller.ShoppingListController;
import ca.mcgill.ecse429.shoppinglist.model.Item;
import ca.mcgill.ecse429.shoppinglist.model.ShoppingListManager;
import ca.mcgill.ecse429.shoppinglist.model.StoreVisit;

public class ShoppingListPage extends JFrame {

	private static final long serialVersionUID = -4426310869335015542L;
	
	// UI elements
	private JLabel title;
	private JLabel errorMessage;
	private JComboBox<String> itemList;
	private JLabel itemLabel;
	private JComboBox<String> storeVisitList;
	private JLabel storeVisitLabel;
	private JButton addToShoppingListButton;
	private JSeparator separator1;
	private JTextField itemNameTextField;
	private JLabel itemNameLabel;
	private JButton addItemButton;
	private JSeparator separator2;
	private JTextField storeVisitNameTextField;
	private JLabel storeVisitNameLabel;
	private JDatePickerImpl storeVisitDatePicker;
	private JLabel storeVisitDateLabel;
	private JSpinner storeVisitStartTimeSpinner;
	private JLabel storevisitStartTimeLabel;
	private JSpinner storeVisitEndTimeSpinner;
	private JLabel storeVisitEndTimeLabel;
	private JButton addStoreVisitButton;
	
	// data elements
	private String error = null;
	private Integer selectedItem = -1;
	private HashMap<Integer, Item> items;
	private Integer selectedStoreVisit = -1;
	private HashMap<Integer, StoreVisit> storeVisits;
	
	/** Creates new form EventRegistrationPage */
	public ShoppingListPage() {
		initComponents();
		refreshData();
	}

	/** This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		// name of application
		title = new JLabel();
		title.setFont(new Font("Serif", Font.BOLD, 24));
		
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		// elements for registration
		itemList = new JComboBox<String>(new String[0]);
		itemList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedItem = cb.getSelectedIndex();
			}
		});
		itemLabel = new JLabel();
		storeVisitList = new JComboBox<String>(new String[0]);
		storeVisitList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedStoreVisit = cb.getSelectedIndex();
			}
		});
		storeVisitLabel = new JLabel();

		addToShoppingListButton = new JButton();
		separator1 = new JSeparator(SwingConstants.HORIZONTAL);
		
		// elements for participant
		itemNameTextField = new JTextField();
		itemNameLabel = new JLabel();
		addItemButton = new JButton();
		separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		
		// elements for event
		storeVisitNameTextField = new JTextField();
		storeVisitNameLabel = new JLabel();
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		storeVisitDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		storeVisitDateLabel = new JLabel();
		storeVisitStartTimeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(storeVisitStartTimeSpinner, "HH:mm");
		storeVisitStartTimeSpinner.setEditor(startTimeEditor); // will only show the current time
		storevisitStartTimeLabel = new JLabel();
		storeVisitEndTimeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(storeVisitEndTimeSpinner, "HH:mm");
		storeVisitEndTimeSpinner.setEditor(endTimeEditor); // will only show the current time
		storeVisitEndTimeLabel = new JLabel();
		addStoreVisitButton = new JButton();

		// global settings and listeners
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Shopping List");
		
		title.setText("Shopping List:");
		itemLabel.setText("Select Item:");
		storeVisitLabel.setText("Select Store Visit:");
		addToShoppingListButton.setText("Add to Shopping List");
		addToShoppingListButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addToShoppingListButtonActionPerformed(evt);
			}
		});

		itemNameLabel.setText("Name:");
		addItemButton.setText("Add Item");
		addItemButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addItemButtonActionPerformed(evt);
			}
		});

		storeVisitNameLabel.setText("Name:");
		storeVisitDateLabel.setText("Date:");
		storevisitStartTimeLabel.setText("Start Time:");
		storeVisitEndTimeLabel.setText("End time:");
		addStoreVisitButton.setText("Add Store Visit");
		addStoreVisitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStoreVisitButtonActionPerformed(evt);
			}
		});
		
		// layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(title)
				.addComponent(errorMessage)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(itemLabel)
								.addComponent(storeVisitLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(itemList)
								.addComponent(storeVisitList)
								.addComponent(addToShoppingListButton)))
				.addComponent(separator1)
				.addGroup(layout.createSequentialGroup()
						.addComponent(itemNameLabel)
						.addGroup(layout.createParallelGroup()
								.addComponent(itemNameTextField, 200, 200, 400)
								.addComponent(addItemButton)))
				.addComponent(separator2)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(storeVisitNameLabel)
								.addComponent(storeVisitDateLabel)
								.addComponent(storevisitStartTimeLabel)
								.addComponent(storeVisitEndTimeLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(storeVisitNameTextField, 200, 200, 400)
								.addComponent(storeVisitDatePicker)
								.addComponent(storeVisitStartTimeSpinner)
								.addComponent(storeVisitEndTimeSpinner)
								.addComponent(addStoreVisitButton)))
				);

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {itemList, storeVisitList, addToShoppingListButton, itemNameTextField, addItemButton, 
				storeVisitNameTextField, storeVisitDatePicker, storeVisitStartTimeSpinner, storeVisitEndTimeSpinner, addStoreVisitButton});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {storeVisitLabel, itemNameLabel, storeVisitNameLabel});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(title)
				.addComponent(errorMessage)
				.addGroup(layout.createParallelGroup()
						.addComponent(itemLabel)
						.addComponent(itemList))
				.addGroup(layout.createParallelGroup()
						.addComponent(storeVisitLabel)
						.addComponent(storeVisitList))
				.addComponent(addToShoppingListButton)
				.addComponent(separator1)
				.addGroup(layout.createParallelGroup()
						.addComponent(itemNameLabel)
						.addComponent(itemNameTextField))
				.addComponent(addItemButton)
				.addComponent(separator2)
				.addGroup(layout.createParallelGroup()
						.addComponent(storeVisitNameLabel)
						.addComponent(storeVisitNameTextField))		
				.addGroup(layout.createParallelGroup()
						.addComponent(storeVisitDateLabel)
						.addComponent(storeVisitDatePicker))
				.addGroup(layout.createParallelGroup()
						.addComponent(storevisitStartTimeLabel)
						.addComponent(storeVisitStartTimeSpinner))
				.addGroup(layout.createParallelGroup()
						.addComponent(storeVisitEndTimeLabel)								
						.addComponent(storeVisitEndTimeSpinner))
				.addComponent(addStoreVisitButton)
				);
		
		pack();
	}

	private void refreshData() {
		ShoppingListManager rm = ShoppingListManager.getInstance();
		// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			// item list
			items = new HashMap<Integer, Item>();
			itemList.removeAllItems();
			Iterator<Item> iIt = rm.getItems().iterator();
			Integer index = 0;
			while (iIt.hasNext()) {
				Item i = iIt.next();
				items.put(index, i);
				itemList.addItem(i.getName());
				index++;
			}
			selectedItem = -1;
			itemList.setSelectedIndex(selectedItem);
			// store visit list
			storeVisits = new HashMap<Integer, StoreVisit>();
			storeVisitList.removeAllItems();
			Iterator<StoreVisit> svIt = rm.getStoreVisits().iterator();
			index = 0;
			while (svIt.hasNext()) {
				StoreVisit sv = svIt.next();
				storeVisits.put(index, sv);
				storeVisitList.addItem(sv.getName());
				index++;
			}
			selectedStoreVisit = -1;
			storeVisitList.setSelectedIndex(selectedStoreVisit);
			// item
			itemNameTextField.setText("");
			// store visit
			storeVisitNameTextField.setText("");
			storeVisitDatePicker.getModel().setValue(null);
			storeVisitStartTimeSpinner.setValue(new Date()); 
			storeVisitEndTimeSpinner.setValue(new Date());
		}

		// this is needed because the size of the window changes depending on whether an error message is shown or not
		pack();
	}

	private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		ShoppingListController erc = new ShoppingListController();
		error = erc.createItem(itemNameTextField.getText());
		// update visuals
		refreshData();
	}

	private void addStoreVisitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		ShoppingListController erc = new ShoppingListController();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) storeVisitStartTimeSpinner.getValue());
		Time startTime = new Time(calendar.getTime().getTime());
		calendar.setTime((Date) storeVisitEndTimeSpinner.getValue());
		Time endTime = new Time(calendar.getTime().getTime());
		error = erc.createStoreVisit(storeVisitNameTextField.getText(), (java.sql.Date) storeVisitDatePicker.getModel().getValue(), startTime, endTime);
		// update visuals
		refreshData();
	}

	private void addToShoppingListButtonActionPerformed(java.awt.event.ActionEvent evt) {
		error = "";
		if (selectedItem < 1)
			error = error + "Item needs to be selected for registration! ";
		if (selectedStoreVisit < 1)
			error = error + "Store Visit needs to be selected for registration!";
		error = error.trim();
		if (error.length() == 0) {
			// call the controller
			ShoppingListController erc = new ShoppingListController();
			error = erc.addToShoppingList(items.get(selectedItem), storeVisits.get(selectedStoreVisit));
		}
		// update visuals
		refreshData();			
	}

}
