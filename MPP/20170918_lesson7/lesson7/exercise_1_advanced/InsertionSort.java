package lesson7.exercise_1_advanced;

public class InsertionSort {
	public MyStringList sort(MyStringList aList) {
		  if(aList == null || aList.size() <= 1) {
			return aList;
		  }
		  int len = aList.size();
		  String temp = aList.get(0);
		  int j = 0;
		  for(int i = 1; i < len; ++i) {
		    temp = aList.get(i);
		    j=i;
		    while(j>0 && temp.compareTo(aList.get(j-1))<0){
		    	aList.copy(j-1, j);
		        j--;
		    }
		    aList.overwrite(temp, j);
		    
		  }
		  return aList;
	}
}
