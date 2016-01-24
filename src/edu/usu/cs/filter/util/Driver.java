package edu.usu.cs.filter.util;

import java.util.ArrayList;
import java.util.List;

import edu.usu.cs.filter.PersonFilter;
import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.Strategy;

public class Driver {

	public static void main(String[] args)
	{
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(new Person("Bob", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		personList.add(new Person("Mike", "Costa", "Male", 15, "bday", "1", "2", "3", "4"));
		
		PersonFilter pf = new PersonFilter(new Strategy() {public boolean meetsCriteria(Person p) {return p.getFirstName().equals("Bob");}});
		String  s = pf.getFilterStatistics(personList);
		
		System.out.println(s);
	}
}
