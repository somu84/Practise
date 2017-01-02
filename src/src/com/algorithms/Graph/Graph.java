package src.com.algorithms.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Graph implementation as an adjacency list.
 * This graph implementation assumes, that the vertices are integers.
 * 
 * 
 * Please refer to the following lectures:
 * 
 * https://www.youtube.com/watch?v=zaBhtODEL0w
 * 
 * @author somu
 *
 */
public class Graph {
	
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	/**
	 * Class to define the node of the graph.
	 * 
	 *
	 */
	public static class Node {
		private int id;
		LinkedList<Node> adj = new LinkedList<Node>();
		
		private Node(int id) {
			this.id  = id;
		}
	}
	
	/**
	 * Looks up the hash to get the Node from the id.
	 * @param id
	 * @return
	 */
	private Node getNode(int id) {
		Node res = nodeLookup.get(id);
		if(res == null)
			return null;
		return res;
	}
	
	/**
	 * 
	 * @param source
	 * @param dest
	 */
	public void addEdge(int source, int dest) {
		Node s = getNode(source);
		Node d = getNode(dest);
		s.adj.add(d);
	}
	
	/**
	 * TODO 
	 * 
	 */
	public void addNode(int id) {
		
	}
	
	/**
	 * This is the Depth First Search function.
	 * Where it takes as input the source and destination, and 
	 * returns true or false if a path exists from source and destination.
	 * @param source
	 * @param dest
	 * @return
	 */
	public boolean hasPathDFS(int source, int dest) {
		Node s = getNode(source);
		Node d = getNode(dest);
		/**
		 * Learn why we use a hashset instead of a hashmap.
		 * http://beginnersbook.com/2014/08/hashset-vs-hashmap-java/
		 */
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	
	/**
	 * This is a recursive function. Where we recursively search for a path.
	 * @param source
	 * @param dest
	 * @param visited
	 * @return
	 */
	private boolean hasPathDFS(Node source, Node dest, HashSet<Integer> visited) {
		if(visited.contains(source.id))
			return false;
		visited.add(source.id);
		if(source == dest){
			return true;
		}
		for(Node child: source.adj){
			if(hasPathDFS(child, dest, visited)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This is the function for BFS.
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean hasPathBFS(int s, int d) {
		Node source = getNode(s);
		Node destination = getNode(d);
		//List of all the nodes, I have to visit.
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		//Hash of nodes, I have already visited.
		HashSet<Integer> visited = new HashSet<Integer>();
		//Source will be the first node I have to visit.
		nextToVisit.add(source);
		//As long as, there is a node I have to visit.
		while(!nextToVisit.isEmpty()){
			//Remove the node from the list.
			Node node = nextToVisit.remove();
			if(node == destination)
				return true;
		
			if(visited.contains(node.id)) 
				continue;
			//Add the node to the visited hash.
			visited.add(node.id);
			
			for(Node child : node.adj){
				nextToVisit.add(child);
				
			}
		}
		return false;
	}
}
