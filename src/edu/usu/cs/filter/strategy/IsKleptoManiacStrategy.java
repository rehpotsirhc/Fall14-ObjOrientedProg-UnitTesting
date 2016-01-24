package edu.usu.cs.filter.strategy;

import edu.usu.cs.filter.person.Person;

public class IsKleptoManiacStrategy extends Strategy{

	@Override
	public boolean meetsCriteria(Person p) {
		String[] questions = p.getQuestions();
		return questions[0].equals("1") && questions[1].equals("0") && questions[3].equals("1");
	}
	 
	

}
