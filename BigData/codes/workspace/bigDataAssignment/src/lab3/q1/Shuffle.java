package lab3.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle {
	public static List<GroupByPair> shuffle(List<Pair> input){
		if(input==null){
			return null;
		}
		Collections.sort(input, (p1,p2) -> p1.getKey().compareTo(p2.getKey()));
		List<GroupByPair> output = new ArrayList<>();
		GroupByPair gbp = new GroupByPair(input.get(0).getKey());
		output.add(gbp);
		for(Pair p:input){
			if(gbp.getKey().equals(p.getKey())){
				gbp.addValue(p.getValue());
			} else{
				gbp = new GroupByPair(p.getKey());
				gbp.addValue(p.getValue());
				output.add(gbp);
			}
		}
		return output;
	}
}
