import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

public class screen1 {
	double order_calories,order_price ;
	String order_contents;
	CafeOrder cafe_order;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;
	private JMenuBar menuBar;
	private JTable table_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JSpinner spinner, spinner_1, spinner_2, spinner_3, spinner_4, spinner_5, spinner_6, spinner_7, spinner_8, spinner_9, spinner_10, spinner_11, spinner_12,spinner_13 , spinner_14, spinner_15;
	private JPanel parentPanel, panel_2, panel_3,MenuItem, panel_1, Item, panel, panel_4, panel_5 ;
	private JTable table_3,table_1_1;
	private JRadioButton rdbtnViewCalorieChart,rdbtnViewExpensesChart,rdbtnViewCalorieChart_1,rdbtnViewExpenseChart;
	private JButton btnSave, btnSubmit,btnVendingMachine, btnBack, btnBack_1, btnBack_2, btnAddToCart, btnNewButton, btnBack_3, btnClickToBuy, btnBack_4, btnBack_5, btnCheckOut;
	private Users user;  // user object created
	private Menu menu ;   // menu created
	int cafeid;
    DefaultTableModel model;
	private Login login;
	CafeMenu cafe;
	JList listModel;
	JLabel lblAddon, lblNewLabel_1, lblUserName, lblPassword,  lblCardNumber, lblNewLabel,lblNewLabel_6, lblNewLabel_7, lblPreferences, label_2, lblNewLabel_3, lblItemName, lblOrangeJuice, lblNewLabel_2, label, lblPrice, label_1, lblYourCaloriesConsumed, label_3, lblJk, lblExpensesForThe, label_4, lblKk,lblVisualizeYourSpending, lblKk_1, lblTrackYourDay,lblOrderDetails, lblCardNumber_1, label_5, label_6, lblTotal, lblAmount, lblNewLabel_4, lblNewLabel_5, label_7, label_8, label_9, label_10,label_11,label_12,label_13, label_14, label_15, label_16, label_17, label_18, label_19, label_20, label_21, label_22 ;
	private JButton btnNewButton_1;
	DefaultTableModel model_checkOut;
	Tracker tracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			    Font police1 = new Font("Tahoma", Font.BOLD, 12);

				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				        	//UIManager.put("nimbusBase", new Color(255, 250, 213)); //toolbar color, checkbox color, menu color
				        	//UIManager.put("nimbusBlueGrey", new Color(255, 250, 213)); //button color
				        	 
				        	UIManager.put("control", new Color(214,85,56));//background color
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				        
				    }
					screen1 window = new screen1();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
			        window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void item_panel(int row) {
		String selectedObject = (String) table_1_1.getValueAt(table_1_1.getSelectedRow(), 0);
		double cal = (double) table_1_1.getValueAt(table_1_1.getSelectedRow(), 1);
		double price = (double) table_1_1.getValueAt(table_1_1.getSelectedRow(), 2);
		lblOrangeJuice.setText(selectedObject);
		label.setText(Double.toString(cal));
		label_1.setText(Double.toString(price));
		lblNewLabel_1.setIcon(new ImageIcon("drink.jpg"));
	}

	/**
	 * Create the application.
	 */
	public screen1() {
		login = new Login();           // login object created
		cafe =new CafeMenu();
	    cafe_order = new CafeOrder();
	    tracker = new Tracker();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 parentPanel = new JPanel();
		panel_2 = new JPanel();
		
		frame.getContentPane().add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));

		 panel_3 = new JPanel();
		
		
		//	panel_3.setBackground(new Color(51, 102, 153));
		//panel_3.setForeground(Color.BLACK);
		parentPanel.add(panel_3, "name_1464764576307990000");
		
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("166px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("126px"),
				ColumnSpec.decode("161px"),
				ColumnSpec.decode("147px"),
				ColumnSpec.decode("max(68dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("119px"),
				RowSpec.decode("28px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(6dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				RowSpec.decode("max(6dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				RowSpec.decode("29px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Login Window
		 lblUserName = new JLabel("User Name: ");
		//lblUserName.setForeground(new Color(255, 255, 255));
		panel_3.add(lblUserName, "4, 4, right, center");
		
		textField_2 = new JTextField();
		panel_3.add(textField_2, "5, 4, left, top");
		textField_2.setColumns(10);
		
		 lblPassword = new JLabel("Password: ");
		//lblPassword.setForeground(new Color(255, 255, 255));
		panel_3.add(lblPassword, "4, 8, right, center");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "5, 8, left, top");
		textField_1.setColumns(10);
		
		 lblCardNumber = new JLabel("Card Number: ");
		//lblCardNumber.setForeground(new Color(255, 255, 255));
		panel_3.add(lblCardNumber, "4, 11, right, center");
		
		textField = new JTextField();
		panel_3.add(textField, "5, 11, left, top");
		textField.setColumns(10);
		
		
		 btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BarChart_AWT chart = new BarChart_AWT("Calorie Statistics", "Weekly Calorie Consumption Stats");
			      chart.pack( );        
			      RefineryUtilities.centerFrameOnScreen( chart );        
			      chart.setVisible( true ); 
				parentPanel.removeAll();
				parentPanel.add(panel_2);
				menuBar.setVisible(true);
				parentPanel.repaint();
				parentPanel.revalidate();
				
				user = login.login(textField.getText().toString());   
				// user data retrieved 
				// if nothing is returned then pop the message card number invalid
				System.out.println(textField.getText().toString() + " "+ user);
				
			}
		});
		panel_3.add(btnSubmit, "5, 14, fill, top");
		
		parentPanel.add(panel_2, "name_1464764179340507000");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(68dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(68dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		 ArrayList data = new ArrayList();
		    data.add("Hi");
		    data.add("Hello");
		    data.add("Goodbye");
		     listModel = new JList(data.toArray());
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listModel.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		panel_2.add(listModel, "2, 1, 5, 6, fill, fill");
		 btnVendingMachine = new JButton("Vending Machine");

	
		panel_2.add(btnVendingMachine, "6, 16");
		
		 MenuItem = new JPanel();
		parentPanel.add(MenuItem, "name_1464771073903676000");
		MenuItem.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("33px"),
				ColumnSpec.decode("87px"),
				ColumnSpec.decode("8px"),
				ColumnSpec.decode("max(385px;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8px:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("fill:336px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

	     model = new DefaultTableModel() {
		  public boolean isCellEditable(int row, int column) {
		       //all cells false
		      if(column==3)
		      {
		    	  return true;
		      }
		      else
		      {
		    	  return false; 
		      }
		   }
		  @Override
		  public Class<?> getColumnClass(int columnIndex) {
		      Class type = String.class;
		      switch (columnIndex) {
		          case 3:
		              type = Boolean.class;
		              break;
		      }
		      return type;
		  }
		};
		

		// Create a couple of columns 
		model.addColumn("Item Name"); 
		model.addColumn("Calories"); 
		model.addColumn("Price"); 
		model.addColumn("Cart"); 

		// Append a row 
		
		
		
	
		
		lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MenuItem.add(lblNewLabel, "2, 4, 3, 1, center, top");

		JScrollPane scrollPane = new JScrollPane();
		MenuItem.add(scrollPane, "2, 6, 3, 1, fill, fill");
		table_1_1 = new JTable(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		//center align all the columns
		table_1_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );

		table_1_1.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(table_1_1);
		
		 btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_2);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		MenuItem.add(btnBack, "2, 8, left, fill");
		
		btnNewButton_1 = new JButton("Checkout");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			//checking what all items are checked to bill the amount	
			order_contents = "";	
			 order_price = 0;
			 order_calories = 0;
			
			for(int i = model_checkOut.getRowCount() -1 ; i >=0  ; i--) {
				model_checkOut.removeRow(i);
			}	
			
			for(int i = 0; i <table_1_1.getModel().getRowCount() ; i++) {
				Boolean isChecked = Boolean.valueOf(table_1_1.getValueAt(i, 3).toString());
		        	System.out.println(table_1_1.getValueAt(i, 3));
		        	 if (isChecked) { 
		        		 System.out.println(table_1_1.getValueAt(i, 1));
		        		//.addRow(new Object[]{menu.item.get(i).getName(), menu.item.get(i).getCalories()});   
		        	   model_checkOut.addRow(new Object[]{table_1_1.getValueAt(i, 0), table_1_1.getValueAt(i, 2)});
		        	   order_price = order_price + Double.parseDouble(table_1_1.getValueAt(i, 2).toString());
		        	   order_calories = order_calories + Double.parseDouble(table_1_1.getValueAt(i, 1).toString());
		        	   order_contents = order_contents + table_1_1.getValueAt(i, 0).toString() + " ";
		        	 } else {
		        	        System.out.printf("Row %s is not checked \n", i);
		        	    }
				} 
				lblAmount.setText(Double.toString(order_price));
				parentPanel.removeAll();
				parentPanel.add(panel_4);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		MenuItem.add(btnNewButton_1, "6, 8");
		
		//Preference setter Page
		 panel_1 = new JPanel();
		parentPanel.add(panel_1, "name_1464851248886721000");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		 lblNewLabel_6 = new JLabel("Calories for the day");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		 lblNewLabel_7 = new JLabel("Expenses for the day");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JSeparator separator = new JSeparator();
		
		JCheckBox chckbxLowSodium = new JCheckBox("Low Sodium");
		chckbxLowSodium.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxLowSugar = new JCheckBox("Low Sugar");
		chckbxLowSugar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxLow = new JCheckBox("Low Cholesterol");
		chckbxLow.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxFatFree = new JCheckBox("Fat Free");
		chckbxFatFree.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Vegan Free");
		chckbxNewCheckBox.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Low Sulfites");
		chckbxNewCheckBox_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Lactose Free");
		chckbxNewCheckBox_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JCheckBox chckbxGlutenFree = new JCheckBox("Gluten Free");
		chckbxGlutenFree.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		 lblPreferences = new JLabel("Preferences");
		lblPreferences.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		 btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_2);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		
		 label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/healthy.png"));
		
		 lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/time.png"));
		
		btnSave = new JButton("Save");
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(58)
					.addComponent(label_2)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addGap(83))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxFatFree)
						.addComponent(chckbxLow)
						.addComponent(chckbxLowSugar)
						.addComponent(chckbxLowSodium))
					.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox)
						.addComponent(chckbxNewCheckBox_1)
						.addComponent(chckbxNewCheckBox_2)
						.addComponent(chckbxGlutenFree))
					.addGap(87))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addComponent(lblPreferences)
					.addContainerGap(462, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack_1)
					.addGap(210)
					.addComponent(btnSave_1)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
								.addGap(19)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(1))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_7)
								.addGap(16)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_3)))
					.addGap(36)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblPreferences)
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxLowSodium)
						.addComponent(chckbxNewCheckBox))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxLowSugar)
						.addComponent(chckbxNewCheckBox_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxLow)
						.addComponent(chckbxNewCheckBox_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxFatFree)
						.addComponent(chckbxGlutenFree))
					.addGap(47)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack_1)
						.addComponent(btnSave_1))
					.addGap(75))
		);
		panel_1.setLayout(gl_panel_1);
		//Item specific page
		 Item = new JPanel();
		parentPanel.add(Item, "name_1464860752058386000");
		
		lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/drink.jpg"));
		
		 lblItemName = new JLabel("Item Name:");
		lblItemName.setForeground(Color.WHITE);
		
		 lblOrangeJuice = new JLabel("Orange Juice");
		lblOrangeJuice.setForeground(Color.WHITE);
		
		 lblNewLabel_2 = new JLabel("Calories:");
		lblNewLabel_2.setForeground(Color.WHITE);
		
		 label = new JLabel("100");
		label.setForeground(Color.WHITE);
		
		 lblPrice = new JLabel("Price: ");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBackground(Color.WHITE);
		
		 label_1 = new JLabel("$10.00");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.WHITE);
		
		JCheckBox chckbxLowSugar_1 = new JCheckBox("Extra Sweet + $5");
		chckbxLowSugar_1.setForeground(Color.WHITE);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Ice-cream + $3");
		chckbxNewCheckBox_3.setForeground(Color.WHITE);
		
		 lblAddon = new JLabel("Add-On:");
		lblAddon.setForeground(Color.WHITE);
		
		 btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(MenuItem);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		
		//Add to Cart
		 btnAddToCart = new JButton("Add to Cart");
		 btnAddToCart.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		String name = lblOrangeJuice.getText().toString();
		 		
		 		for( int i=0 ; i < model.getRowCount() ; i++) {
		 			if(table_1_1.getValueAt(i, 0).toString().equalsIgnoreCase(name)){
		 				table_1_1.setValueAt(true, i, 3);
		 			}
		 		}
		 	
		 	}
		 });
		
		 btnNewButton = new JButton("Checkout");
		
		GroupLayout gl_Item = new GroupLayout(Item);
		gl_Item.setHorizontalGroup(
			gl_Item.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Item.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack_2)
					.addContainerGap(544, Short.MAX_VALUE))
				.addGroup(gl_Item.createSequentialGroup()
					.addGap(218)
					.addGroup(gl_Item.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_Item.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Item.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Item.createSequentialGroup()
									.addGroup(gl_Item.createParallelGroup(Alignment.LEADING)
										.addComponent(lblItemName, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(lblPrice))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_Item.createParallelGroup(Alignment.LEADING)
										.addComponent(lblOrangeJuice)
										.addComponent(label_1)
										.addComponent(label)
										.addComponent(chckbxLowSugar_1)
										.addComponent(chckbxNewCheckBox_3)))
								.addComponent(lblAddon))
							.addContainerGap(167, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, gl_Item.createSequentialGroup()
					.addContainerGap(371, Short.MAX_VALUE)
					.addComponent(btnAddToCart)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(16))
		);
		gl_Item.setVerticalGroup(
			gl_Item.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Item.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Item.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddToCart)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_Item.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrangeJuice))
					.addGap(18)
					.addGroup(gl_Item.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_Item.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Item.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddon)
						.addComponent(chckbxLowSugar_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxNewCheckBox_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBack_2)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		Item.setLayout(gl_Item);
		
		panel = new JPanel();
		parentPanel.add(panel, "name_1464864524481843000");
		
		 lblYourCaloriesConsumed = new JLabel("Calories consumed for the day: ");
		lblYourCaloriesConsumed.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYourCaloriesConsumed.setForeground(Color.WHITE);
		
		 label_3 = new JLabel("20");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		 lblJk = new JLabel("");
		lblJk.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/trackc.png"));
		
		 lblExpensesForThe = new JLabel("Expenses for the day: ");
		lblExpensesForThe.setForeground(Color.WHITE);
		lblExpensesForThe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		 label_4 = new JLabel("$100.00");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_4.setForeground(Color.WHITE);
		
		 lblKk = new JLabel("");
		lblKk.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/wallet.png"));
		
		JSeparator separator_1 = new JSeparator();
		 rdbtnViewCalorieChart = new JRadioButton("View Calorie Chart (Day)");
		rdbtnViewCalorieChart.setForeground(Color.WHITE);
		rdbtnViewCalorieChart.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		 lblVisualizeYourSpending = new JLabel("Visualize your Spending & Calorie");
		lblVisualizeYourSpending.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblVisualizeYourSpending.setForeground(Color.WHITE);
		
		 rdbtnViewExpensesChart = new JRadioButton("View Expense Chart (Day)");
		rdbtnViewExpensesChart.setForeground(Color.WHITE);
		rdbtnViewExpensesChart.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		 rdbtnViewCalorieChart_1 = new JRadioButton("View Calorie Chart (Week)");
		rdbtnViewCalorieChart_1.setForeground(Color.WHITE);
		rdbtnViewCalorieChart_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		rdbtnViewExpenseChart = new JRadioButton("View Expense Chart (Week)");
		rdbtnViewExpenseChart.setForeground(Color.WHITE);
		rdbtnViewExpenseChart.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		ButtonGroup bg12 = new ButtonGroup();
		bg12.add(rdbtnViewExpensesChart);
		bg12.add(rdbtnViewCalorieChart_1);
		bg12.add(rdbtnViewExpenseChart);
		bg12.add(rdbtnViewCalorieChart);
		
		 lblKk_1 = new JLabel("");
		lblKk_1.setIcon(new ImageIcon("/Users/Surbhi/Downloads/presentation (1).png"));
		
		 btnBack_3 = new JButton("Back");
		 btnBack_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		parentPanel.removeAll();
		 		parentPanel.add(panel_2);
		 		parentPanel.repaint();
		 		parentPanel.revalidate();
		 	}
		 });
		
		 lblTrackYourDay = new JLabel("Track Your Day!");
		lblTrackYourDay.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTrackYourDay.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVisualizeYourSpending)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnViewCalorieChart)
										.addComponent(rdbtnViewExpensesChart))
									.addGap(66)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnViewExpenseChart)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblKk_1)
											.addComponent(rdbtnViewCalorieChart_1))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblJk)
								.addComponent(lblKk))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYourCaloriesConsumed)
										.addComponent(lblExpensesForThe))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4)
										.addComponent(label_3)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(114)
									.addComponent(lblTrackYourDay)))
							.addGap(53)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblKk_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(34)
									.addComponent(lblJk)
									.addGap(43))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTrackYourDay)
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblYourCaloriesConsumed)
										.addComponent(label_3))
									.addGap(52)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblExpensesForThe)
									.addComponent(label_4))
								.addComponent(lblKk))
							.addGap(31)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(lblVisualizeYourSpending)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnViewCalorieChart)
						.addComponent(rdbtnViewCalorieChart_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnViewExpensesChart)
						.addComponent(rdbtnViewExpenseChart))
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(btnBack_3)
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		
		//Code for checkout page
		 panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		parentPanel.add(panel_4, "name_40423761151387");
		
		 lblOrderDetails = new JLabel("Checkout");
		lblOrderDetails.setForeground(Color.WHITE);
		lblOrderDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JSeparator separator_2 = new JSeparator();
		
		 lblCardNumber_1 = new JLabel("Card Number: ");
		lblCardNumber_1.setForeground(Color.WHITE);
		lblCardNumber_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		 label_5 = new JLabel("2689");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		 label_6 = new JLabel("(222)-888-6778");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JSeparator separator_3 = new JSeparator();
	//Item list for the checkout page
		
		
		
		 lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		 lblAmount = new JLabel("$99");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		
		 btnClickToBuy = new JButton("Click to Buy");
		 btnClickToBuy.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	    int x[] = {0,0}; 
		 		cafe_order.addOrder(user.getId(), order_contents, (long)order_price);
		 		 x = tracker.getCalExp(user.getId(), "2016-05-31");
		 		 tracker.updateTracker(user.getId(), "2016-05-31",  (long)(x[0] + order_calories),  (long)(x[1] + order_price));
		 		
		 	}
		 });
		
		 lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/card.png"));
		
		 lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/Surbhi/Documents/workspace/TechTonic_GUI/cal.png"));
		
		//table_3 = new JTable();
		
		 model_checkOut = new DefaultTableModel(){
				public boolean isCellEditable(int row, int column) {
				       //all cells false
				    return false;
				   }
		};

			// Create a couple of columns 
			model_checkOut.addColumn("Item Name"); 
			model_checkOut.addColumn("Price"); 
			
			// Append a row 
			
	/*		model_checkOut.addRow(new Object[]{"French Fries","$10.00"});
			model_checkOut.addRow(new Object[]{"Pizza","$5.00"});
			model_checkOut.addRow(new Object[]{"Toast","$10.00"});
			model_checkOut.addRow(new Object[]{"Toast","$10.00"});
			model_checkOut.addRow(new Object[]{"Toast","$10.00"}); */
			
			table_3 = new JTable(model_checkOut);
			DefaultTableCellRenderer centerRenderer_checkOut = new DefaultTableCellRenderer();
			centerRenderer_checkOut.setHorizontalAlignment( JLabel.CENTER );
			//center align all the columns
			table_3.getColumnModel().getColumn(0).setCellRenderer( centerRenderer_checkOut );
			table_3.getColumnModel().getColumn(1).setCellRenderer( centerRenderer_checkOut );

			table_3.getTableHeader().setReorderingAllowed(false);
		
		 btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(MenuItem);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel_4)
					.addGap(16)
					.addComponent(lblCardNumber_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(388, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_6)
					.addContainerGap(425, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(243, Short.MAX_VALUE)
					.addComponent(lblOrderDetails, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(183))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_3, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(102)
							.addComponent(table_3, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBack_4)
									.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
									.addComponent(btnClickToBuy)
									.addGap(137))
								.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
									.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(29)))
							.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(16)))
					.addGap(65))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(33)
					.addComponent(lblOrderDetails, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCardNumber_1)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(39)
									.addComponent(btnClickToBuy))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblTotal))))
							.addContainerGap(37, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack_4)
							.addGap(14))))
		);
		panel_4.setLayout(gl_panel_4);
		
		 panel_5 = new JPanel();
		parentPanel.add(panel_5, "name_46772095334137");
		ButtonGroup bg = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Coke");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Diet Coke");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Fanta");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Pepsi");
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_5 = new JSeparator();
		
		JSeparator separator_6 = new JSeparator();
	//	ButtonGroup bg_chips = new ButtonGroup();
		
		JRadioButton rdbtnLays = new JRadioButton("Lays");
		
		JRadioButton rdbtnDoritos = new JRadioButton("Doritos");
		
		JRadioButton rdbtnCheetos = new JRadioButton("Cheetos");
		
		JRadioButton rdbtnTasmania = new JRadioButton("Tasmania");
		bg.add(rdbtnLays);
		bg.add(rdbtnDoritos);
		bg.add(rdbtnCheetos);
		bg.add(rdbtnTasmania);
		
		//ButtonGroup bg_choco = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Twix");
		
		JRadioButton rdbtnMars = new JRadioButton("Mars");
		
		JRadioButton rdbtnBounty = new JRadioButton("Bounty");
		
		JRadioButton rdbtnSnickers = new JRadioButton("Snickers");
		
		bg.add(rdbtnNewRadioButton_4);
		bg.add(rdbtnMars);
		bg.add(rdbtnBounty);
		bg.add(rdbtnSnickers);
		
		//ButtonGroup bg_fruits = new ButtonGroup();

		JRadioButton rdbtnAppleFizz = new JRadioButton("Apple");
		
		JRadioButton rdbtnXyz = new JRadioButton("xyz");
		
		JRadioButton rdbtnAbc = new JRadioButton("ABC");
		
		JRadioButton rdbtnCde = new JRadioButton("CDE");
		bg.add(rdbtnAppleFizz);
		bg.add(rdbtnXyz);
		bg.add(rdbtnAbc);
		bg.add(rdbtnCde);

		 label_7 = new JLabel("$1.00");
		
		 label_8 = new JLabel("$1.00");
		
		 label_9 = new JLabel("$1.00");
		
		 label_10 = new JLabel("$1.00");
		
		 spinner = new JSpinner();
		
		 spinner_1 = new JSpinner();
		
		 spinner_2 = new JSpinner();
		
		 spinner_3 = new JSpinner();
		
		 label_11 = new JLabel("$2.00");
		
		 label_12 = new JLabel("$2.50");
		
		 label_13 = new JLabel("$1.50");
		
		 label_14 = new JLabel("$1.70");
		
		 spinner_4 = new JSpinner();
		
		 spinner_5 = new JSpinner();
		
		 spinner_6 = new JSpinner();
		
		spinner_7 = new JSpinner();
		
		 label_15 = new JLabel("$1.20");
		
		 label_16 = new JLabel("$2.00");
		
		 label_17 = new JLabel("$1.30");
		
		 label_18 = new JLabel("$1.50");
		
		 spinner_8 = new JSpinner();
		
		 spinner_9 = new JSpinner();
		
		 spinner_10 = new JSpinner();
		
		 spinner_11 = new JSpinner();
		
		 label_19 = new JLabel("$1.00");
		
		 label_20 = new JLabel("$1.20");
		
		 label_21 = new JLabel("$1.50");
		
		 label_22 = new JLabel("$2.00");
		
		 spinner_12 = new JSpinner();
		
		 spinner_13 = new JSpinner();
		
		 spinner_14 = new JSpinner();
		
		 spinner_15 = new JSpinner();
		
		 btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_2);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		
		 btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeAll();
				parentPanel.add(panel_4);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7)
								.addComponent(label_10)
								.addComponent(label_9)
								.addComponent(label_8))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnLays)
										.addComponent(rdbtnCheetos)
										.addComponent(rdbtnDoritos))
									.addGap(14))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(rdbtnTasmania)
									.addGap(18)))
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(16)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(label_13)
										.addGroup(gl_panel_5.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_14)
											.addGap(18)
											.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
												.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_11)
										.addComponent(label_12))
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_5.createSequentialGroup()
											.addComponent(rdbtnNewRadioButton_4)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_15))
										.addGroup(gl_panel_5.createSequentialGroup()
											.addComponent(rdbtnMars)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_16))
										.addGroup(gl_panel_5.createSequentialGroup()
											.addComponent(rdbtnBounty)
											.addGap(18)
											.addComponent(label_17)))
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(spinner_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(rdbtnSnickers)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_18)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnAppleFizz)
										.addComponent(rdbtnXyz)
										.addComponent(rdbtnAbc)
										.addComponent(rdbtnCde))
									.addGap(31)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_20)
										.addComponent(label_19)
										.addComponent(label_21)
										.addComponent(label_22))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(spinner_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(108))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_6, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack_5)
					.addGap(171)
					.addComponent(btnCheckOut)
					.addContainerGap(263, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton_4)
								.addComponent(label_15)
								.addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnMars)
								.addComponent(label_16)
								.addComponent(spinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnBounty)
								.addComponent(label_17)
								.addComponent(spinner_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnSnickers)
								.addComponent(label_18)
								.addComponent(spinner_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnAppleFizz)
								.addComponent(label_19)
								.addComponent(spinner_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnXyz)
								.addComponent(label_20)
								.addComponent(spinner_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnAbc)
								.addComponent(label_21)
								.addComponent(spinner_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnCde)
								.addComponent(label_22)
								.addComponent(spinner_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(label_7)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnNewRadioButton_1)
										.addComponent(label_8))
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnNewRadioButton_2)
										.addComponent(label_9))
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnNewRadioButton_3)
										.addComponent(label_10)
										.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(30)
							.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_11)
								.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnLays))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_12)
								.addComponent(rdbtnDoritos)
								.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_13)
								.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnCheetos))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_14)
								.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnTasmania))))
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addComponent(btnBack_5)
							.addContainerGap())
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCheckOut)
							.addContainerGap())))
		);
		panel_5.setLayout(gl_panel_5);
		
		//Action listner to show the item in detail when an item is clicked in a list
		table_1_1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table_1_1.rowAtPoint(evt.getPoint());
		        int col = table_1_1.columnAtPoint(evt.getPoint());
		       if(evt.getClickCount()==2)
		        {
		        if (row >= 0) {
		        	  String selectedObject = (String) table_1_1.getValueAt(table_1_1.getSelectedRow(), 0);
				       System.out.println(selectedObject);
				     item_panel(table_1_1.getSelectedRow());
		            parentPanel.removeAll();
		            parentPanel.add(Item);
		            parentPanel.repaint();
		            parentPanel.revalidate();

		        }
		    }
		    }
		});
		
		 menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnGoTo = new JMenu("Go to");
		menuBar.add(mnGoTo);
		
		JMenuItem mntmCaloriesTracking = new JMenuItem("Set new Preferences");
		
		mntmCaloriesTracking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_1);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		mnGoTo.add(mntmCaloriesTracking);
		
		JMenuItem mntmExpenseTracking = new JMenuItem("Track your Day");
		mnGoTo.add(mntmExpenseTracking);
		mntmExpenseTracking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		//Action Listener for checkout page on the specific item page 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_4);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
		//MenuItem.add(new JScrollPane(table_1));

		
		menuBar.setVisible(false);
		
		//List action listener for each item in the list
		listModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent evt) {
		        if (evt.getValueIsAdjusting())
		        	return;

		        for(int i = model.getRowCount() -1 ; i >=0  ; i--) {
		        	model.removeRow(i);
				}
		        
		           int selectedItem = (int) listModel.getSelectedIndex();
		           System.out.println(selectedItem);
		           cafeid = (int)listModel.getSelectedIndex(); 
			       
			        menu = cafe.displayItems(cafeid+1);    // getting menu of cafe from database by calling CafeMenus display function
			        for(int i = 0 ; i < menu.item.size(); i++) {
						model.addRow(new Object[]{menu.item.get(i).getName(), menu.item.get(i).getCalories(), menu.item.get(i).getPrice(), false});
					} // populating tqble of menu
			   
			        System.out.println(menu);
			        
			        menu.item.clear();  // clearing previous array list
		           
		           
		    		        parentPanel.removeAll();
		        parentPanel.add(MenuItem);
		        parentPanel.repaint();
		        parentPanel.revalidate();
		        
		      }
		    });
		//Vending machine switch panel 
		btnVendingMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			parentPanel.removeAll();
			parentPanel.add(panel_5);
			parentPanel.repaint();
			parentPanel.revalidate();
			}
		});
	}
}
