package edu.usu.cs.filter.strategy;

import edu.usu.cs.filter.person.Person;

public class OlderThan25Strategy extends Strategy{

	@Override
	public boolean meetsCriteria(Person p) {
		return p.getAge() > 25;
	}

}
