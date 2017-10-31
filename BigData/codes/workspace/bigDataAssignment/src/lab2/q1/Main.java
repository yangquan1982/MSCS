package lab2.q1;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Mapper mapper = new Mapper();
		Shuffle shuffle = new Shuffle();
		Reducer reducer = new Reducer();
		String filePath = "src/testDataForW1D1.txt";
		List<GroupByPair> reducerInput = shuffle.shuffle(mapper.map(filePath));
		//mapper.map(filePath).stream().forEach(System.out::print);
		reducer.reduce(reducerInput).stream().forEach(System.out::print);
	}

}
