package lab3.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try (Stream<Path> paths = Files.walk(Paths.get("src"))) {
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
			Mapper mapper0 = new Mapper();
			for(int i=0;i<inputFiles.size();i++){
				System.out.println("Mapper "+i+" Output");
				mapper0.map(inputFiles.get(i)).stream().forEach(System.out::print);
			}
			WordCount wordCount = new WordCount(inputFiles.size(),reducerNum);
			Mapper mapper = null;
			Reducer reducer = null;
			List<Pair> mapperOutput = null;
			for(int i=0;i<inputFiles.size();i++){
				mapper = new Mapper();
				wordCount.addMapper(mapper);
				mapperOutput = mapper.map(inputFiles.get(i));
				Collections.sort(mapperOutput, 
						(Pair p1, Pair p2) -> p1.getKey()
						.compareTo(p2.getKey()));
				for(int j=0;j<reducerNum;j++){
					reducer = new Reducer();
					wordCount.addReducer(reducer);
					System.out.println("Pairs send from Mapper "+i+" Reducer "+j);
					for(Pair p:mapperOutput){
						if(wordCount.getPartition(p.getKey())==j){
							System.out.print(p);
						}
					}
				}
			}
			List<List<Pair>> mapperOutputs = new ArrayList<>();
			for(int i=0;i<inputFiles.size();i++){
				mapperOutputs.add(wordCount.getMappers()[i].map(inputFiles.get(i)));
			}
			List<Pair> shuffleInputs = null;
			List<List<GroupByPair>> reducerInputs = new ArrayList<>();
			for(int i=0;i<reducerNum;i++){
				System.out.println("Reducer "+i+" input");
				shuffleInputs = new ArrayList<>();
				for(int j=0;j<inputFiles.size();j++){
					for(Pair p:mapperOutputs.get(j)){
						if(wordCount.getPartition(p.getKey())==i){
							shuffleInputs.add(p);
						}
					}
				}
				reducerInputs.add(Shuffle.shuffle(shuffleInputs));
				reducerInputs.get(i).stream().forEach(System.out::print);
			}
			for(int i=0;i<reducerNum;i++){
				System.out.println("Reducer "+i+" output");
				wordCount.getReducers()[i]
						.reduce(reducerInputs.get(i))
						.stream().forEach(System.out::print);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
