package lab2.q1;

import java.util.ArrayList;
import java.util.List;

public class Reducer {
	public List<Pair> reduce(List<GroupByPair> input){
		List<Pair> out = new ArrayList<>();
		for(GroupByPair gbp:input){
			int sum = 0;
			for(Integer v:gbp.getValue()){
				sum += v;
			}
			out.add(new Pair(gbp.getKey(), sum));
		}
		return out;
	}
}
