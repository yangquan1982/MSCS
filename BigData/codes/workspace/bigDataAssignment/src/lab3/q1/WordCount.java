package lab3.q1;

public class WordCount {
	private int m;
	private int r;
	private Mapper[] mappers;
	private Reducer[] reducers;
	public WordCount(int m, int r) {
		this.m = m;
		this.r = r;
		mappers = new Mapper[m];
		reducers = new Reducer[r];
	}
	public int getPartition(String key){
		return (int) (key.hashCode() % this.r);
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Mapper[] getMappers() {
		return mappers;
	}
	public void setMappers(Mapper[] mappers) {
		this.mappers = mappers;
	}
	public Reducer[] getReducers() {
		return reducers;
	}
	public void setReducers(Reducer[] reducers) {
		this.reducers = reducers;
	}
	public void addMapper(Mapper mapper){
		int i=0;
		while(i<m && mappers[i]!=null){
			i++;
		}
		if(i<m){
			mappers[i]=mapper;
		}
	}
	public void addReducer(Reducer reducer){
		int i=0;
		while(i<r && reducers[i]!=null){
			i++;
		}
		if(i<r){
			reducers[i]=reducer;
		}
	}
}