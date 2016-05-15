/**
 * Represents an item in a shopping cart.
 */
public class House
{
    private String type;
    private int size;
    private int yearBuilt;
    private int zipCode;
    private String nameOfOwner;

	public House(String houseType)
	{
		type = houseType;
	}
  
  	/**
  	 * Creates an item with a specified name, price and quantity.
  	 * @param itemName the name of the item
  	 * @param itemPrice the price of the item
  	 * @param numPurchased the quantity of the item
  	 */
    public House(String houseType, int houseSize, int houseYearBuilt, int houseZIPCode, String houseNameOfOwner)
    {
		type = houseType;
		size = houseSize;
		yearBuilt = houseYearBuilt;
		zipCode = houseZIPCode;
		nameOfOwner = houseNameOfOwner;
    }

    /**
     * returns a formatted String of the house
     * @return the string version of the house
     */
    public String toString ()
    {
    	return String.format("%-20s%-18s%-16s%-15s%-18s\n", type, size, yearBuilt, zipCode, nameOfOwner);
    }

    /**
     * returns the house type
     * @return the house type
     */
    public String getType()
    {
		return type;
    }

  	/**
     * returns the item name
     * @return the item name
     */
    public int getSize()
    {
		return size;
    }

  	/**
     * returns the item quantity
     * @return the item quantity
     */
    public int getYearBuilt()
    {
		return yearBuilt;
    }
    
    public int getZIPCode()
    {
		return zipCode;
    }
    
    public String getNameOfOwner()
    {
		return nameOfOwner;
    }
    
    /**
     * items are considered equal if they have the same type
     * @param item the item to compare
     * @return boolean whether the items are equal
     */
    public boolean equals(Object a)
    {
    	House o = (House)a;
    	if(type.equalsIgnoreCase(o.getType()))
    		return true;
    	else
    		return false;
    }
}  