/** ------------------------------------------------------------
 * 				Tracy Huynh
 * 			   COSC 2436.S70
 *				   Lab 1
 *               Name.java
 *			  January 31, 2020
 * ------------------------------------------------------------
 */


public class Name implements Comparable
{
	private String first;  // first name
	private String last;   // last name
	
	private static final int LESS_THAN = -1;
	public static final int EQUAL = 0;
	public static final int GREATER_THAN = 1;

	public Name()
	{
		this ( "", "" );
	}

	public Name(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public void setName(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public Name (Name obj) throws NullPointerException     // Copy Constructor
	{
		this.first = new String ( obj.first );
		this.last = new String ( obj.last );
	}  

	public void   setFirst(String firstName) { first = firstName;  }
	public void   setLast (String lastName ) { last = lastName;    }
	public String getFirst()                 { return first;	   }
	public String getLast ()	             { return last;   	   }
	public String getName ()                 { return toString();  }
	public void   giveLastNameTo ( Name aName )
	{
		aName.setLast ( last );
	}

	public boolean equals ( Object obj )				  // Equals method
	{
		if ( this == obj ) return true;
		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
			Name x = ( Name ) obj;

			if ( ( first.equals ( x.first ) ) &&
			     ( last.equals ( x.last ) ))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}			 		   

	public String toString( )
	{
		return first + " " + last;
	}

	public void finalize ( ) 							   // finalize method
	{
		System.out.println("Name - finalize method");
	}						   

	public void dispose ( ) 							   // dispose method
	{ 
		System.out.println("Name - dispose method");
	}						  

	public int hashCode ( )  							   // hashCode method
	{
		int number = 32;
		number = 35 * number + first.hashCode(); 
		number = 35 * number + last.hashCode();
		return number;
		
	}						   
	public int compareTo ( Object obj) 					   // compareTo Method
	{
		int firstName = 0, lastName = 0;
		
		if (this == obj) return 0;  
		Name x = ( Name ) obj;
		firstName = (this.first.compareTo(x.first));
		lastName = (this.last.compareTo(x.last));
		
		if (firstName > 0) firstName = 1;
		if (firstName < 0) firstName = -1;
		if (lastName > 0) lastName = 1;
		if (lastName < 0) lastName = -1;
		
		if (lastName == firstName) return 0;
		
		if (lastName == LESS_THAN) return LESS_THAN; 
		else if (lastName == GREATER_THAN) return GREATER_THAN; 
		else if (lastName == EQUAL) 
		{
			if (firstName == LESS_THAN) return LESS_THAN;
			else if (firstName == GREATER_THAN) return GREATER_THAN;
		}
		return 0;
	}						   
} // end Name
