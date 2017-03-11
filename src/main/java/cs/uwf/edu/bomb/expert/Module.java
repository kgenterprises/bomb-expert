package cs.uwf.edu.bomb.expert;

/**
 * 
 * @author daniel.jermyn
 * An abstract class that will act as the superclass for all modules
 */
abstract class Module 
{
	/**
	 * The name of the module
	 */
	private String name;
	
	/**
	 * Parameterized constructor
	 * @param theName the name of the module
	 */
	public Module(String theName)
	{
		setName(theName);
	}
	
	/**
	 * Default constructor
	 */
	public Module()
	{
		setName("No Name");
	}
	
	/**
	 * Gets the name of the module
	 * @return the name of the module
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name of the module
	 * @param newName
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * Method that must be inherited by all subclasses
	 */
	abstract public void solve();

}
