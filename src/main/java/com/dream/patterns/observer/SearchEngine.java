package com.dream.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

	private List<Searcher> searcherList = new ArrayList<Searcher>();

	public void addSearcher(Searcher searcher) {
		searcherList.add(searcher);
	}

	public List<String> searcher() {
		List<String> list = new ArrayList<String>();
		for(Searcher sercher : searcherList){
			String result = sercher.search();
			list.add(result);
		}
		return list;
	}

}
