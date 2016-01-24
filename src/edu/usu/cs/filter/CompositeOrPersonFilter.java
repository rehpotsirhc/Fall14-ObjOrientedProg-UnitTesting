package edu.usu.cs.filter;

import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.Strategy;

public class CompositeOrPersonFilter extends PersonFilter {

	PersonFilter first;
	PersonFilter second;
	
	@Deprecated
	public CompositeOrPersonFilter(Strategy strategy) {
		super(strategy);
	}
	
	public CompositeOrPersonFilter(PersonFilter one, PersonFilter two)
	{
		super(null);
		this.first = one;
		this.second = two;
	}
	
	@Override
	public boolean meetsCriteria(Person p)
	{
		return first.meetsCriteria(p) || second.meetsCriteria(p);
	}
}
