package edu.usu.cs.filter.strategy;

import edu.usu.cs.filter.person.Person;

public class IsFemaleStrategy extends Strategy{

	@Override
	public boolean meetsCriteria(Person p) {
		
		if(p.getGender().length() > 0)
			return p.getGender().toUpperCase().charAt(0) == 'F';
		
		return false;
	}
}
