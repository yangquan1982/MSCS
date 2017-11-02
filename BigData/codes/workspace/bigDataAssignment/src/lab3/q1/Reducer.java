package lab3.q1;

import java.util.List;
import java.util.stream.Collectors;

public class Reducer {
	public List<Pair> reduce(List<GroupByPair> input){
		if (input==null) {
			return null;
		}
		return input.stream().map(
				p -> new Pair(
						p.getKey(),
						p.getValues().stream()
						.mapToInt(x -> x).sum()))
						.collect(Collectors.toList());
	}
}
