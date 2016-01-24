package edu.usu.cs.filter.strategy;

import edu.usu.cs.filter.person.Person;


public abstract class Strategy {

	public abstract boolean meetsCriteria(Person p);
	
}
