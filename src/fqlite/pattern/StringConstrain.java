package fqlite.pattern;

public class StringConstrain implements Constraint {

	int max = Integer.MAX_VALUE;
	
	public StringConstrain()
	{}
	
	public StringConstrain(int max)
	{
		this.max = max*2 + 13;
	}
	
	@Override
	public boolean match(int value) {

		/* NULL (serial type 0) is valid for any column without NOT NULL */
		if (value == 0)
			return true;
		/* odd serial types >= 13 are TEXT values, 13 is the empty string */
		if (value >= 13 && value % 2 != 0 && value <= max)
				return true;
		return false;
	}
	
	@Override
	public String toString(){
		return "00|>=13";
	}
	

}
