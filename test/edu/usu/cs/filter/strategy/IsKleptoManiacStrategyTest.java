package edu.usu.cs.filter.strategy;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.IsKleptoManiacStrategy;
import edu.usu.cs.filter.strategy.Strategy;

public class IsKleptoManiacStrategyTest
	{
		@Test
		public void shouldMatchKleptoCriteria()
			{
				Person something = new Person("Hello", "Universe", "SomethingElse", -1, "bDay" , "1", "0", "NA", "1");
				
				Strategy fs = new IsKleptoManiacStrategy();
				
			
				assertTrue(fs.meetsCriteria(something));
				
				
				
			}
		@Test
		public void shouldNotMatchOtherCriteria0()
		{
			Person something = new Person("Hello", "Universe", "SomethingElse", -1, "bDay" , "0", "0", "NA", "1");
			
			Strategy fs = new IsKleptoManiacStrategy();
			
		
			assertFalse(fs.meetsCriteria(something));
			
		}
		@Test
		public void shouldNotMatchOtherCriteria1()
			{
				Person something = new Person("Hello", "Universe", "SomethingElse", -1, "bDay" , "1", "1", "NA", "1");
				
				Strategy fs = new IsKleptoManiacStrategy();
				
			
				assertFalse(fs.meetsCriteria(something));
				
			}
		@Test
		public void shouldNotMatchOtherCriteria3()
			{
				Person something = new Person("Hello", "Universe", "SomethingElse", -1, "bDay" , "1", "0", "NA", "0");
				
				Strategy fs = new IsKleptoManiacStrategy();
				
			
				assertFalse(fs.meetsCriteria(something));
				
			}
	}
