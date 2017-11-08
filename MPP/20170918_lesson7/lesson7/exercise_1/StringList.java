package lesson7.exercise_1;

public interface StringList {
	//uncomment these	
//	abstract String[] strArray();
//	abstract int size();
//	abstract void setSize(int s);
	
	/** Adds a string to the end of the list */
	public void add(String s) ;
	
	/** Gets the i_th string in the list */
	public String get(int i) ;
	
}
