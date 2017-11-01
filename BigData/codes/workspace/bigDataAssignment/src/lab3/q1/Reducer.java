package lab3.q1;

import java.util.ArrayList;
import java.util.List;

public class Reducer {
	public List<Pair> reduce(List<GroupByPair> input){
		List<Pair> output = new ArrayList<>();
		for(GroupByPair gbp:input){
			int sum = 0;
			for(Integer v:gbp.getValues()){
				sum += v;
			}
			output.add(new Pair(gbp.getKey(), sum));
		}
		return output;
	}
}
