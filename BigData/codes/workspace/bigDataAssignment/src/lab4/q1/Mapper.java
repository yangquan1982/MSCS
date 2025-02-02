package lab4.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Mapper {

	private Map<String,Integer> hMapperOutput;
	public void setUp(){
		if(hMapperOutput==null){
			hMapperOutput = new HashMap<>();
		}
	}
	public List<Pair> cleanUp(){
		if(hMapperOutput!=null){
			return hMapperOutput.entrySet()
					.stream()
					.map(e -> new Pair(e.getKey(),e.getValue()))
					.collect(Collectors.toList());
		}
		return null;
	}
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void map(Path filePath){
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
			Map<String, List<Pair>> hMap = pairList.stream().collect(Collectors
					.groupingBy(Pair::getKey));
			int sum = 0;
			for(Entry e:hMap.entrySet()){
				for(Pair p:(List<Pair>) e.getValue()){
					sum += p.getValue();
				}
				hMapperOutput.put((String) e.getKey(), sum);
				sum = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
