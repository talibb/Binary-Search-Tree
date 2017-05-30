/*
 * Done By: Talib Bacchus
 * To be used with "BSTImplementation.java"
 * An AddressBook object contains a name, phone number, key, left child, and right child
 * This class is used to demonstrate a Binary Search Tree
 */
public class AddressBook {

	private String name;
	int phoneNumber;
	int key;
	AddressBook leftChild;
	AddressBook rightChild;
	
	
	public AddressBook(String aName, int aNumber)
	{
		name = aName;
		phoneNumber = aNumber;
	
		
	}
	
	


	public String toString()
	{
		return name + " has the phone number " + phoneNumber;
	}
	/*public int getNumber()
	{
		return phoneNumber;
	}
	
	*/
	
	


	public String getName() {
		return name;
	}
}
