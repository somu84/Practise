package src.com.algorithms.Graph;
/**
 * Dijkstra's single source shortest path algorithm computes, 
 * the shortest path from one source vertex to all the other vertices 
 * in a weighted graph.
 * 
 * The only condition is, that none of the edges can be negative.
 * The time complexity of this algorithm is O(E log V)
 * Where V is the number of Vertices and E is the number of edges.
 * 
 *  Dijkstra(G,W,s)
 *  	Initialize(G, s);
 *  	while Q != NULL //Q is the set of vertices in the graph G. S is the set of shortest paths.
 *  		u = ExtractMin(Q); //This will delete a vertex u from Q
 *  		S = S.add(u); //Put u into the set S.
 *  		for each vertex v : Adj(u) //For each vertex v adjacent to u
 *  			Relax (u,v,w);
 *  
 *   Relax(u,v,w)
 *   	if d[v] > d[u] + w(u,v) //d[v] is the current length of the shortest from from u to v. W(u,v) is the weight of the connecting u and v
 *   		d[v] = d[u] + w(u,v);
 *   		P[v] = u ; //P[v] is the predecessor list. Here we assign u to be the predecessor of vertex v.
 *   
 * @author somu
 *
 */
public class DijkstraShortestPath {

	public static void calcSP(Graph g){
		//g is a weighted graph
		
	}
}
