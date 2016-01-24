package edu.usu.cs.filter.strategy;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.IsFemaleStrategy;
import edu.usu.cs.filter.strategy.Strategy;

public class IsFemaleStrategyTest
	{
		@Test
		public void shouldOnlyMatchFemale()
			{
				Strategy fs = new IsFemaleStrategy();
				
				Person MsDoe = new Person("Jane", "Doe", "Female", -1, "" , "", "", "", "");
				Person MrDoe = new Person("Jack", "Doe", "Male", -1, "" , "", "", "", "");
				
				assertTrue(fs.meetsCriteria(MsDoe));
				assertFalse(fs.meetsCriteria(MrDoe));
				
			}
	
	}
