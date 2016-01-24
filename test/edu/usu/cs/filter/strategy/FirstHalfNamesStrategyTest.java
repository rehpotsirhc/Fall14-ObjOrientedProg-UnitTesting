package edu.usu.cs.filter.strategy;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.FirstHalfNamesStrategy;
import edu.usu.cs.filter.strategy.Strategy;

public class FirstHalfNamesStrategyTest
	{
		@Test
		public void shouldNOTMatchOnlyFirstName()
			{
				
				Person maybe = new Person("Maybe", "Smith", "Female", -1, "" , "", "", "", "");
				
				Strategy fs = new FirstHalfNamesStrategy();
				
				assertFalse(fs.meetsCriteria(maybe));
			}
		
		@Test
		public void shouldNOTMatchOnlyLastName()
			{
				
				Person zedd = new Person("Zedd", "Able", "Male", -1, "" , "", "", "", "");
				
				Strategy fs = new FirstHalfNamesStrategy();
				
				assertFalse(fs.meetsCriteria(zedd));
				
			}
		
		@Test
		public void shouldNOTMatchNamesAfter()
			{
				
				Person tim = new Person("Tim", "Peterson", "Male", -1, "" , "", "", "", "");
				
				Strategy fs = new FirstHalfNamesStrategy();
				
				assertFalse(fs.meetsCriteria(tim));
				
			}
		
		
		
		@Test
		public void shouldNOTMatchNamesAt()
			{
				
				Person nancy = new Person("Nancy", "Whatever", "Female", -1, "" , "", "", "", "");
				
				Strategy fs = new FirstHalfNamesStrategy();
				
				assertFalse(fs.meetsCriteria(nancy));
				
			}
		
		@Test
		public void shouldMatchNamesBefore()
			{
				
				Person chris = new Person("Chris", "Johnson", "Male", -1, "" , "", "", "", "");
				
				Strategy fs = new FirstHalfNamesStrategy();
				
				assertTrue(fs.meetsCriteria(chris));
				
			}
	}
