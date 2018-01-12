package com.dream.patterns.observer;

import java.util.List;

public class SearcherTest {

	public static void main(String[] args) {
		
		SearchEngine searchEngine = new SearchEngine();
		NameSearcher nameSearcher = new NameSearcher();
		AgeSearcher ageSearcher  = new AgeSearcher();
		
		searchEngine.addSearcher(ageSearcher);
		searchEngine.addSearcher(nameSearcher);
		
		List<String> list = searchEngine.searcher();
		
		for(String str : list){
			
			System.out.println("search:"+str);
		}
	}

}
