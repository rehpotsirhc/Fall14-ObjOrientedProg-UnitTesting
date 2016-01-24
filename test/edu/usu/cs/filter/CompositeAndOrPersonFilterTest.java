package edu.usu.cs.filter;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.IsFemaleStrategy;
import edu.usu.cs.filter.strategy.OlderThan25Strategy;
import edu.usu.cs.filter.strategy.Strategy;

public class CompositeAndOrPersonFilterTest {


	
	/*
	 * Fully tests the CompositeAndPersonFilter and the CompositeOr PersonFilter
	 */
	static Strategy isFemale = new IsFemaleStrategy();
	static Strategy over25 = new OlderThan25Strategy();
	
	static PersonFilter pf1= new PersonFilter(isFemale);
	static PersonFilter pf2= new PersonFilter(over25);
	static PersonFilter compositeAnd = new CompositeAndPersonFilter(pf1, pf2);
	static PersonFilter compositeOr = new CompositeOrPersonFilter(pf1, pf2);
	
	
	/*
	 * 16 total people
	 * 
	 */
	
	static Person isOnlyFemale1 = new Person("", "", "Female", -1, "" , "", "", "", "");
	static Person isOnlyFemale2 = new Person("", "", "F", -1, "" , "", "", "", "");
	static Person isOnlyFemale3 = new Person("", "", "Fem", -1, "" , "", "", "", "");
	
	static Person isOnlyOver251 = new Person("", "", "M", 26, "" , "", "", "", "");
	static Person isOnlyOver252 = new Person("", "", "M", 126, "" , "", "", "", "");
	static Person isOnlyOver253 = new Person("", "", "Male", 1226, "" , "", "", "", "");
	
	static Person isNeither1 = new Person("", "", "Male", 25, "" , "", "", "", "");
	static Person isNeither2 = new Person("", "", "M", 14, "" , "", "", "", "");
	static Person isNeither3 = new Person("", "", "Male", 13, "" , "", "", "", "");
	static Person isNeither4 = new Person("", "", "M", 12, "" , "", "", "", "");
	static Person isNeither5 = new Person("", "", "Male", 11, "" , "", "", "", "");
	static Person isNeither6 = new Person("", "", "M", 8, "" , "", "", "", "");
	
	static Person isBoth1 = new Person("", "", "Female", 50, "" , "", "", "", "");
	static Person isBoth2 = new Person("", "", "Female", 28, "" , "", "", "", "");
	static Person isBoth3 = new Person("", "", "Female", 27, "" , "", "", "", "");
	static Person isBoth4 = new Person("", "", "F", 31, "" , "", "", "", "");
	static List<Person> personList = new ArrayList<Person>();
	static List<Person> personListCopy = new ArrayList<Person>();
	static List<Person> filteredList;
	
	@BeforeClass 
	public static void setUP()
	{
	
		
		personList.add(isNeither1);
		personList.add(isNeither2);
		personList.add(isNeither3);
		personList.add(isNeither4);
		personList.add(isNeither5);
		personList.add(isNeither6);
	}
	
	@After 
	public void beforeMethods()
	{
		personListCopy = new ArrayList<Person>(personList);

		
		filteredList = new ArrayList<Person>();
	}
	
	@After 
	public void afterMethods()
	{
		filteredList = new ArrayList<Person>();
		personListCopy = new ArrayList<Person>();
	}
	
	
	/* Test the AND filter */
	
	@Test
	public void ANDFiltersNoneWithNeitherMatch() {
		
	
		
		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 0);
		
		
			
	}
	
	@Test
	public void ANDFiltersNoneWithPartialMatch1() {
		
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);
		
	
		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 0);
			
	}
	
	@Test
	public void ANDFiltersNoneWithRightMatch2() {
		

		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		
		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 0);
			
	}
	
	@Test
	public void ANDFiltersNoneWithRightMatch3() {
		
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);

		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		

		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 0);
			
	}
	
	@Test
	public void ANDFiltersSomeWithBothMatch()
	{
		personListCopy.add(isBoth1);
		personListCopy.add(isBoth2);
		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 2);

	}
	@Test
	public void ANDFiltersSomeWithBothMatch2()
	{
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);

		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		
		personListCopy.add(isBoth1);
		personListCopy.add(isBoth2);
		personListCopy.add(isBoth3);
		personListCopy.add(isBoth4);
		filteredList = compositeAnd.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 4);

	}
	
	/* Test the OR filter */
	
	
	@Test
	public void ORFiltersNoneWithNeitherMatch() {
		
		filteredList = compositeOr.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 0);
		
	}
	
	
	@Test
	public void OrFiltersSomeWithPartialMatch1() {
		
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);
		
		filteredList = compositeOr.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 3);
			
	}
	@Test
	public void OrFiltersSomeWithPartialMatch2() {
		
		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		
		filteredList = compositeOr.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 3);
			
	}
	
	@Test
	public void OrFiltersSomeWithPartialMatch3() {
		
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);

		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		filteredList = compositeOr.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 6);
			
	}
	
	@Test
	public void OrFiltersSomeWithPartialMatch4() {
		
		personListCopy.add(isOnlyFemale1);
		personListCopy.add(isOnlyFemale2);
		personListCopy.add(isOnlyFemale3);

		personListCopy.add(isOnlyOver251);
		personListCopy.add(isOnlyOver252);
		personListCopy.add(isOnlyOver253);
		
		personListCopy.add(isBoth1);
		personListCopy.add(isBoth2);
		personListCopy.add(isBoth3);
		personListCopy.add(isBoth4);
		filteredList = compositeOr.getFilteredList(personListCopy);
		int filteredSize =  filteredList.size();
		assertTrue(filteredSize == 10);
		
		
			
	}
}
