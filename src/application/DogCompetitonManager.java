package application;

import java.io.*;
import java.util.*;

import javax.swing.*;
import problemDomain.Course;
import problemDomain.Dog;

/**
 * @author Romain
 * @version 1.0
 *
 * Class description: This class hold all the information for the program dog competition. Users will be able to print reports for each courses and see which dog has won the competition
 * and they will be able to add a new dog to the current list of the dogs.
 *
 */
public class DogCompetitonManager
{
	
	//Constants
	private final String DOG_COMPETITON_FILE = "res/dogs.txt";
	private final String COURSES_FILE = "res/courses.txt";
	
	//Constructors
	public DogCompetitonManager()
	{
		dogList = new ArrayList<Dog>(50);
		courseList = new ArrayList<Course>(30);
		loadDogList();
		loadCourseList();
	}

	/**
	 * @param args
	 */
	
	/**
	 * 
	 * @return main menu 
	 */
	private int mainMenuChoice()
	{
		String line = JOptionPane.showInputDialog(null,"1. Print Report.\n2. Add dog to list\n3. Exit and save new dog information","Main Menu", JOptionPane.INFORMATION_MESSAGE);
		int choice = Integer.parseInt(line);
		return choice;
	}
	
	/**
	 * Switch for main menu
	 */
	public void runAdministration()
	{
		int choice = 0;
		
		while(choice != 4)
		{
			choice = mainMenuChoice();
			
			switch(choice)
			{
				case 1:
					printLoadReport();
					break;
				case 2:
					addDog();
					break;
				case 3:
					saveNewDogFile();
					System.exit(0);
					break;
				default:
					System.out.println("Not a valid choice");
			}	
		}
		JOptionPane.showMessageDialog(null,"Program Shutting Down!\nSaving Files.");
	}

	//Attributes
	private ArrayList<Dog>		dogList;
	private ArrayList<Course>		courseList;
	
	/**
	 * load information from courses.txt
	 */
	private void loadCourseList()
	{
		BufferedReader fin = null;
		try
		{
			fin = new BufferedReader(new FileReader(COURSES_FILE));
			String line = fin.readLine();
			
			while(line != null)
			{
				Course course = parseCourseString(line);
				courseList.add(course);
				line = fin.readLine();
			}
			fin.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * load information from dogs.txt
	 */
	private void loadDogList()
	{
		BufferedReader fin = null;
		try
		{
			fin = new BufferedReader(new FileReader(DOG_COMPETITON_FILE));
			String line = fin.readLine();
			
			while(line != null)
			{
				Dog dog = parseDogString(line);
				dogList.add(dog);
				line = fin.readLine();
			}
			fin.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param line parse information from dogs.txt
	 * @return dog
	 */
	private Dog parseDogString(String line)
	{
		String tokens[] = line.split(" ");
		Dog dog = new Dog(tokens[0],tokens[1],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),tokens[4].charAt(0));
		return dog;
	}
	
	/**
	 * 
	 * @param line parse information from courses.txt
	 * @return course
	 */
	private Course parseCourseString(String line)
	{
		String tokens[] = line.split(" ");
		Course course = new Course(tokens[0],Double.parseDouble(tokens[1]));	
		return course;
	}
	
	/**
	 * add new dog information.
	 */
	private void addDog()
	{
		//Get ID of new dog.
		String newID = JOptionPane.showInputDialog(null,"Enter Dog ID: \n Must be Digit - Letter - Digit - Digit - Digit\n Example: 1B456", "New Dog ID", JOptionPane.INFORMATION_MESSAGE);
		while(!(Character.isDigit(newID.charAt(0)) && Character.isLetter(newID.charAt(1)) && Character.isDigit(newID.charAt(2)) && Character.isDigit(newID.charAt(3)) && Character.isDigit(newID.charAt(4)) ))
		{
			newID = JOptionPane.showInputDialog(null, "Invalid ID combination try again\n Example: 1B456", "Invalid ID combination", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//Get Name of new dog.
		String newName = JOptionPane.showInputDialog(null,"Enter the name of the dog:", "New Dog Name", JOptionPane.INFORMATION_MESSAGE);
		
		//Get Runtime of new dog.
		Double runTime = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter run time of dog\n Must be greater than 0", "New Dog Runtime", JOptionPane.INFORMATION_MESSAGE));
		while(runTime <= 0)
		{
			runTime = Double.parseDouble(JOptionPane.showInputDialog(null,"Invalid run time\nrun time must be larger than 0", "Invalid Runtime", JOptionPane.INFORMATION_MESSAGE));
		}
		
		//Get penalty time for new dog.
		Double penaltyTime = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter penalty time for dog:", "New Dog Penalty", JOptionPane.INFORMATION_MESSAGE));
		while(penaltyTime <= 0)
		{
			penaltyTime = Double.parseDouble(JOptionPane.showInputDialog(null,"Invalid penalty time\npenalty time must be larger than 0", "Invalid Penalty Time", JOptionPane.INFORMATION_MESSAGE));
		}
		
		//Get course code for new dog.
		char courseCode = (JOptionPane.showInputDialog(null,"Enter course code\n1.Gamblers\n2.Jumpers\n3.Titling\nExample: g or G", "New Dog Course Code", JOptionPane.INFORMATION_MESSAGE).charAt(0));
		while(!(courseCode == 'g' || courseCode == 'G' || courseCode == 'j' || courseCode == 'J' || courseCode == 't' || courseCode == 'T'))
		{
			courseCode = (JOptionPane.showInputDialog(null,"Invalid course selection enter course\n1.Gamblers\n2.Jumpers\n3.Titling", "Invalid Course Code", JOptionPane.INFORMATION_MESSAGE).charAt(0));
		}

		Dog dog = new Dog(newID, newName, runTime, penaltyTime, courseCode);
		dogList.add(dog);
	}
	
	/**
	 * Save information of new dog information.
	 */
	private void saveNewDogFile()
	{
		try
		{
			PrintWriter fout = new PrintWriter(DOG_COMPETITON_FILE);
			int i;
			
			for(i=0; i < dogList.size() - 1; i++)
			{
				fout.println(formatNewDogForFile(dogList.get(i)));
			}
			
			fout.print(formatNewDogForFile(dogList.get(i)));
			fout.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		JFrame parent = new JFrame();
		JOptionPane.showMessageDialog(parent, "New dog information have been saved", "Information Saved", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 * @param dog return format for new dog information.
	 * @return format for new dog
	 */
	private String formatNewDogForFile(Dog dog)
	{
		return dog.getId()+" "+ dog.getName()+ " " + dog.getRunTime() + " " + dog.getPenalty() + " " + dog.getCourseCode();
	}
	
	/**
	 * 
	 * @return courseChoice
	 */
	private int courseSelection()
	{
		String line = JOptionPane.showInputDialog(null,"Enter 1,2 or 3 for desired course\n1. Gambler\n2. Jumpers\n3. Titling","Course Selection", JOptionPane.INFORMATION_MESSAGE);
		int courseChoice = Integer.parseInt(line);
		return courseChoice;
	}
	
	/**
	 * Print the report for each course and see which dog has won and the dog that has lost.
	 */
	private void printLoadReport()
	{
		int C = courseSelection() - 1;
		Course track = courseList.get(C);
		Date date = new Date();
		System.out.println("Report \t\t" + track.getCourseName() + " - Course Time: " + track.getCourseMaxTime() + "\t" + date + "\n");
		System.out.println("ID\t\tName\t\tRunning Time\t\tPenalty\t\tTotal Time\t\tOver Or Under");

		double totalTime = 0.0;
		double winningTime = 1000000;
		double losingTime = 0;
		String loserName = "losing";
		String winnerName = "Winning";

			for(int i = 0; i < dogList.size(); i++)
			{
				Dog order = dogList.get(i);
				totalTime = (order.getRunTime() + order.getPenalty());
				double overUnder = Math.round(10 * (order.getRunTime() +order.getPenalty() - track.getCourseMaxTime())) / 10;
				//Print report for Gamblers course.
				if(C == 0 && order.getCourseCode() == 'G' || order.getCourseCode() == 'g')
				{
					System.out.printf(order.getId() + "\t\t" + order.getName() + "\t\t" + order.getRunTime() + "\t\t\t" + order.getPenalty() + "\t\t%.2f" , totalTime);
					System.out.print("\t\t\t" + overUnder + "\n");
					
					if(winningTime > totalTime)
					{
						winningTime = totalTime;
						winnerName = order.getName();
					}
					if(totalTime > losingTime)
					{
						losingTime = totalTime;
						loserName = order.getName();
					}
				}
				//Print report for Jumpers course.
				if(C == 1 && order.getCourseCode() == 'J' || order.getCourseCode() == 'j')
				{
					System.out.printf(order.getId() + "\t\t" + order.getName() + "\t\t" + order.getRunTime() + "\t\t\t" + order.getPenalty() + "\t\t%.2f" , totalTime);
					System.out.print("\t\t\t" + overUnder + "\n");
					if(winningTime > totalTime)
					{
						winningTime = totalTime;
						winnerName = order.getName();
					}
					if(totalTime > losingTime)
					{
						losingTime = totalTime;
						loserName = order.getName();
					}
				}
				//Print report for Titling course.
				if(C == 2 && order.getCourseCode() == 'T' || order.getCourseCode() == 't')
				{
					System.out.printf(order.getId() + "\t\t" + order.getName() + "\t\t" + order.getRunTime() + "\t\t\t" + order.getPenalty() + "\t\t%.2f" , totalTime);
					System.out.print("\t\t\t" + overUnder + "\n");
					if(winningTime > totalTime)
					{
						winningTime = totalTime;
						winnerName = order.getName();
					}
					if(totalTime > losingTime)
					{
						losingTime = totalTime;
						loserName = order.getName();
					}
				}
			}
			System.out.println("\n");
			System.out.println("Winning dog: \t" + winnerName + " \tTime: " + winningTime);
			System.out.println("Losing dog: \t" + loserName + " \tTime: " + losingTime);
			System.exit(0);
	}
}

