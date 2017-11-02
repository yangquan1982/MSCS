package lab4.q1;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
	private int m;
	private int r;
	private Mapper[] mappers;
	private Reducer[] reducers;
	private Map<Integer,List<Pair>> mapperOutputs;
	private Map<Integer,List<GroupByPair>> reducerInputs;
	private Map<Integer,List<Pair>> reducerOutputs;
	
	public Map<Integer, List<Pair>> getReducerOutputs() {
		return reducerOutputs;
	}
	public void setReducerOutputs(Map<Integer, List<Pair>> reducerOutputs) {
		this.reducerOutputs = reducerOutputs;
	}
	public WordCount(int m, int r) {
		this.m = m;
		this.r = r;
		mappers = new Mapper[m];
		reducers = new Reducer[r];
		mapperOutputs = new HashMap<>();
		reducerInputs = new HashMap<>();
		reducerOutputs = new HashMap<>();
	}
	private int getPartition(String key){
		return (int) (Math.abs(key.hashCode()) % this.r);
	}
	public Map<Integer,List<Pair>> map(List<Path> filePathList){
		if (filePathList==null) {
			return null;
		}
		if (mapperOutputs==null) {
			mapperOutputs = new HashMap<>();
		}
		for (int i = 0; i < m; i++) {
			System.out.println("Mapper "+i+" Output");
			addMapper(new Mapper());
			mappers[i].setUp();
			mappers[i].map(filePathList.get(i));
			List<Pair> value = mappers[i].cleanUp();
			mapperOutputs.put(i, value);
			value.forEach(System.out::print);
		}
		return mapperOutputs;
	}
	public void shuffle(){
		Map<Map<Integer,Integer>,List<Pair>> shuffleResult = new HashMap<>();
		Map<Integer,Integer> kMRId = null;
		List<Pair> vShuffleList = null;
		for (int mapperId = 0; mapperId < m; mapperId++) {
			for (int reducerId = 0; reducerId < r; reducerId++) {
				kMRId = new HashMap<>();
				kMRId.put(mapperId, reducerId);
				vShuffleList = new ArrayList<>();
				for (Pair p : mapperOutputs.get(mapperId)) {
					if (getPartition(p.getKey())==reducerId) {
						vShuffleList.add(p);
					}
				}
				Collections.sort(vShuffleList, (p1,p2) -> p1.getKey().compareTo(p2.getKey()));
				shuffleResult.put(kMRId, vShuffleList);
				System.out.println("Pairs send from Mapper "+mapperId+" Reducer "+reducerId);
				vShuffleList.forEach(System.out::print);
			}
		}
		List<Pair> pairListByReducer = null;
		List<GroupByPair> gbpListByReducer = null;
		if (reducerInputs==null) {
			reducerInputs = new HashMap<>();
		}
		for (int rId = 0; rId < r; rId++) {
			pairListByReducer = new ArrayList<>();
			gbpListByReducer = new ArrayList<>();
			for (Map.Entry<Map<Integer,Integer>, List<Pair>> resultEntry : shuffleResult.entrySet()) {
				for (Map.Entry<Integer,Integer> mrEntry : resultEntry.getKey().entrySet()) {
					if (mrEntry.getValue()==rId) {
						for (Pair p : resultEntry.getValue()) {
							pairListByReducer.add(p);
						}
					}
				}
			}
			Collections.sort(pairListByReducer, (p1,p2) -> p1.getKey().compareTo(p2.getKey()));
			GroupByPair gbp = new GroupByPair(pairListByReducer.get(0).getKey());
			gbpListByReducer.add(gbp);
			for(Pair p:pairListByReducer){
				if(gbp.getKey().equals(p.getKey())){
					gbp.addValue(p.getValue());
				} else{
					gbp = new GroupByPair(p.getKey());
					gbp.addValue(p.getValue());
					gbpListByReducer.add(gbp);
				}
			}
			System.out.println("Reducer "+rId+" input");
			gbpListByReducer.forEach(System.out::print);
			reducerInputs.put(rId, gbpListByReducer);
		}
	}
	public Map<Integer,List<Pair>> reduce() {
		if (reducerOutputs==null) {
			reducerOutputs = new HashMap<>();
		}
		for (int i = 0; i < r; i++) {
			addReducer(new Reducer());
		}
		List<Pair> pairList = null;
		for (Map.Entry<Integer,List<GroupByPair>> entry : reducerInputs.entrySet()) {
			System.out.println("Reducer "+entry.getKey()+" output");
			pairList = reducers[entry.getKey()].reduce(entry.getValue());
			pairList.forEach(System.out::print);
			reducerOutputs.put(entry.getKey(), pairList);
		}
		return reducerOutputs;
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
	private void addMapper(Mapper mapper){
		int i=0;
		while(i<m && mappers[i]!=null){
			i++;
		}
		if(i<m){
			mappers[i]=mapper;
		}
	}
	private void addReducer(Reducer reducer){
		int i=0;
		while(i<r && reducers[i]!=null){
			i++;
		}
		if(i<r){
			reducers[i]=reducer;
		}
	}
	public Map<Integer, List<Pair>> getMapperOutputs() {
		return mapperOutputs;
	}
	public void setMapperOutputs(Map<Integer, List<Pair>> mapperOutputs) {
		this.mapperOutputs = mapperOutputs;
	}
	public Map<Integer, List<GroupByPair>> getReducerInputs() {
		return reducerInputs;
	}
	public void setReducerInputs(Map<Integer, List<GroupByPair>> reducerInputs) {
		this.reducerInputs = reducerInputs;
	}
}
