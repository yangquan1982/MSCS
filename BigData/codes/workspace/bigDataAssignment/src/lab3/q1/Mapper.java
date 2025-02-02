package lab3.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

	@SuppressWarnings("unchecked")
	private <T> ArrayList<T> getWords(T SInput){
		if (SInput==null) {
			return null;
		}
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
		        if(charAt.equals(',')
		        		|| charAt.equals('"')
		        		|| charAt.equals('\'')
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
	@SuppressWarnings({ "unchecked", "resource" })
	public <T> List<T> map(Path filePath){
		if (filePath==null) {
			return null;
		}
		BufferedReader br = null;
		List<Pair> pairList = null;
		try (FileReader fr = new FileReader(filePath.toString())){
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
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return (List<T>) pairList;
	}
}
