package src.com.algorithms.Graph;
/*
 * This is class is used to define an edge in a graph.
 * An edge consists of an ordered pair of vertices. 
 * In case of an un-directed graph, it consists of an un-ordered pair.
 * 
 * In case of weighted graphs, the edge will also have a weight associated to it.
 * For an un-weihted graph, we can assume the weight to be 0.
 */
public class Edge {

	String startVertex;
	String endVertex;
	int weight;
}
