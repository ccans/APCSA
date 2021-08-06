package T1Project;

import java.util.ArrayList;

public class ClassRoom {
	
	// Each class needs an ID and a name, as well as a list of the StudentIDs in the class and a list of the assignments in the class.
	int ID;
	String subjectName;
	public ArrayList<Integer> listOfStudentIDs = new ArrayList<Integer>();
	public ArrayList<Integer> listOfAssignments = new ArrayList<Integer>();
	
	// Setup function to set up a class
	public void setup(String name, int tempID) {
		ID = tempID;
		subjectName = name;
	}
	
	// Add a student to the class 
	public void addStudent(int studentID) {
		// Add their ID to the list of studentIDs
		listOfStudentIDs.add(studentID);
	}
}
