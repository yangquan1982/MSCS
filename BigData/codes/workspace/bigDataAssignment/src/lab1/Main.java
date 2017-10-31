package lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	private static <T> ArrayList<T> getWords(T SInput){
	    ArrayList<T> allWordsList = new ArrayList<T>();
	    String[] strArray = ((String) SInput).split("\\s|-");
	    String SWord = "";
	    for(int i=0; i<strArray.length; i++){
	    	for(int j=0;j<strArray[i].length();j++){
		        Character charAt = strArray[i].charAt(j);
		        if(Character.isDigit(charAt)
		        		|| (charAt.equals('.') && j<strArray[i].length()-1)
		        		|| charAt.equals('_')){
		        	SWord = "";
		        	break;
		        }
		        if(charAt.equals('"') 
		        		|| charAt.equals(',')
		        		|| charAt.equals('.')){
		        	continue;
		        }
	            SWord += charAt;
	    	}
	    	if(SWord!=""){
	        	String keyWord = new String(SWord);
	        	allWordsList.add((T) keyWord.toLowerCase());
	        	SWord = "";
	    	}
	    }
	    return allWordsList;
	}
	
	public static void main(String[] args) {
		String filePath = "src/testDataForW1D1.txt";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String sCurrentLine;
			ArrayList<String> allWordsList = null;
			String strText = "";
			while((sCurrentLine = br.readLine()) != null){
				strText += sCurrentLine + " ";
			}
			allWordsList = getWords(strText);
			List<Pair> pairList = new ArrayList<>();
			for(String word:allWordsList){
				pairList.add(new Pair(word,1));
			}
			Collections.sort(pairList, (Pair p1, Pair p2) -> p1.getKey().compareTo(p2.getKey()));
		    System.out.println(pairList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}