package src.com.algorithms.Graph;

import java.util.ArrayList;

/*
 * This is an Array List representation of a graph in Java.
 * In this form of representation. A graph can be denoted with the help of two array lists.
 * One for the set of vertices and the other for the set of edges.
 * 
 * Set of vertices can just be a String Array List.
 * For the edges, we have a separate class defined in this package.
 */

/*************************************************************************
 * 
 * 
 * This sort of representation is very in-efficient as common operations take
 * O(|E|) time. Which is total number of edges. 
 * Where the maximum number of possible edges in a Graph with 'n' vertices will be:
 * n(n -1) and for an un-directed graph it will be n(n-1)/2
 * 
 * Which is O(n^2), therefore it is not very efficient.
 ***************************************************************************/

/*
 * For an efficient way of representing a graph, please refer to the other class.
 * Also check out the Graph videos:
 * 
 * https://www.youtube.com/watch?v=ZdY1Fp9dKzs
 * 
 */

public class Graph_ArrayList_Impl {
	//List of vertices
	ArrayList<String> vertices;
	//List of edges
	ArrayList<Edge> edges;
	
	/*******************************************
	 * Following are the operations in a graph.
	 *******************************************
	 */
	
	//Find all nodes (vertices) adjacent to a given node.
	
	//Depth First Search
	
	//Breadth First Search
	
	//Graph Traversal
}
