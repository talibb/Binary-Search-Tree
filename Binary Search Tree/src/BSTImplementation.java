/*
 * Done By: Talib Bacchus
 * To Be used with "AddressBook.java"
 * This program demonstrates a Binary search tree
 * AddressBook objects are added to the tree and their names are converted
 * into numerical values
 * The tree is then ordered, searched, and traversed using the numerical
 * values of the names associated to the AddressBook object.
 */

public class BSTImplementation {
	static AddressBook root;
	
	public static long StringtoASCII (String name)// converts string to numerical value
	{
		StringBuilder sb = new StringBuilder();
		String ascString = null;
		long asciiInt;
		for (int i = 0; i < name.length(); i++){
			sb.append((int)name.charAt(i));

		}
		ascString = sb.toString();
		asciiInt = Long.parseLong(ascString);
		return asciiInt;
	}
	
	public void addAddress(String name, int phoneNumber)// adds info of the nodes
	{
		AddressBook newAddressBook = new AddressBook(name, phoneNumber);
		
		if(root == null)// if tree is empty
		{
			root = newAddressBook;// node becomes root
		}
		
		else// if node is not empty
		{
			AddressBook focusBook = root;
			AddressBook parent;
			
			
			while(true)
			{
				parent = focusBook; // node is made a parent
				
				if(StringtoASCII(name) < StringtoASCII(focusBook.getName())) // if less
				{
					focusBook = focusBook.leftChild; // node goes left
				
				
				if(focusBook == null)// if no left
				{
					parent.leftChild=newAddressBook; //node is made parent left node
					return;
				}
				}
				else// if greater
				{
					focusBook = focusBook.rightChild; //node goes right
					if(focusBook == null) //if no right node
					{
						parent.rightChild = newAddressBook; //node is made right parent node
						return;
					}
				}
			}
		}
		
	}
	public AddressBook inOrderTraverseTree(AddressBook focusBook)//traversing array in order
	{
		if(focusBook != null)
		{
			inOrderTraverseTree(focusBook.leftChild);
			System.out.println(focusBook);
			inOrderTraverseTree(focusBook.rightChild);
		}
		return focusBook;
	}
	
	
	public static String search (String name )// search given name
	{
		StringtoASCII(name);// name converted to numeric value
		
		if (root== null)// if no node
		{
			return "Name not found";
		}
		else
		{
			AddressBook focusBook = root;
			AddressBook parent;
		
			while(true)
			{
				parent = focusBook;
				if (StringtoASCII(name)==StringtoASCII(focusBook.getName())){
					return focusBook.toString();
				}
				
				if(StringtoASCII(name) < StringtoASCII(focusBook.getName()))
				{
					focusBook = focusBook.leftChild;
				
				
					if(focusBook == null)
					{
						 
						return "Name not found";
					}
				}
				else
				{
					focusBook = focusBook.rightChild;
					if(focusBook == null)
					{
						
						return "Name not found";
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BSTImplementation tree = new BSTImplementation();
		
		tree.addAddress("L C", 5555555);
		tree.addAddress("J T" , 1234567);
		tree.addAddress("J M", 7654321);
		tree.addAddress("N Y", 9834512);
		System.out.println("Below is everyone's information in the phone directory");
		System.out.println(tree.inOrderTraverseTree(root));
		
		System.out.println();
		System.out.println("Searching for L C's phone number");
		System.out.println(search("L C"));
		
	}
			
}
