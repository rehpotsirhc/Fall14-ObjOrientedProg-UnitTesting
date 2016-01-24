package edu.usu.cs.filter;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.OlderThan25Strategy;
import edu.usu.cs.filter.strategy.Strategy;

public class PersonFilterTest {

	/*
	 * This test is missing at least one case. 
	 * There is a bug in PersonFilter.
	 *  1) Find the bug
	 *  2) Add a test case that shows the bug failing
	 *  3) Fix the bug
	 *  4) Verify that the failing test is NO LONGER failing
	 */
	@Test
	public void test() {
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(new Person("Bob", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		
		PersonFilter pf = new PersonFilter(new Strategy() {public boolean meetsCriteria(Person p) {return p.getFirstName().equals("Bob");}});
		String  s = pf.getFilterStatistics(personList);
		
		assertEquals("Old list had 5 people in it\r\nNew list has 1 people in it\r\n80.00% of people were filtered out", s);
	}
	
	
	/*
	 * This test uncovered the divide by zero error when the filter returned no people
	 */
	@Test
	public void testFilterStatisticsNoMatch() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("J", "", "", 0, "", "", "", "", ""));
		personList.add(new Person("", "", "", 0, "", "", "", "", ""));
		
		PersonFilter pf = new PersonFilter(new OlderThan25Strategy());
		
		String  s = pf.getFilterStatistics(personList);
		
		assertEquals("Old list had 2 people in it\r\nNew list has 0 people in it\r\n100.00% of people were filtered out", s);
	}
	
	/*
	 * This tests the functionality that was changed to fix the divide by zero error
	 */
	@Test
	public void testFilterStatisticsEmptyList() {
	
		
		List<Person> personList = new ArrayList<Person>();
		
		
		PersonFilter pf = new PersonFilter(new OlderThan25Strategy());
		
		String  s = pf.getFilterStatistics(personList);
		
		assertEquals("List is empty. Nothing to Filter", s);
	}
	
	
	
	

}
