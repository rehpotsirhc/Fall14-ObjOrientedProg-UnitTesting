package edu.usu.cs.filter.strategy;

import edu.usu.cs.filter.person.Person;

public class FirstHalfNamesStrategy extends Strategy{

	@Override
	public boolean meetsCriteria(Person p) {
		return p.getFirstName().toUpperCase().charAt(0) < 'N' && p.getLastName().toUpperCase().charAt(0) < 'N';
	}

}
