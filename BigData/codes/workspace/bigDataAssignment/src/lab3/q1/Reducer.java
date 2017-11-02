package lab3.q1;

import java.util.List;
import java.util.stream.Collectors;

public class Reducer {
	public List<Pair> reduce(List<GroupByPair> input){
		if (input==null) {
			return null;
		}
//		List<Pair> output = new ArrayList<>();
		return input.stream().map(
				p -> new Pair(
						p.getKey(),
						p.getValues().stream()
						.mapToInt(x -> x).sum()))
						.collect(Collectors.toList());
//		for(GroupByPair gbp:input){
//			int sum = 0;
//			for(Integer v:gbp.getValues()){
//				sum += v;
//			}
//			output.add(new Pair(gbp.getKey(), sum));
//		}
//		return output;
	}
}
