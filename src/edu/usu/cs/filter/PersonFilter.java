package edu.usu.cs.filter;

import java.util.LinkedList;
import java.util.List;

import edu.usu.cs.filter.person.Person;
import edu.usu.cs.filter.strategy.Strategy;

public class PersonFilter {
	
	Strategy strategy;
	
	public PersonFilter(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	public boolean meetsCriteria(Person person)
	{
			return strategy.meetsCriteria(person);
	}
	

	public List<Person> getFilteredList(List<Person> persons)
	{
		List<Person> filtered = new LinkedList<Person>();
		
		for (int i = 0; i < persons.size(); ++i) {
			if (meetsCriteria(persons.get(i))) {
				filtered.add(persons.get(i));		
			}
		}		
		
		return filtered;
	}
	
	/*
	 * Changed so the denominator in the percent change expression is the original list size
	 * When this is 0, returns a string saying so
	 */
	public String getFilterStatistics(List<Person> originalList)
	{
		
		double orgSize = originalList.size();
		
		if(orgSize < 1) return "List is empty. Nothing to Filter";
		
		List<Person> filteredList = getFilteredList(originalList);
		double percentChange = 1.0 - (double)filteredList.size() / orgSize;
		StringBuilder sb = new StringBuilder();
		sb.append("Old list had " + originalList.size() + " people in it\r\n"); 
		sb.append("New list has " + filteredList.size() + " people in it\r\n");
		sb.append(String.format("%.2f%% of people were filtered out", percentChange * 100));
		
		return sb.toString();
	}
}
