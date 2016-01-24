package edu.usu.cs.filter.strategy;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.BirthdayInRangeStrategy;
import edu.usu.cs.filter.strategy.Strategy;


public class BirthdayInRangeStrategyTest
	{
		
		@Test
		public void shouldMatch1Day()
			{
				String day = "10/26/1991";
				Strategy bStrat = new BirthdayInRangeStrategy(day , day );
				// Person(String firstName, String lastName, String gender, int
				// age, String birthday, String q1, String q2, String q3, String
				// q4)
				Person mike = new Person("Mike", "Johnson", "Male", -1, day , "", "", "", "");
				assertTrue(bStrat.meetsCriteria(mike));
			}
		
		@Test
		public void shouldMatchStartBoundary()
			{
				String startRange = "10/26/1991";
				Strategy bStrat = new BirthdayInRangeStrategy(startRange, "10/26/2001");
				// Person(String firstName, String lastName, String gender, int
				// age, String birthday, String q1, String q2, String q3, String
				// q4)
				Person mike = new Person("Mike", "Johnson", "Male", -1, startRange, "", "", "", "");
				assertTrue(bStrat.meetsCriteria(mike));
			}
		
	

		@Test
		public void shouldMatchEndBoundary()
			{
				
				String endRange = "11/17/1996";
				
				Strategy bStrat = new BirthdayInRangeStrategy("1/1/1900", endRange);

				
				Person angel = new Person("Angel", "Johnson", "Female", -1, endRange, "", "", "", "");
				assertTrue(bStrat.meetsCriteria(angel));
			}
		
		@Test
		public void shouldMatchMiddle()
			{
				
				String bdayInBetween = "10/9/2014";
				
				Strategy bStrat = new BirthdayInRangeStrategy("1/1/1950", "1/1/2025");

				
				Person angel = new Person("Angel", "Johnson", "Female", -1, bdayInBetween, "", "", "", "");
				assertTrue(bStrat.meetsCriteria(angel));
			}
		
		@Test
		public void shouldNOTMatchBefore()
			{
				
				String bdayInBetween = "10/9/2013";
				
				Strategy bStrat = new BirthdayInRangeStrategy("10/9/2014", "1/1/2025");

				
				Person angel = new Person("Angel", "Johnson", "Female", -1, bdayInBetween, "", "", "", "");
				assertFalse(bStrat.meetsCriteria(angel));
			}
	
		
		@Test
		public void shouldNOTMatchAfter()
			{
				
				String bdayInBetween = "1/2/2025";
				
				Strategy bStrat = new BirthdayInRangeStrategy("10/9/2014", "1/1/2025");

				
				Person angel = new Person("Angel", "Johnson", "Female", -1, bdayInBetween, "", "", "", "");
				assertFalse(bStrat.meetsCriteria(angel));
			}
	
		
		
	}
