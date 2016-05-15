import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;

public class HouseRunner
{
	public static void main(String[] args) throws IOException
    {
    	HouseMenuRunner myMenu = new HouseMenuRunner();   		
    }
}

/**
 * The ShopMenu class provides the GUI environment for testing methods of the
 * ShoppingCart and Item classes.  It uses MouseListener and ActionListener interfaces.
 */
class HouseMenuRunner extends JFrame implements ActionListener, MouseListener
{
		// window dimensions
		private static final int FRAME_WIDTH       = 1250; // adjust to have a wider/slimmer window
 		private static final int FRAME_HEIGHT      = 300; // adjust to have a taller/shorter window
 		private static final int FRAME_X_ORIGIN    = 50;
 		private static final int FRAME_Y_ORIGIN    = 50;
		
		// database
		private HouseMenu myCart;
		
		// declare GUI elements
		private JLabel title, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen;
		private JPanel left;
		private JTextArea display;
		private JMenuBar menuBar;
		private JMenu menu;
		private JMenuItem save, load, quit;
		private JScrollPane scroller;
		
		/**
		 * The constructor instantiates all of the gui elements, adds them to the content pane, 
		 * and adds the listeners to the GUI elements
		 */
		public HouseMenuRunner()
		{
			myCart = new HouseMenu();
			
			// set up the window
			setTitle("Shopping Cart");
 			setSize(FRAME_WIDTH, FRAME_HEIGHT);
 			setResizable(false);
 			setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
 			
 			// set up the main display area and make it scrollable
 			display = new JTextArea();
 			display.setFont(new Font("Courier",Font.BOLD,12));
 			display.setEditable(false);
 			display.setBorder(BorderFactory.createLineBorder(Color.blue));	
 			scroller = new JScrollPane(display);
 		
 			// set up the menu items
			title = new JLabel("          MENU:");
 			title.setForeground(Color.blue);
			two = new JLabel(" Add a house entry");
			three = new JLabel(" Search for name of owner");
			four = new JLabel(" Show all entries");
			five = new JLabel(" Delete a house entry");
			six = new JLabel("Sort entries by size");
			seven = new JLabel("Partially show entries above a specific ZIP Code");
			eight = new JLabel("Calculate number of entries with a specific type");
			nine = new JLabel("Change a certain house entry size by a certain value");
			ten = new JLabel("Add/Remove an owner to/from a house entry");
			eleven = new JLabel("Sort by Year when Created");
			twelve = new JLabel("Show only houses with a specified ZIP Code");
			thirteen = new JLabel("Help");
			
			// set up the menu bar
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);	
			save = new JMenuItem("Save");
			load = new JMenuItem("Load");
			quit = new JMenuItem("Quit");	
			save.addActionListener(this);
			load.addActionListener(this);
			quit.addActionListener(this);	
			menu = new JMenu("File");
			menu.add(save);
			menu.add(load);
			menu.add(quit);	
			menuBar.add(menu);
			
			// Make the panel for the menu and add the menu items to it
			left = new JPanel();	
			left.add(title);
			left.add(two);
			left.add(three);
			left.add(four);
			left.add(five);
			left.add(six);
			left.add(seven);
			left.add(eight);
			left.add(nine);
			left.add(ten);
			left.add(eleven);
			left.add(twelve);
			left.add(thirteen);
			
			left.setLayout(new GridLayout(14,3)); // the menu has 6 rows and 1 column
//			setLayout(new GridLayout(20,15)); // the window has 1 row and two columns
//			add(left);
//			add(scroller);

			setLayout(new BorderLayout());
			add(left, BorderLayout.WEST); // add the menu to the left
			add(scroller, BorderLayout.CENTER); // add the text area to center, which takes up any unused space
			
			// make all of the menu items listen
			two.addMouseListener(this);
			three.addMouseListener(this);
			four.addMouseListener(this);
			five.addMouseListener(this);
			six.addMouseListener(this);
			seven.addMouseListener(this);
			eight.addMouseListener(this);
			nine.addMouseListener(this);
			ten.addMouseListener(this);
			eleven.addMouseListener(this);
			twelve.addMouseListener(this);
			thirteen.addMouseListener(this);
	
			// when the user clicks the X in the top right corner, the program will exit
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true); // make it visible LAST
		}
		
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is clicked.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseClicked(MouseEvent e)
		{
			// nothing needed, but method required by interface
		}
		
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is released.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseReleased(MouseEvent e)
		{
			// nothing needed, but method required by interface
		}
		
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer enters a particular gui element.  In this implementation, if the mouse
		 * pointer enters one of the menu labels, the label is set to red.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseEntered(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.red);
		}
		
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer leaves a particular gui element.  In this implementation, if the mouse
		 * pointer leaves one of the menu labels, the label is set to back to black.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseExited(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.black);
		}
		
		/**
		 * required by the MouseListener interface.  Invoked when the left mouse button is pressed.
		 * In this implementation, if the mouse is pressed on a particular labels, that menu item
		 * is invoked.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mousePressed(MouseEvent e) 
		{
	    	String houseType = "";
	    	int houseSize = 0;
	    	int houseYearBuilt = 0;
	    	int houseZipCode = 0;
	    	String houseNameOfOwner = "";
			JLabel label = (JLabel) e.getSource();	
						
			if (label.equals(two)) // Add an house entry to the list
			{
				display.setText("");
				houseType = JOptionPane.showInputDialog("Enter the house type");
				houseSize = Integer.parseInt(JOptionPane.showInputDialog("Enter the house size in square footage"));
				houseYearBuilt = Integer.parseInt(JOptionPane.showInputDialog("Enter the year built"));
				houseZipCode = Integer.parseInt(JOptionPane.showInputDialog("Enter the house ZIP Code"));
				houseNameOfOwner = JOptionPane.showInputDialog("Enter the house owner");
				myCart.addHouse(new House(houseType, houseSize, houseYearBuilt, houseZipCode, houseNameOfOwner));
				showCart();			
			}
			
			else if (label.equals(three)) // Find an house in the list with specific owner
			{
				String houseOwner = JOptionPane.showInputDialog("House type you are looking for");
				showItem(myCart.searchOwner(houseOwner));
			}
			
			else if (label.equals(four)) // Display the list
			{
				showCart();
			}
			
			else if (label.equals(five)) // Remove an house entry
			{
				String a = JOptionPane.showInputDialog("House to remove");
				House o = new House(a, houseSize, houseYearBuilt, houseZipCode, houseNameOfOwner);
				if (myCart.removeHouse(o))
				{
					myCart.removeHouse(o);
					JOptionPane.showMessageDialog(null, "The house with the type of " + a + " has been removed from the house list.");
				}
				else
					JOptionPane.showMessageDialog(null, "You have no house type of " + a + " in your house list to remove.");
				showCart();
			}
			
			else if (label.equals(six)) //Sort Entries by Size
			{
				myCart.sortSizeUp();
				showCart();
				JOptionPane.showMessageDialog(null, "The list has been sorted by size.");
			}
			
			else if (label.equals(seven)) //Show entries above a specified ZIP Code
			{
				
			}
			
			else if (label.equals(eight)) //Calculate number of entries with a specific type
			{
				String a = JOptionPane.showInputDialog("What type of house would you like to search for?");
				JOptionPane.showMessageDialog(null, myCart.calculate(a) + " instance/instances of " + a + " have been found in the list");
			}
			
			else if (label.equals(nine)) //Change a certain house entry size by a certain value
			{
				
			}
			
			else if (label.equals(ten)) //Change an owner of a house entry
			{
				String a = JOptionPane.showInputDialog("House owner to remove");
				String b = JOptionPane.showInputDialog("House owner to add");
				myCart.changeOwner(a, b);
				showCart();
			}
			
			else if (label.equals(eleven)) //Sort by Year when Created
			{
				myCart.sortYearUp();
				showCart();
				JOptionPane.showMessageDialog(null, "The list has been sorted by year built.");
			}
			
			else if (label.equals(twelve)) //Show only houses with a specified ZIP Code
			{
				String input = JOptionPane.showInputDialog("What ZIP Code do you want to look for?");
				JOptionPane.showMessageDialog(null, (myCart.showSameZIPCode(Integer.parseInt(input))));
			}
			
			else if (label.equals(thirteen)) //Help
			{
				String helpStuff = myCart.help();
				JOptionPane.showMessageDialog(null, helpStuff);
			}	    
		}
		
		/**
		 * actionPerformed is required by the ActionListener interface.  
		 * It is invoked whenever one of the menu items is selected.
		 * The possible menu items that can be activated are quit, save and load.
		 * @param e the ActionEvent that triggered the method
		 */
		public void actionPerformed(ActionEvent e)
		{
			String menuName = e.getActionCommand();
			
			if (menuName.equals("Quit"))
				System.exit(0);
			else if (menuName.equals("Save"))
				myCart.saveToFile();
			else if (menuName.equals("Load"))
			{
				display.setText("");// clear the display window
				try
				{
					myCart.loadFromFile();
				}
				catch(IOException a){}
				showCart();
			}	
		}
		
		/**
		 * displays the cart contents in the display pane
		 */
		private void showCart()
		{
			display.setText("Cart Contents:\n" + String.format("%-20s%-18s%-16s%-15s%-18s\n","Type", "Size(sq. ft.)", "Year Built", "ZIP Code", "Owner name") + myCart.toString());
		}
		
		private void showItem(House i)
		{
			display.setText("Found Item:\n" + String.format("%-20s%-12s%-13s%-15s%-25s\n","Type", "Size", "Year Built", "ZIP Code", "Owner name") + i.toString());
		}
}
