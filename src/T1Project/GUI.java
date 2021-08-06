package T1Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {
	
	// A multitude of panels, panes, and frames are neccesary for the GUI
	JFrame frame = new JFrame();
	
	JPanel classPanel;
	JPanel studentPanel;
	JScrollPane pane;
	JScrollPane pane2;
	
	// Very important, this instance of classmanager manages all backend functionality
	ClassManager manager = new ClassManager();
	
	// This function is the first to be run, it sets up the GUi
	public void setup() {
		// Setup the jframe with dimensions, color, and an exit behaviour 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 600));
		frame.getContentPane().setBackground(Color.white);
		
		// Now that the frame itself is setup, call the start function which processes and renders the initial GUI
		start();
	}
	
	
	// Function that makes the "start" screen
	public void start() {
		
		// I REALLY hated the way default jpanel's looked, so I made a function called "createSimpleJPanel" that creates a formatted JPanel.
		// Using that funciton to create a loosely formatted jpanel 
		JPanel startPanel = createSimpleJPanel("Dashboard");
		
		// Another JPanel for the buttons
        JPanel buttonPanel = new JPanel();
        
        buttonPanel.setPreferredSize(new Dimension(900, 500));
		
        // Add two buttons to the button panel
		JButton button1 = createSimpleButton("Class Manager");
		JButton button2 = createSimpleButton("Student Manager");
		
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		
		buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
		// Add the panel of buttons to the panel from before
		startPanel.add(buttonPanel);
		
		// Add the whole thing to the frame and make it visible
	
		frame.getContentPane().add(startPanel);
        frame.pack();
        frame.setVisible(true);
		
        
        // ACTION LISTENERS ON WHAT SHOULD HAPPEN ON BUTTON PRESSES
		button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// Remove the old panel, launch the "addClass" panel 
				// Basically, remove the old page and go to a different page of the application
				clearPanel(startPanel);
				addClass();
			} 
		});
		
		button2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// Remove the old panel, launch the "addStudent" panel 
				// Basically, remove the old page and go to a different page of the application
				clearPanel(startPanel);
				addStudent();
			} 
		});
		
		
	}
	
	
	// A simple function that removes a panel from the frame
	public void clearPanel(JPanel panel) {
		frame.remove(panel);
	}
	
	// A simple funciton that adds a panel to the frame
	public void addPanel(JPanel panel) {
		frame.add(panel);
		frame.revalidate();
		frame.repaint();
	}
	
	
	// This function is one of the pages in the applicaiton, the class manager page
	public void addClass() {
		
		// Use the JPanel function in this file to make a new JPanel
		// Also format the panel
		classPanel = createSimpleJPanel("Class Manager");
		
		// This is the small panel that the user uses to create classes
		JPanel classManagerPanel = new JPanel();
	
		classManagerPanel.setPreferredSize(new Dimension(150, 200));
		
		classManagerPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		
		// Add a textfield for entry
		JTextField textField = new JTextField(10);
		
		// Add 2 labels and a bunch of formatting to the small panel (classManagerPanel)
		JLabel label = new JLabel("What is the name of the class?", SwingConstants.CENTER);
		
		label.setText("<html><p style=\"width:100px; text-align:center\"> Add a class </p></html>");
		label.setPreferredSize(new Dimension(125, 50));
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		classManagerPanel.add(label);
		
		JLabel label2 = new JLabel("What is the name of the class?", SwingConstants.CENTER);
		
		label2.setText("<html><p style=\"width:100px; text-align:center\"> What is the name of the class? </p></html>");
		label2.setPreferredSize(new Dimension(125, 35));
		
		classManagerPanel.add(label2);
		
		classManagerPanel.add(textField);
        
		
		// Add a button to the classmanagerpanel that can be pressed to add classes
        JButton button1 = new JButton("Add");
		button1.setPreferredSize(new Dimension(75, 25));
		classManagerPanel.add(button1);
		
		classPanel.add(classManagerPanel);
		
		// This function renders all the existing classes and their students using a smurf function lower in the code
		for(int i = 0; i < manager.listOfSubjects.size(); i++) {
			classPanel.add(createProfile(manager.listOfSubjects.get(i).ID));
		}
		
		// Format the class panel
		// ERROR PROTECTION: THE PANEL EXTENDS WITH MORE SUBJECTS
		classPanel.setPreferredSize(new Dimension(600, 300*( (manager.listOfSubjects.size() - (manager.listOfSubjects.size()%5))/5 + 1)));
		
		classPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		// We need to make the application scrollable
		pane = new JScrollPane(classPanel);
		
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setVisible(true);
        
        // Addd the action listener to the button. If the input passes the error protection, add the class
        button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// ERROR PROTECTION -- MAKE SURE THAT THE TEXTFIELD HAS A VALUE. 
				if(textField.getText() == null || textField.getText() == "" || textField.getText() == " " || textField.getText().equals("")) {
					textField.setText("Please input a value");
				} else {
					manager.addClass(textField.getText());
					frame.remove(pane);
					addClass();
				}
			} 
		});
	}
	
	// This function is one of the pages in the applicaiton, the student manager page
	public void addStudent() {
		
		// Create a panel for the page
		studentPanel = createSimpleJPanel("Student Manager");
		
		// This panel has the ability to add new students
		JPanel classManagerPanel = new JPanel();
		
		// Format the panel
		classManagerPanel.setPreferredSize(new Dimension(150, 200));
		
		classManagerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// Add a textfield and a label
		JTextField textField = new JTextField(10);
		
		JLabel label = new JLabel("What is the name of the student?", SwingConstants.CENTER);
		
		label.setText("<html><p style=\"width:100px; text-align:center\"> Add a student </p></html>");
		label.setPreferredSize(new Dimension(125, 30));
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		classManagerPanel.add(label);
		
		// We need a label and a respective textfield for the name of the student
		
		JLabel label2 = new JLabel("What is the name of the student?", SwingConstants.CENTER);
		
		label2.setText("<html><p style=\"width:100px; text-align:center\"> Name: </p></html>");
		label2.setPreferredSize(new Dimension(125, 30));
		
		classManagerPanel.add(label2);
		
		classManagerPanel.add(textField);
		
		// We need a label and a respective textfield for the grade of the student
		
		JLabel label3 = new JLabel("What is the name of the student?", SwingConstants.CENTER);
		
		label3.setText("<html><p style=\"width:100px; text-align:center\"> Grade: </p></html>");
		label3.setPreferredSize(new Dimension(125, 30));
		
		
		JTextField textField2 = new JTextField(10);
		
		classManagerPanel.add(label3);
		
		classManagerPanel.add(textField2);
        
		// A button to actually add the student
        JButton button1 = new JButton("Add");
		button1.setPreferredSize(new Dimension(75, 25));
		classManagerPanel.add(button1);
		
		studentPanel.add(classManagerPanel);
		
		// ERROR PROTECTION: the panel grows longer based on the number of students
		studentPanel.setPreferredSize(new Dimension(600, 300*( (manager.listOfStudents.size() - (manager.listOfStudents.size()%5))/5 + 1)));
		
		// We need to render the existing students through a function created
		for(int i = 0; i < manager.listOfStudents.size(); i++) {
			studentPanel.add(createStudentProfile(manager.listOfStudents.get(i).ID));
		}
		
		// The whole thing needs to be scrollable
		pane2 = new JScrollPane(studentPanel);
		
        frame.getContentPane().add(pane2);
        frame.pack();
        frame.setVisible(true);
        
        // Action listener for button press, if all checks are passes, a student is created
        button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// ERROR PROTECTION FOR BOTH INVALID GRADES AND NAMES
					if(textField.getText() == null || textField.getText() == "" || textField.getText() == " " || textField.getText().equals("")) {
						textField.setText("Please input a value");
					} else if(Integer.parseInt(textField2.getText()) < 9 || Integer.parseInt(textField2.getText()) > 12) {
						textField2.setText("Please input a valid value (9-12)");
					} else {
						manager.addStudent(textField.getText(), Integer.parseInt(textField2.getText()));
						frame.remove(pane2);
						addStudent();
					}
				
				} catch (NumberFormatException f) {
					textField2.setText("Please input a valid value");
			  }
			} 
		});
        
        
	}
	
	// A simple function that creates and outputs a simple button
	private JButton createSimpleButton(String text) {
		JButton tempButton = new JButton(text);
		tempButton.setFocusPainted(false);
		tempButton.setContentAreaFilled(false);
		tempButton.setPreferredSize(new Dimension(200, 200));
		return tempButton;
	}
	
	// This function is abstracted and creates a sleek JPanel (that looks MUCH better then the default)
	
	private JPanel createSimpleJPanel(String text) {
		
		// Create a temporaru panel and format it
		JPanel tempPanel = new JPanel();
		
		tempPanel.setBackground(Color.white);
		
		tempPanel.setPreferredSize(new Dimension(900, 600));
		
		// Add a title to the JPanel based on input, format nicely again.
		JLabel title = new JLabel(text, SwingConstants.LEFT);
		title.setPreferredSize(new Dimension(800, 50));
        title.setFont(new Font("Verdana", Font.PLAIN, 36));
        title.setBorder(new EmptyBorder(0,30,0,0));
        
        if(text == "Class Manager" ) {
        	// Special rendering for class manager to create THE RIGHT back-button
        	JPanel tempPanel2 = new JPanel();
        	tempPanel2.setBackground(Color.white);
    		
        	tempPanel2.setPreferredSize(new Dimension(890, 60));
        	
        	JButton exit = new JButton("X");
    		exit.setPreferredSize(new Dimension(50, 50));
    		exit.setBackground(Color.RED);
    		exit.addActionListener(new ActionListener() { 
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				frame.remove(pane);
    				start();
    			} 
    		});
    		tempPanel2.add(title);
            tempPanel2.add(exit);
    		tempPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

            
            tempPanel.add(tempPanel2);
        } else if (text == "Student Manager") {
        	
        	// Special rendering for student manager to create THE RIGHT back-button
        	
        	JPanel tempPanel2 = new JPanel();
        	tempPanel2.setBackground(Color.white);
    		
        	tempPanel2.setPreferredSize(new Dimension(890, 60));
        	
        	JButton exit = new JButton("X");
    		exit.setPreferredSize(new Dimension(50, 50));
    		exit.setBackground(Color.RED);
    		exit.addActionListener(new ActionListener() { 
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				frame.remove(pane2);
    				start();
    			} 
    		});
    		tempPanel2.add(title);
            tempPanel2.add(exit);
    		tempPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

            
            tempPanel.add(tempPanel2);
        	
        } else {
        
        tempPanel.add(title);
        
        }
        
 
        // Return the panel created
        return tempPanel;
        
	}
	
	// This function is an abstracted function that creates a little panel for a class to put on the classManager page based on a classID
	public JPanel createProfile(int classID) {
		
		// Make a temporary panel and format it
		JPanel tempPanel = new JPanel();
		
		tempPanel.setPreferredSize(new Dimension(150, 200));
		
		tempPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		JLabel label = new JLabel("What is the name of the class?", SwingConstants.CENTER);
		
		// Put a label with the name of the class on them
		label.setText("<html><p style=\"width:100px; text-align:center\">" + manager.getClass(classID).subjectName + "</p></html>");
		label.setPreferredSize(new Dimension(125, 50));
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		tempPanel.add(label);
		
		
		JPanel p = new JPanel();
        JScrollPane scroll = new JScrollPane(p);
        p.setPreferredSize(new Dimension(125, manager.getClass(classID).listOfStudentIDs.size()*30 + 30));
        scroll.getViewport().setPreferredSize(new Dimension(125, 100));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        for(int y = 0; y < manager.getClass(classID).listOfStudentIDs.size(); y++) {
        	// This loop creates a small section for each student in the subject
        	JLabel exampleButton = new JLabel(manager.getStudent(manager.getClass(classID).listOfStudentIDs.get(y)).name, SwingConstants.CENTER);
        	exampleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        	exampleButton.setPreferredSize(new Dimension(95, 25));
        	
        	// Next to each student being listed, we also need a red button to "remove" the student on press
        	JButton removeStudent = new JButton();
        	removeStudent.setBackground(Color.RED);
        	removeStudent.setPreferredSize(new Dimension(10, 10));
        	removeStudent.setName(Integer.toString(classID) + ' ' + Integer.toString(manager.getClass(classID).listOfStudentIDs.get(y)));
        	
        	removeStudent.addActionListener(new ActionListener() { 
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				StringTokenizer sortOut = new StringTokenizer(((JButton) e.getSource()).getName());
        			int classIDout = Integer.parseInt(sortOut.nextToken());
        			int studentIDout = Integer.parseInt(sortOut.nextToken());
        			
        			// Remove the student and refresh the page
    				manager.removeStudentFromClass(studentIDout, classIDout);
    				frame.remove(pane);
    				addClass();
    			} 
    		});
        	
        	
    		p.add(exampleButton);
    		p.add(removeStudent);
        }
        
        
        // Each subject also needs a button to add students to the subject
        
        JButton exampleButton = new JButton("Add Student");
        exampleButton.setBackground(Color.GREEN);
    	exampleButton.setPreferredSize(new Dimension(105, 25));
		p.add(exampleButton);
		exampleButton.setName(Integer.toString(classID));
		
		
		exampleButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudentToClass(Integer.parseInt(((JButton) e.getSource()).getName()));
			} 
		});
        
        tempPanel.add(scroll);
		
		
		
		return tempPanel;
		
	}
	
	// This function is an abstracted function that creates a little panel for a student to put on the studentManager page based on a studentID
	
	public JPanel createStudentProfile(int studentID) {
		
		// Create a panel and format it
		JPanel tempPanel = new JPanel();
		
		tempPanel.setPreferredSize(new Dimension(150, 200));
		
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel label = new JLabel("What is the name of the class?", SwingConstants.CENTER);
		
		// Put a name on the panel
		
		label.setText("<html><p style=\"width:100px; text-align:center\">" + manager.getStudent(studentID).name + "</p></html>");
		label.setPreferredSize(new Dimension(125, 50));
		label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		tempPanel.add(label);
		
		// Create a list with all of the options for attendence
		
		String[] bookTitles = new String[] {"Here", "Tardy",
                "Absent", "Excused"};

		JComboBox<String> bookList = new JComboBox<>(bookTitles);
		
		bookList.setName(Integer.toString(studentID));
		
		// set the attendance to the the attendance of the student
		
		switch(manager.getStudent(studentID).attendance) {
			case "Here":
				bookList.setSelectedIndex(0);
				break;
			case "Tardy":
				bookList.setSelectedIndex(1);				
				break;
			case "Absent":
				bookList.setSelectedIndex(2);				
				break;
			case "Excused":
				bookList.setSelectedIndex(3);				
				break;
			default:
		}
		
		// The dropdown needs to switch the attendance when the option is changed
		
		bookList.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				int studentID2 = Integer.parseInt(((JComboBox<String>) e.getSource()).getName());
					
				switch(((JComboBox<String>) e.getSource()).getSelectedIndex()) {
					case 0:
						manager.getStudent(studentID2).attendance = "Here";
						break;
					case 1:
						manager.getStudent(studentID2).attendance = "Tardy";
						break;
					case 2:
						manager.getStudent(studentID2).attendance = "Absent";
						break;
					case 3:
						manager.getStudent(studentID2).attendance = "Excused";
						break;
					default:
						
				}
		    }
		});
	
		tempPanel.add(bookList);
		
		// Create a scrollable panel
		JPanel p = new JPanel();
        JScrollPane scroll = new JScrollPane(p);
        p.setPreferredSize(new Dimension(125, manager.getStudent(studentID).subjectIDs.size()*30));
        scroll.getViewport().setPreferredSize(new Dimension(125, 100));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        // Add subjects that the student is in to the panel
        for(int y = 0; y < manager.getStudent(studentID).subjectIDs.size(); y++) {
        	// Create a small label and button (for grades) for each subject. Format and add
        	JLabel exampleButton = new JLabel( manager.getClass(manager.getStudent(studentID).subjectIDs.get(y)).subjectName + " - " + manager.getStudent(studentID).grades.get(y), SwingConstants.CENTER);
        	exampleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        	exampleButton.setPreferredSize(new Dimension(95, 25));
        	
        	JButton removeStudent = new JButton();
        	removeStudent.setBackground(Color.BLUE);
        	removeStudent.setPreferredSize(new Dimension(10, 10));
        	removeStudent.setName(Integer.toString(manager.getStudent(studentID).subjectIDs.get(y)) + ' ' + studentID);
        	
        	// Add a listener to the blue button to change the frade
        	removeStudent.addActionListener(new ActionListener() { 
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				StringTokenizer sortOut = new StringTokenizer(((JButton) e.getSource()).getName());
        			int classIDout = Integer.parseInt(sortOut.nextToken());
        			int studentIDout = Integer.parseInt(sortOut.nextToken());
        	

        			ArrayList<Integer> optionList = manager.getStudent(studentIDout).getAssignmentBook(classIDout);
        			ArrayList<String> optionsList = new ArrayList<String>();
        			
        			// Make a list with all of the assignment grades that the student has
        			for(int k = 0; k < optionList.size(); k++) {
        				optionsList.add("Remove " +  optionList.get(k));
        			}
        			
        			// Add an option to ADD an assignment grade
        			optionsList.add("Add a new assignment grade");
        			Object[] options = optionsList.toArray();
        			
        			// Popup with all the options for the assignment
        			Object value = JOptionPane.showInputDialog(null, 
        			                                           "Select an assignment", 
        			                                           "Assignment", 
        			                                            JOptionPane.QUESTION_MESSAGE, 
        			                                            null,
        			                                            options, 
        			                                            options[0]);

        			int index = optionsList.indexOf(value);
        			
        			try {
        			 // Check if they're adding a grade or removing a grade
        				if(index == optionList.size()) {
        					
        					// Popup, ask for grade
        					String whatTheUserEntered = JOptionPane.showInputDialog("What grade does this student get for the assignment?");
        					// Protection if you don't enter a number
        					try {
        						// Make sure that the entered number is a valid number
                				if(Integer.parseInt(whatTheUserEntered) > -1 && Integer.parseInt(whatTheUserEntered) < 101) {
                					// Add the grade, reload
        	        				manager.getStudent(studentID).addAssignment(classIDout, Integer.parseInt(whatTheUserEntered));
        	        				frame.remove(pane2);
        	        				addStudent();
                				} else {
                					JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 100");
                				}
                			} catch (NumberFormatException f) {
                				JOptionPane.showMessageDialog(null, "Please enter a number");
                			}

        					
	        				
        				} else {
        					// Make sure that there is always one grade in the gradebook
        					if(optionList.size() == 1) {
                				JOptionPane.showMessageDialog(null, "You must have at least 1 grade in the gradebook. Add a grade and then get rid of this one");

        					} else {
	        					manager.getStudent(studentID).removeAssignment(classIDout, index);
		        				frame.remove(pane2);
		        				addStudent();
        					}
        				}
        			} catch (NumberFormatException f) {
        				
        			}
    				
    				
    			} 
    		});
        	
        	
    		p.add(exampleButton);
    		p.add(removeStudent);
        }
        
       
        
        tempPanel.add(scroll);
		
		
		
		return tempPanel;
		
	}
	
	// Small, abstracted funciton that adds a student to a class from a popup
	public void addStudentToClass(int classID) {
		ArrayList<String> arrList = new ArrayList<String>();
		
		// Make a list of all the student's not already in the class
		for(int u = 0; u < manager.listOfStudents.size(); u++) {
			if(manager.checkIfStudentInClass(manager.listOfStudents.get(u).ID, classID)) {
				
			} else {
				arrList.add(manager.listOfStudents.get(u).name);
			}
		}
		if(arrList.size() == 0 ) {
			JOptionPane.showMessageDialog(null, "There are no more avaliable students not already in this class. Create more using student manager");
		} else {
		
		String[] strArr = new String[arrList.size()];
		
		for(int o = 0; o < strArr.length; o++) {
			strArr[o] = arrList.get(o);
		}
    
		// Add all the students not already int he class to a dropdown
        String result = (String)JOptionPane.showInputDialog(
                frame,
                "Select a student to add!", 
                "Student Selector",            
                JOptionPane.PLAIN_MESSAGE,
                null,            
                strArr, 
                strArr[0] 
             );
        // Make sure that they selected something, and then add the student.
        if(result != null && !result.equals(" ")) {
	        manager.addStudentToClass(manager.getStudentFromName(result), classID);
	        
	        frame.remove(pane);
	        addClass();
			
			frame.setPreferredSize(new Dimension(900, 600));
        }
		}
	}
	
	
}
