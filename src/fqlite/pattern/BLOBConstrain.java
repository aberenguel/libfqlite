package fqlite.pattern;

public class BLOBConstrain implements Constraint {

	@Override
	public boolean match(int value) {
		
		/* NULL (serial type 0) or an even serial type >= 12 (12 is the empty BLOB) */
		if (value == 0 || ((value % 2 == 0) && (value >= 12)))
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		return "00|>=12";
	}

}
