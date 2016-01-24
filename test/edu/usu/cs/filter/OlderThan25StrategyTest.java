package edu.usu.cs.filter;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.OlderThan25Strategy;
import edu.usu.cs.filter.strategy.Strategy;

public class OlderThan25StrategyTest
	{
		@Test
		public void shouldMatchOver25()
			{
				Person over25 = new Person("", "", "", 37, "" , "", "", "", "");
				
				Strategy fs = new OlderThan25Strategy();
				
			
				assertTrue(fs.meetsCriteria(over25));
			}
		
		@Test
		public void shouldNotMatch25()
			{
				Person at25 = new Person("", "", "", 25, "" , "", "", "", "");
				
				Strategy fs = new OlderThan25Strategy();
				
			
				assertFalse(fs.meetsCriteria(at25));
			}
		
		@Test
		public void shouldNotMatchUnder25()
			{
				Person under25 = new Person("", "", "", 13, "" , "", "", "", "");
				
				Strategy fs = new OlderThan25Strategy();
				
			
				assertFalse(fs.meetsCriteria(under25));
			}
	}
