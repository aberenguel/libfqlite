package fqlite.pattern;

public class IntegerConstraint implements Constraint {

	int min = 0;  
	int max = 6;
	
	public IntegerConstraint(boolean notNull)
	{
		if (notNull)
			min = 1;
	}
	
	@Override
	public boolean match(int value) {
		
		/*
		 * Serial types 8 and 9 are the integer constants 0 and 1 (schema format 4,
		 * the default since SQLite 3.7). They are valid for any INTEGER column, also
		 * for NOT NULL columns, so they must not break the header pattern.
		 */
		if ((value <= max  && value >= min) || value == 8 || value == 9)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "0" + min + "..06 OR 08|09";
	}


}
