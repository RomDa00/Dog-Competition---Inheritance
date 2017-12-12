package problemDomain;

/**
 * @author Romain
 * @version 1.0
 *
 * Class description:
 *
 */
public class Dog
{
	//Constants
	//Attributes
	private String id;
	private String name;
	private double runTime;
	private double penalty;
	private char courseCode;
	//Constructors
	//Getter and Setter Methods
	public Dog(String id, String name, double runTime, double penalty, char courseCode)
	{
		setId(id);
		setName(name);
		setRunTime(runTime);
		setPenalty(penalty);
		setCourseCode(courseCode);
	}
	//Operational Methods
	/**
	 * Method to return the value of id
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * Method to set the value  id
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * Method to return the value of name
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Method to set the value  name
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Method to return the value of runTime
	 * @return the runTime
	 */
	public double getRunTime()
	{
		return runTime;
	}
	/**
	 * Method to set the value  runTime
	 * @param runTime the runTime to set
	 */
	public void setRunTime(double runTime)
	{
		this.runTime = runTime;
	}
	/**
	 * Method to return the value of penalty
	 * @return the penalty
	 */
	public double getPenalty()
	{
		return penalty;
	}
	/**
	 * Method to set the value  penalty
	 * @param penalty the penalty to set
	 */
	public void setPenalty(double penalty)
	{
		this.penalty = penalty;
	}
	/**
	 * Method to return the value of courseCode
	 * @return the courseCode
	 */
	public char getCourseCode()
	{
		return courseCode;
	}
	/**
	 * Method to set the value  courseCode
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(char courseCode)
	{
		this.courseCode = courseCode;
	}
}
