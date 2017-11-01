package lab2.q1;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Mapper mapper = new Mapper();
		Shuffle shuffle = new Shuffle();
		Reducer reducer = new Reducer();
		String filePath = "src/testDataForW1D1.txt";
		List<GroupByPair> reducerInput = shuffle.shuffle(mapper.map(filePath));
		System.out.println("\nMapper Output\n");
		mapper.map(filePath).stream().forEach(System.out::print);
		System.out.println("\nReducer Input\n");
		reducerInput.stream().forEach(System.out::print);
		System.out.println("\nReducer Output\n");
		reducer.reduce(reducerInput).stream().forEach(System.out::print);
	}
}
