package lab4.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try (Stream<Path> paths = Files.walk(Paths.get("src"))) {
			/*Read files and output contents by file*/
			List<Path> inputFiles = 
		    paths
		        .filter(path -> {
		        	return String.valueOf(path).endsWith(".dat");})
		        .collect(Collectors.toList());
			System.out.println("Number of Input-Splits: "+inputFiles.size());
			int reducerNum = 4;
			System.out.println("Number of Reducers: "+reducerNum);
			for(int i=0;i<inputFiles.size();i++){
				System.out.println("Mapper "+i+" Input");
				BufferedReader br = null;
				FileReader fr = null;
				fr = new FileReader(inputFiles.get(i).toString());
				br = new BufferedReader(fr);
				String sCurrentLine;
				while((sCurrentLine = br.readLine()) != null){
					System.out.println(sCurrentLine);
				}
			}
			
			/*Output map results by Mapper*/
			WordCount wordCount = new WordCount(inputFiles.size(),reducerNum);
			Map<Integer,List<Pair>> mapperOutputs = wordCount.map(inputFiles);
			wordCount.setMapperOutputs(mapperOutputs);
			/*Output shuffle results and reducer inputs by reducer*/
			wordCount.shuffle();
			/*Output reduce results by reducer*/
			wordCount.reduce();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
