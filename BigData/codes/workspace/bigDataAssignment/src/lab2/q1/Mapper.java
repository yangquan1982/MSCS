package lab2.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapper {
	@SuppressWarnings("unchecked")
	private <T> ArrayList<T> getWords(T SInput){
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
	@SuppressWarnings({ "unchecked", "finally" })
	public <T> List<T> map(String filePath){
		BufferedReader br = null;
		FileReader fr = null;
		List<Pair> pairList = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String sCurrentLine;
			ArrayList<String> allWordsList = null;
			pairList = new ArrayList<>();
			String strText = "";
			while((sCurrentLine = br.readLine()) != null){
				strText += sCurrentLine + " ";
			}
			allWordsList = getWords(strText);
			for(String word:allWordsList){
				pairList.add(new Pair(word,1));
			}
			Collections.sort(pairList, (Pair p1, Pair p2) -> p1.getKey().compareTo(p2.getKey()));
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
			return (List<T>) pairList;
		}
	}
}
