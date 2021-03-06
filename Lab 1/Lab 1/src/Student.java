/** ------------------------------------------------------------
 * 				Tracy Huynh
 * 			   COSC 2436.S70
 *				   Lab 1
 *              Student.java
 *			  January 31, 2020
 * ------------------------------------------------------------
 */
public class Student implements Comparable
{
	private Name fullName;
	private String id;

	private static final int LESS_THAN = -1;
	public static final int EQUAL = 0;
	public static final int GREATER_THAN = 1;

	public Student()
	{
		this ( new Name ( ), "" );
	}

	public Student(Name studentName, String studentId)
	{
		fullName = studentName;
		id = studentId;
	}

	public Student(Student obj) throws NullPointerException	
	{
		this.fullName = new Name ( obj.fullName);
		this.id  = new String ( obj.id.toString() );
	}

	public Object clone() 
	{
		return new Student (this);
	}

	public void setStudent(Name studentName, String studentId)
	{
		fullName = studentName;
		id       = studentId;
	}

	public void   setName(Name studentName) {	fullName = studentName;	}
	public Name   getName()                 {   return fullName;        }
	public void   setId(String studentId)   {	id = studentId;         }
	public String getId()                   {	return id;              }


	public String toString()
	{
		return id + " " + fullName.toString ( );
	}

	public boolean equals ( Object obj ) 
	{
		if ( this == obj ) return true;

		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
			Student s = ( Student ) obj;

			if ( ( fullName.equals ( s.fullName )) &&
			     ( id.toString().equals ( s.id.toString() )))
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

	public void finalize() 
	{ 
		System.out.println( "Student - finalize method");
	}

	public void dispose() 
	{
		System.out.println( "Student - dispose method");
	}

	public int hashCode() 
	{
		int number = 29;
		number = 33 * number + fullName.hashCode();
		number = 33 * number + id.toString().hashCode();
		return number;
	}

	public int compareTo (Object obj ) 
	{
		int fullNames = 0, ids = 0;
		
		if (this == obj) return 0;  
		Student x = ( Student ) obj;
		fullNames = (this.fullName.compareTo(x.fullName));
		ids = (this.id.compareTo(x.id));
		
		if (fullNames > 0) fullNames = 1;
		if (fullNames < 0) fullNames = -1;
		if (ids > 0) ids = 1;
		if (ids < 0) ids = -1;
		
		if (fullNames == ids) return 0;
		
		if (fullNames == LESS_THAN) return LESS_THAN; 
		else if (fullNames == GREATER_THAN) return GREATER_THAN; 
		else if ( fullNames == EQUAL) 
		{
			if (ids == LESS_THAN) return LESS_THAN;
			else if (ids == GREATER_THAN) return GREATER_THAN;
		}
		return 0;
	}

}  // end Student
