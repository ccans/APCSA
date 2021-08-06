package T1Project;

import java.util.ArrayList;

public class Student {
	
	// Each student needs a few attributes like a name, ID, grade (9th, 10th, etc), list of classes, and a list of grades (one grade per assignment)
	int ID, schoolYear;
	String name;
	ArrayList<Integer> subjectIDs = new ArrayList<Integer>();
	ArrayList<Integer> grades = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> assignmentBook = new ArrayList<ArrayList<Integer>>();  
	
	String attendance;

	
	// This is the function that sets up a new student
	public void setup(int studentID, String studentName, int studentGrade) {
		ID = studentID;
		name = studentName;
		schoolYear = studentGrade;
		attendance = "Here";
	}
	
	// Add a subject that the student is taking
	public void addSubject(int subjectID) {
		subjectIDs.add(subjectID);
		grades.add(100);
		ArrayList<Integer> listOfAssignments = new ArrayList<Integer>();
		listOfAssignments.add(100);
		assignmentBook.add(listOfAssignments);
	}
	
	public void removeSubject(int subjectID) {
		for(int q = 0; q < subjectIDs.size(); q++) {
			if(subjectIDs.get(q) == subjectID) {
				subjectIDs.remove(q);
				grades.remove(q);
				assignmentBook.remove(q);
				break;
			}
		}
	}
	
	public void addAssignment(int classID, int grade) {
		for(int h = 0; h < grades.size(); h++) {
			if(subjectIDs.get(h) == classID) {
				assignmentBook.get(h).add(grade);
				updateGrade(classID);
				break;
			}
		}
	}
	
	public void removeAssignment(int classID, int assignmentIndex) {
		for(int h = 0; h < grades.size(); h++) {
			if(subjectIDs.get(h) == classID) {
				assignmentBook.get(h).remove(assignmentIndex);
				updateGrade(classID);
				break;
			}
		}
	}
	
	public ArrayList<Integer> getClasses() {
		return subjectIDs;
	}
	
	public ArrayList<Integer> getAssignmentBook(int classID) {
		for(int h = 0; h < grades.size(); h++) {
			if(subjectIDs.get(h) == classID) {
				return assignmentBook.get(h);
			}
		}
		return new ArrayList<Integer>();
	}
	
	public void updateGrade(int classID) {
		for(int h = 0; h < grades.size(); h++) {
			if(subjectIDs.get(h) == classID) {
				int tot = 0;
				for(int r = 0; r < assignmentBook.get(h).size(); r++) {
					tot += assignmentBook.get(h).get(r);
				}
				grades.set(h, Math.round(tot/assignmentBook.get(h).size()));
				break;
			}
		}
	}
	
}

