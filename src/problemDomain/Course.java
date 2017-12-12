package problemDomain;

/**
 * @author Romain
 * @version 1.0
 *
 * Class description:
 *
 */
public class Course
{
	//Constants
	//Attributes
	private String courseName;
	private double courseMaxTime;
	//Constructors
	//Getter and Setter Methods
	public Course(String courseName, Double courseMaxTime)
	{
		setCourseName(courseName);
		setCourseMaxTime(courseMaxTime);
	}
	/**
	 * Method to return the calue of courseName
	 * @return the courseName
	 */
	public String getCourseName()
	{
		return courseName;
	}
	/**
	 * Method to set the value  courseName
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	/**
	 * Method to return the calue of courseMaxTime
	 * @return the courseMaxTime
	 */
	public double getCourseMaxTime()
	{
		return courseMaxTime;
	}
	/**
	 * Method to set the value  courseMaxTime
	 * @param courseMaxTime the courseMaxTime to set
	 */
	public void setCourseMaxTime(double courseMaxTime)
	{
		this.courseMaxTime = courseMaxTime;
	}
	//Operational Methods
}
	