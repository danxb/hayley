package uk.co.danxb.hayley.pairs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class DecidePairsTest {

	@Test
	public void decidePairsReturnsAnArrayListOfStudentPairs() {
		DecidePairs decidePairs = new DecidePairs();
		String[] students = { "Dan","Hayley","Luna","Jean-Claude"};
		ArrayList<StudentPair> pairs = decidePairs.getPairs(students);
		Assert.assertTrue(pairs instanceof ArrayList<?>);
	}

	@Test
	public void studentsPassedOutWerePassedIn() {
		DecidePairs decidePairs = new DecidePairs();
		String[] students = { "Dan","Hayley","Luna","Jean-Claude"};
		ArrayList<StudentPair> pairs = decidePairs.getPairs(students);
		for(StudentPair pair : pairs)
		{
			Assert.assertTrue(Arrays.asList(students).contains(pair.student1));
			Assert.assertTrue(Arrays.asList(students).contains(pair.student2));
		}
	}

	@Test
	public void differentStudentsPassedInWerePassedOut() {
		DecidePairs decidePairs = new DecidePairs();
		String[] students = { "Dad","Bob","Pepper","Kenny"};
		ArrayList<StudentPair> pairs = decidePairs.getPairs(students);
		for(StudentPair pair : pairs)
		{
			Assert.assertTrue(Arrays.asList(students).contains(pair.student1));
			Assert.assertTrue(Arrays.asList(students).contains(pair.student2));
		}
	}
	
	@Test
	public void resultsAreRandomised() {
		DecidePairs decidePairs = new DecidePairs();
		String[] students = { "Dad","Bob","Pepper","Kenny","Dan","Hayley","Luna","Jean-Claude"};
		ArrayList<StudentPair> pairs = decidePairs.getPairs(students);
		ArrayList<StudentPair> pairs2 = decidePairs.getPairs(students);
		assertNotSame(pairs.get(0).student1,pairs2.get(0).student1);
	}
	
	@Test
	public void studentsPassedInWerePassedOut() {
		DecidePairs decidePairs = new DecidePairs();
		String[] students = { "Dan","Hayley","Luna","Jean-Claude"};
		ArrayList<StudentPair> pairs = decidePairs.getPairs(students);
		Boolean allStudentsAccountedFor = true;
		for(String student : students)
		{
			Boolean studentAccountedFor = false;
			for(StudentPair pair : pairs)
			{
				if(pair.student1.equals(student) || pair.student2.equals(student))
					studentAccountedFor = true;
			}
			if(!studentAccountedFor)
				allStudentsAccountedFor = false;
		}
		Assert.assertTrue(allStudentsAccountedFor);
	}

}
