package T1Project;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassManager {
	
	// We want a global (static) scanner to be ready to use whenever and also so we don't have overlapping Scanners
	static Scanner reader = new Scanner(System.in);

	// We need a list of the instances of all classes offered at the school, as well as the instance of each student
	ArrayList<ClassRoom> listOfSubjects = new ArrayList<ClassRoom>();
	ArrayList<Student> listOfStudents= new ArrayList<Student>();

	// This function takes a studentID, classID, adds the studentID to the class, and adds the classID to the student
	public void addStudentToClass(int studentID, int classID) {
		// Get the class by it's ID and add the student to the class
		getClass(classID).addStudent(studentID);
		// Get the student by their ID and add the class as a subject
		getStudent(studentID).addSubject(classID);
	}
		
	// This function adds a class to the list of classes made above. It takes in a name and auto-assigns an ID
	public void addClass(String name) {
		// Make a temporary classroom, and set it up 
		ClassRoom temp = new ClassRoom();
		temp.setup(name, listOfSubjects.size() + 1);
		// Put this temporary classroom with the other classrooms in the arraylist that stores all the classrooms
		listOfSubjects.add(temp);
	}

	// This function takes in a classID, iterates through the ArrayList of classes, and finds the class corresponding to that ID. It then returns this class
	// If there is no class associated with the ID, it returns an empty class with the ID "null"
	public ClassRoom getClass(int ID) {
		// Loop that iterates over every subject
		for(int j = 0; j < listOfSubjects.size(); j++) {
			// Does the ID of the subject match the ID we are looking for? If so return that class. If not, keep the loop moving
			if(listOfSubjects.get(j).ID == ID) {
				return listOfSubjects.get(j);
			}
		}
		// If nothing is found, return an empty classroom
		return new ClassRoom();
	}
	
	
	// This function takes a name and a grade and creates a new student in the system
	public void addStudent(String name, int grade) {
		// Make a temporary student, and set them up
		Student temp = new Student();
		temp.setup((listOfStudents.size() + 1), name, grade);
		// Add the temporary student to the ArrayList of all the students attending the school
		listOfStudents.add(temp);
	}
	
	public void removeStudentFromClass(int studentID, int classID) {
		for(int r = 0; r < getClass(classID).listOfStudentIDs.size(); r++) {
			if(getClass(classID).listOfStudentIDs.get(r) == studentID) {
				getClass(classID).listOfStudentIDs.remove(r);
				getStudent(studentID).removeSubject(classID);
			}
		}
	}
	
	
	// This function takes in a studentID, iterates through the ArrayList of students, and finds the student corresponding to that ID. It then returns this student
	// If there is no student associated with the ID, it returns an empty student with the ID "null"
	public Student getStudent(int studentID) {
		// Loop that iterates over every student
		for(int j = 0; j < listOfStudents.size(); j++) {
			// Does the ID of the student match the ID we are looking for? If so, return that student. If not, keep the loop moving
			if(listOfStudents.get(j).ID == studentID) return listOfStudents.get(j);
		}
		// If nothing is found, return an empty student
		return new Student();
	}
	
	


	
	
	public boolean checkIfStudentInClass(int studentID, int classID) {
		for(int q = 0; q < getClass(classID).listOfStudentIDs.size(); q++) {
			if(studentID == getClass(classID).listOfStudentIDs.get(q)) return true;
		}
		return false;
	}
	
	public int getStudentFromName(String name) {
		for(int p = 0; p < listOfStudents.size(); p++) {
			if(listOfStudents.get(p).name == name) return listOfStudents.get(p).ID;
		}
		return -1;
	}

	public static void main(String args[]) {

		GUI displayManager = new GUI();
		
		displayManager.setup();
		
	}
}


