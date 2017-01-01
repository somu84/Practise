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
public class Graph_ArrayList_Impl {
	//List of vertices
	ArrayList<String> vertices;
	//List of edges
	ArrayList<Edge> edges;
}
