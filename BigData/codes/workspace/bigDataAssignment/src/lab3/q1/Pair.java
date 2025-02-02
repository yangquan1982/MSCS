package lab3.q1;

public class Pair {
	private String key;
	private int value;
	public Pair(String key, int value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "< " + key + " , " + value + " >\n";
	}
}
