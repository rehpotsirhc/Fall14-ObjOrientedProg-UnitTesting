package edu.usu.cs.filter;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import edu.usu.cs.filter.strategy.*;






@RunWith(Suite.class)
@SuiteClasses({ CompositeAndOrPersonFilterTest.class, OlderThan25StrategyTest.class, PersonFilterTest.class, BirthdayInRangeStrategyTest.class,
	FirstHalfNamesStrategyTest.class, IsFemaleStrategyTest.class, IsKleptoManiacStrategyTest.class, OlderThan25StrategyTest.class
})
public class AllTests
	{
		
	}
