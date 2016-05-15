/****************************************************************
* HouseMenu.java
*
* A class that models a set of house objects.  A house cart has 
* an ArrayList of houses.
*          
****************************************************************/

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.*;

public class HouseMenu
{
	// instance field
	private ArrayList <House> houses;

	/**
	 * Constructs an empty house list
	 */
	public HouseMenu()
	{
		houses = new ArrayList <House>();
	}
	
	/**
	 * addHouse adds a specified house to the list
	 * @param house begin added
	 */
	public void addHouse(House a)
	{
		houses.add(a);
	}
	
	/**
	 * toString provides a String version of the house list with
	 * each house on a separate line
	 * @return the String version of the list
	 */
	public String toString()
	{
		String out = "";
		for(House i: houses)
			out += i.toString() + "\n";
		return out;
	}
	
	public House searchOwner(String temp)
	{
		for(int i = 0; i < houses.size(); i++)
		{
			String a = houses.get(i).getType();
			int b = houses.get(i).getSize();
			int c = houses.get(i).getYearBuilt();
			int d = houses.get(i).getZIPCode();
			String e = houses.get(i).getNameOfOwner();
			House f = new House(a, b, c, d, e);
			if(houses.get(i).getNameOfOwner().equals(temp))
				return f;
		}
		return null;
	}
	
	/** 
	 * removeHouse removes a specified house from the list if it exists, and returns true.
	 * If the house does not exist in the list, returns false.
	 * @param purchase the item to search for and remove
	 * @return whether the item was removed
	 */
	public boolean removeHouse(Object a)
	{
		House o = (House)a;
		int index = houses.indexOf(o);
		if (index == -1)
			return false;
		else
		{
			houses.remove(index);
			return true;
		}
	}
	
	public void sortSizeUp()
	{
		boolean sorted = false;
		int p = 1;
		while(!sorted) 
		{
			sorted = true;
			for(int index = 0; index < houses.size() - p; index++)
			{
				if(houses.get(index).getSize() > houses.get(index + 1).getSize())
				{
					sorted = false;
					House temp = houses.get(index);
					houses.set(index, houses.get(index + 1));
					houses.set(index + 1, temp);
				}
			}
			p++;
		}				
	}
	
	public ArrayList showAboveZIPCode(int code)
	{
		ArrayList<House> temp = new ArrayList<House>();
		for(int i = 0; i < houses.size(); i++)
			if(houses.get(i).getZIPCode() > code)
				temp.add(houses.get(i));
		return temp;
	}
	
	/**
	 * calculate returns the number of houses with a specified type.
	 * @param a the house type to count
	 * @return the quantity of houses or 0.
	 */
	public int calculate(String a)
	{
		int count = 0;
		for(int i = 0; i < houses.size(); i++)
			if(houses.get(i).getType().equals(a))
				count++;
		return count;
	}
	
	public void changeSizes(String typeOfHouse, int yearSpecification)
	{
//		int change = 1000;
//		for(int i = 0; i < houses.size(); i++)
//			if(houses.get(i).getNameOfOwner.equals(typeOfHouse))
//			{
//				String temp = (String)houses.get(i).
//			}	
	}
	
	public void changeOwner(String oldOwner, String newOwner)
	{
//		for(int i = 0; i < houses.size(); i++)
//			if(houses.get(i).getNameOfOwner().equals(oldOwner))
//				houses.get(i).getNameOfOwner() = "";
	}
	
	public void sortYearUp()
	{
		boolean sorted = false;
		int p = 1;
		while(!sorted) 
		{
			sorted = true;
			for(int index = 0; index < houses.size() - p; index++)
			{
				if(houses.get(index).getYearBuilt() > houses.get(index + 1).getYearBuilt())
				{
					sorted = false;
					House temp = houses.get(index);
					houses.set(index, houses.get(index + 1));
					houses.set(index + 1, temp);
				}
			}
			p++;
		}	
	}
	
	public ArrayList showSameZIPCode(int code)
	{
		ArrayList<House> temp = new ArrayList<House>();
		for(int i = 0; i < houses.size(); i++)
		{
			if(houses.get(i).getZIPCode() == code)
			{
				temp.add(houses.get(i));
			}
		}
		return temp;
	}
	
	public String help()
	{
		return "	This program allows the user to maintain a database pertaining to the inventory of houses bought. It keeps track of the type of each different house at all locations.\n	This allows for efficient ordering of neighborhoods, and transfer of parts from one house to another in case of need in a house. Records in the system track the number of houses of a certain type in each neighborhood. \n	Each record contains the following data: house type, house size, year the house was built, ZIP Code, name of the owner for the house in that neighborhood.\n		For instance: Type: Modern Size: 25,008 sq. ft. Year Built: 1994 ZIP Code: 75096 Name of owner: BobbyJoe\n	Each week the person responsible counts houses and updates the status of each. This new inventory is entered into the database.";
	}
	
	public void empty()
	{
		houses.removeAll(houses);
	}
	/**
	 * Saves the current contents of the shopping cart to a user specified file.
	 */
	public void saveToFile()
	{
    	String fileName = JOptionPane.showInputDialog("Enter the file name");
    	try
    	{
    		PrintWriter out = new PrintWriter(fileName);
	    	for(House i: houses)
	    	{
	    		out.println(i.getType());
	    		out.println(i.getSize());
	    		out.println(i.getYearBuilt());
	    		out.println(i.getZIPCode());
	    		out.println(i.getNameOfOwner());
	    	}
	    	out.close();
	    	JOptionPane.showMessageDialog(null, fileName + " has been saved.");
    	}
    	catch(IOException exception)
    	{
    		System.out.println("File problem - could not save");
    	}
	}
	
	/**
	 * Loads a new shopping cart from a user specified file.  Uses JFileChooser to allow
	 * the user to browse to the file.
	 */
	public void loadFromFile() throws IOException
	{
		empty();
    	JFileChooser chooser = new JFileChooser();
    	chooser.requestFocus();
    	File infile = null;
    	if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	   	  {
	   	  	infile = chooser.getSelectedFile();
	   	  }
	   	Scanner in = new Scanner(infile);
	   	while(in.hasNext())
	   	{
	   		String type = in.nextLine();
	   		int size = in.nextInt();
	   		int yearBuilt = in.nextInt();
	   		int zipCode = in.nextInt();
	   		String name = in.next();
	   		in.nextLine();
	   		addHouse(new House(type, size, yearBuilt, zipCode, name));
	   	}
	   	in.close();
	}
}
