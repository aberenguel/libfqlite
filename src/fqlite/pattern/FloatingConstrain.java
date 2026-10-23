package fqlite.pattern;

public class FloatingConstrain implements Constraint {

   
	
	@Override
	public boolean match(int value) {
	
		/*
		 * NULL, an IEEE 754 float (7) or an integer (1..6, 8, 9): SQLite stores REAL
		 * values without fractional part in columns with REAL affinity as integers.
		 */
		if (value >= 0 && value <= 9)
			return true;
		else 
			return false;
	}
	
	@Override
	public String toString(){
		return "00..09";
	}

}
