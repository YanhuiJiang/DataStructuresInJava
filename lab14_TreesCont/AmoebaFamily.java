import java.util.ArrayList;
import java.util.Iterator;

public class AmoebaFamily implements Iterable<AmoebaFamily.Amoeba>{

	private Amoeba myRoot = null;

	// A constructor that starts an Amoeba family with an amoeba
	// with the given name.
	public AmoebaFamily(String name) {
		myRoot = new Amoeba(name, null);
	}

	// Add a new amoeba named childName as the youngest child
	// of the amoeba named parentName.
	// Precondition: the amoeba family contains an amoeba named parentName.
	public void addChild(String parentName, String childName) {
		if (myRoot != null) {
            myRoot.addChild(parentName, childName);
		}
	}

	// Makes all Amoeba names only lower case letters.
	public void makeNamesLowercase() {
		// Your goal is to make this as similar as possible to addChild
		if(myRoot != null)
		{
			myRoot.makeNamesLowercase(); 
		}		
	}

	// Replaces the name of an amoeba named currentName with the name newName.
	// Precondition: the amoeba family contains an amoeba named currentName.
	public void replaceName(String currentName, String newName) {
		// Your goal is to make this as similar as possible to addChild
		if(myRoot != null)
		{
			myRoot.replaceName(currentName, newName);
		}
			 
	}

	// Print the names of all amoebas in the family.
	// later you will write print() that has more interesting formatting
	public void printFlat() {
		if(myRoot != null)
			myRoot.printFlat(); 
		// Your goal is to make this as similar as possible to addChild
	}

	// Print the names of all amoebas in the family.
	// Names should appear in preorder, with children's names
	// printed oldest first.
	// Members of the family constructed with the main program above
	// should be printed in the following sequence:
	// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
	// Bill, Hilary, Fred, Wilma, auntie
    // This is the pretty print exercise.
	public void prettyprint()
	{
		if(myRoot != null)
		{
			myRoot.prettyprint();
		}
	}
	

	// returns the length of the longest name in the Amoeba Family
	public int longestNameLength() {
		if (myRoot != null) {
			return myRoot.longestNameLength();
		}
		return 0;
	}
    
	// instead of returning the length of the longest name, this method should
	// return the name that is longest.
	public String longestName(){
		// your goal is to make this look as similar as possible to
		// longestNameLength
		if(myRoot != null)
		{
			return myRoot.longestName(); 
		}
		return "";
	}
	
    public int size()
    {
    	if(myRoot != null)
    	{
    		return myRoot.size(); 
    	}
    	return 0; 
    }
    
    public int height()
    {
    	if (myRoot != null)
    	{
    		return myRoot.height();
    	}
    	return 0; 
    }
    

	// Return an iterator of the amoeba family.
	public Iterator<Amoeba> iterator() {
		return new AmoebaIterator();
	}
//
//	public static void main(String[] args) {
//		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
//		family.addChild("Amos McCoy", "mom/dad");
//		family.addChild("Amos McCoy", "auntie");
//		family.addChild("mom/dad", "me");
//		family.addChild("mom/dad", "Fred");
//		family.addChild("mom/dad", "Wilma");
//		family.addChild("me", "Mike");
//		family.addChild("me", "Homer");
//		family.addChild("me", "Marge");
//		family.addChild("Mike", "Bart");
//		family.addChild("Mike", "Lisa");
//		family.addChild("Marge", "Bill");
//		family.addChild("Marge", "Hilary");
//		System.out.println("Here's the family:");
//		family.print();
//	}

	public class AmoebaIterator implements Iterator<Amoeba> {
		// Amoebas in the family are enumerated in preorder,
		// with children enumerated oldest first.
		// Members of the family constructed with the main program above
		// should be enumerated in the following sequence:
		// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
		// Bill, Hilary, Fred, Wilma
		// Complete enumeration of a family of N amoebas should take
		// O(N) operations.

		// You will supply the details of this class in a future lab.

		public AmoebaIterator() {
		}

		public boolean hasNext() {
			return false;
		}

		public Amoeba next() {
			return null;
		}

		public void remove() {
			// Not used for now -- removal from a tree can be difficult.
			// Once you've learned about different ways to remove from
			// trees, it might be a good exercise to come back and 
			// try to implement this.
		}

	} // end of AmoebaIterator nested class

	public static class Amoeba {

		public String myName; // amoeba's name
		public Amoeba myParent; // amoeba's parent
		public ArrayList<Amoeba> myChildren; // amoeba's children

		public Amoeba(String name, Amoeba parent) {
			myName = name;
			myParent = parent;
			myChildren = new ArrayList<Amoeba>();
		}

		public String toString() {
			return myName;
		}

		public Amoeba parent() {
			return myParent;
        }

        //Add a child if parent name matches an amoeba's name,
        //or if parentName matches any of the descendents
        public void addChild(String parentName, String childName) {
            if (myName.equals(parentName)) {
                Amoeba child = new Amoeba(childName, this);
                myChildren.add(child);
            } else {
                for (Amoeba a : myChildren) {
                    a.addChild(parentName, childName);
                }
            }
        }
        
      //Add more void recursive functions below
        
    	public void makeNamesLowercase() {
    		// Your goal is to make this as similar as possible to addChild
    		this.myName = myName.toLowerCase();
    		
    		for (Amoeba child: myChildren)
    		{
    			child.makeNamesLowercase(); 
    		}
    	}
    			
    	public void replaceName(String currentName, String newName) {
    		// Your goal is to make this as similar as possible to addChild
    		if (myName.equals(currentName))
    		{
    			
    			myName= newName;
    		}
    		else
    		{
    			for(Amoeba child: myChildren)
        		{
            		child.replaceName(currentName, newName);
            	}	
        		  			
    		} 			 
    	}

    	
    	public void printFlat() {
    		System.out.println(this.myName);
    		for (Amoeba child: myChildren)
    		{
    			child.printFlat(); 
    		}
    	}

    	public void prettyprint()
    	{
    		 this.prettyprintHelper(0);
    	}

    	public void prettyprintHelper(int counter)
    	{	 
    		int i = 0;
    		while (i < counter)
    		{
    			System.out.print(" ");
    			i++; 
    		}
    		System.out.println(this.myName);
    		for (Amoeba child: myChildren)
    		{
    			child.prettyprintHelper(counter + 4);
    		}
    		
    	}
    	
    
        //Returns the length of the longest name of this Amoeba's children
        public int longestNameLength() {
            int maxLengthSeen = myName.length();
            for (Amoeba a : myChildren) {
                maxLengthSeen = Math.max(maxLengthSeen, a.longestNameLength());
            }
//            System.out.println(maxLengthSeen + "MAXLENGTHHHH");
            return maxLengthSeen;
        }
        
        
        public String longestName()
        {      	 
        	String root = this.myName; 
        	String longestChild = ""; 
        	String longName = "";
        	for(Amoeba child: myChildren)
        	{ 
        		if (longName.length() != child.longestNameLength())
        		{
        			longestChild = child.longestName();
        		}
        		else
        		{
        			break;
        		}
        	}
        	if (longestChild.length() < root.length())
        	{
        		longName = root; 
        	}
        	return longName;
        	
        }
        public int size()
        {
        	return sizeHelper(1);
        }
        
        public int sizeHelper(int count) 
        { 
        	int i = count; 
        	for (Amoeba child: myChildren)
        	{
        		i = i + child.sizeHelper(count); 
        	}
        	return i; 
        }
        
        private int height() 
        {
        	if (myChildren.isEmpty()) 
        	{
        		return 1;
        	} 
        	else 
        	{
        		int bestSoFar = 1;
        	for (Amoeba a : myChildren) 
        	{
        		bestSoFar = 1 + Math.max(a.height(), bestSoFar);
        	}
        	return bestSoFar;
        	}
        }
  
	} 
}