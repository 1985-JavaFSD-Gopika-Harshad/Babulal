package CodingQuestion;

import java.util.LinkedHashMap;

public class StudentGrades {
	
	 public static void main(String[] args) {
	        LinkedHashMap<String, Integer> grades = new LinkedHashMap<>();

	        // Adding grades
	        grades.put("Student1", 85);
	        grades.put("Student2", 90);
	        grades.put("Student3", 78);

	        // Processing grades in insertion order
	        for (String studentId : grades.keySet()) {
	            System.out.println("Grade for " + studentId + ": " + grades.get(studentId));
	        }
	    }

}
