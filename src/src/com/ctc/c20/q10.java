package src.com.ctc.c20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//import src.com.ctc.c20.q10.WordGraph.Node;

//import src.com.algorithms.Graph.Graph.Node;

public class q10 {
	
	public static class Node {
		private String word;
		LinkedList<Node> adj = new LinkedList<Node>();
		
		private Node(String word) {
			this.word  = word;
		}
	}
	static class WordGraph{
		private HashMap<String, Node> wordMap = new HashMap<String, Node>();
		
		public Node getNode(String word){
			return this.wordMap.get(word);
		}
		
		public void addWordPath(String source, String dest){
			Node src = this.getNode(source);
			Node destin = this.getNode(dest);
			src.adj.add(destin);
		}
		
		public void addWord(String wrd){
			Node newNode = new Node(wrd);
			this.wordMap.put(wrd, newNode);
		}
	}
	
	public static void getSubWords(WordGraph wg, String source, HashSet<String> dict){
		for(int i=0; i<source.length(); i++){
			char[] wordArr = source.toCharArray();
			for(char c='A'; c<='Z'; c++){
				wordArr[i] = c;
				String tst = new String(wordArr);
				if(!dict.contains(tst)){
					continue;
				}
				if(wg.getNode(tst) == null)
					wg.addWord(tst);
				wg.addWordPath(source, tst);
				//Recursive call
				getSubWords(wg, tst, dict);
			}
		}
	}
	
	public static WordGraph buildGraph(HashSet<String> dict, String source){
		WordGraph dictGraph = new WordGraph();
		if(dictGraph.getNode(source) == null){
			//Insert the first word
			dictGraph.addWord(source);
		}
		//Now add all the words with the same length.
		for(int i=0; i<source.length(); i++){
			char[] wordArr = source.toCharArray();
			for(char c='A'; c<='Z'; c++){
				wordArr[i] = c;
				String tst = new String(wordArr);
				if(!dict.contains(tst)){
					//getSubWords(dictGraph, wordArr.toString(), dict);
					continue;
				}
				if(dictGraph.getNode(tst) == null)
					dictGraph.addWord(tst);
				dictGraph.addWordPath(source, tst);
				//getSubWords(dictGraph, tst, dict);
			}
		}
		return dictGraph;
	}
	
	public static void convert(String sourceL, String destL, HashSet<String> dict){
		String source = sourceL.toUpperCase();
		String dest = destL.toUpperCase();
		//Build the a graph based on source
		WordGraph wG = buildGraph(dict, source);
		
		//Do a BFS in the graph based on source and dest
		Node src = wG.getNode(source);
		Node destin = wG.getNode(dest);
		LinkedList<Node> nextNode = new LinkedList<Node>();
		ArrayList<String> visited = new ArrayList<String>();
		nextNode.add(src);
		while(!nextNode.isEmpty()){
			Node node = nextNode.remove();
			if(node == destin){
				displayPath(visited);
				return;
			}
			if(visited.contains(node.word))
				continue;
			visited.add(node.word);
			for(Node child: node.adj){
				nextNode.add(child);
			}
		}
		System.out.println("Not possible");
	}
	
	public static void displayPath(ArrayList <String> path){
		for(String wrd: path){
			System.out.print(wrd+"->");
		}
	}
	
	
	public static void main(String[] args){
		HashSet<String> dict = new HashSet<String>();
		dict.add("LAMP");
		dict.add("DAMP");
		dict.add("CAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
		dict.add("PMPO");
		dict.add("CORD");
		dict.add("DOOR");
		dict.add("COOL");
		dict.add("HILL");
		dict.add("STOP");
		dict.add("POMP");
		dict.add("RAMP");
		
		convert("damp", "like", dict);
		
		
		
	}

}
