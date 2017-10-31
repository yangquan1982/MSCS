package lab2.q1;

import java.util.ArrayList;
import java.util.List;

import lab1.Pair;

public class Shuffle {
	public List<GroupByPair> shuffle(List<Pair> input){
		List<GroupByPair> out = new ArrayList<>();
		List<Integer> value = new ArrayList<>();
		out.add(new GroupByPair(input.get(0).getKey(), value));
		for(Pair p:input){
			if(out.get(out.size()-1).getKey().equals(p.getKey())){
				value.add(p.getValue());
			} else{
				value = new ArrayList<>();
				value.add(p.getValue());
				out.add(new GroupByPair(p.getKey(), value));
			}
		}
		return out;
	}
}
