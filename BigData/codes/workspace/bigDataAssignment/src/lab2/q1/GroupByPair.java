package lab2.q1;

import java.util.ArrayList;
import java.util.List;

public class GroupByPair {
	private String key;
	private List<Integer> value;
	public GroupByPair(String key, List<Integer> value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Integer> getValue() {
		return value;
	}
	public void setValue(List<Integer> value) {
		this.value = value;
	}
	public void addValueItem(Integer item){
		if(value==null){
			value = new ArrayList<>();
		}
		value.add(item);
	}
	@Override
	public String toString() {
		return "<" + key + ", " + value.toString() + ">\n";
	}
	
}
