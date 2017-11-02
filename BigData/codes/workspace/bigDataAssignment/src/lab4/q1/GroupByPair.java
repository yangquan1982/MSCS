package lab4.q1;

import java.util.ArrayList;
import java.util.List;

public class GroupByPair {
	private String key;
	private List<Integer> values;
	public GroupByPair(String key) {
		this.key = key;
		this.values = new ArrayList<>();
	}
	public GroupByPair(String key, List<Integer> values) {
		this.key = key;
		this.values = values;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Integer> getValues() {
		return values;
	}
	public void setValues(List<Integer> values) {
		this.values = values;
	}
	public void addValue(Integer value){
		this.values.add(value);
	}
	@Override
	public String toString() {
		return "< " + key + " , " + values.toString() + " >\n";
	}
	
}
