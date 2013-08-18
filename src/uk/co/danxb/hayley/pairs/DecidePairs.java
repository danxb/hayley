package uk.co.danxb.hayley.pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecidePairs {

	private List<String> studentList;
	private ArrayList<StudentPair> pair;
	
	public ArrayList<StudentPair> getPairs(String[] students) {
		randomiseOrderOfStudents(students);
		assignPairs();
		return pair;
	}

	private ArrayList<StudentPair> assignPairs() {
		pair = new ArrayList<StudentPair>();
		for(int i=1;i<studentList.size();i+=2)
			addTwoStudentsToPair(i);
		return pair;
	}

	private void addTwoStudentsToPair(int i) {
		StudentPair studentPair = new StudentPair();
		studentPair.student1 = studentList.get(i-1);
		studentPair.student2 = studentList.get(i);
		pair.add(studentPair);
	}

	private List<String> randomiseOrderOfStudents(String[] students) {
		studentList = new ArrayList<String>();
		for(String student : students)
			studentList.add(student);
		Collections.shuffle(studentList);
		return studentList;
	}
}
