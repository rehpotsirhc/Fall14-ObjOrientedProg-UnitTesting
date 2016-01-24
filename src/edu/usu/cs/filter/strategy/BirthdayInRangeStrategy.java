package edu.usu.cs.filter.strategy;


import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import edu.usu.cs.filter.person.Person;


public class BirthdayInRangeStrategy extends Strategy{

	LocalDate start;
	LocalDate end;
	DateTimeFormatter dateStringFormat;
	
	public BirthdayInRangeStrategy(String start, String end)
	{
		
		dateStringFormat = DateTimeFormat.forPattern("M/D/YYYY");

		this.start = dateStringFormat.parseLocalDate(start);
		this.end = dateStringFormat.parseLocalDate(end);
	}
	
	@Override
	public boolean meetsCriteria(Person p) {
	
		String sBday = p.getBirthday();
		if(sBday != null && !sBday.isEmpty())
			{
				LocalDate bday = dateStringFormat.parseLocalDate(sBday);
				return (!bday.isBefore(start) && !bday.isAfter(end));
			}
		
		return false;
		
		
		
	}
}
