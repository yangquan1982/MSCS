package lesson7.exercise_1_advanced;

public interface StringList {
	//uncomment these
	
//	abstract String[] strArray();
//	abstract int size();
//	abstract void setSize(int val);
//	abstract void resize();
//	abstract void overwrite(String val, int pos);
//	abstract boolean copy(int pos1, int pos2);
	
	/** Adds a string to the end of the list */
	public void add(String s) ;
	
	/** Gets the i_th string in the list */
	public String get(int i) ;

	/** Returns true of String s is found in the list, false otherwise */
	public boolean find(String s);

	/** Inserts String s into position pos, moving elements to the right as needed */
	public void insert(String s, int pos);

	/** Removes first occurrence of s if found and returns true; if not found, returns false */
	public boolean remove(String s);

	
}
