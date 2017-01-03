package src.com.algorithms.Graph;
/**
 * This class is used to test the various methods of the Graph class.
 * Including the BFS and DFS methods.
 * @author somu
 *
 */
public class TestGraphs {

	public static void main(String[] args) {
		Graph g  = createGraph();
		if(g == null){
			System.out.println("Graph could not be created");
			return;
		}
		System.out.println("Graph created successfuly");
		
		//Check the DFS Scenarios
		if(testDFS(g))
			System.out.println("DFS tested successfully");
		else
			System.out.println("DFS implementation has issues");
		//Check the BFS Scenarios
		if(testBFS(g))
			System.out.println("BFS tested successfully");
		else
			System.out.println("BFS implementation has issues");
	}
	
	/**
	 * This function creates the following un-weighted un-directed graph
	 * 
	 * 4 ---1---2
	 * |        |   7
	 * |        |
	 * 6----5   3
	 * @return
	 */
	private static Graph createGraph()
	{
		Graph g = new Graph();
		//Add all the nodes
		g.addNode(4);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(5);
		g.addNode(6);
		g.addNode(7);
		//Add all the edges
		g.addEdge(4, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(4, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 5);
		g.addEdge(5, 6);
		
		return g;
	}

	/**
	 * 
	 * @param g
	 * @return
	 */
	private static boolean testDFS(Graph g)
	{
		if(g.hasPathDFS(4, 1))
			System.out.println("Test Case 1: Passed");
		else{
			System.out.println("Test Case 1: Failed");
			return false;
		}
		if(g.hasPathDFS(1, 4))
			System.out.println("Test Case 2: Passed");
		else{
			System.out.println("Test Case 2: Failed");
			return false;
		}
		if(g.hasPathDFS(5, 3))
			System.out.println("Test Case 3: Passed");
		else{
			System.out.println("Test Case 3: Failed");
			return false;
		}
		if(g.hasPathDFS(3, 5))
			System.out.println("Test Case 4: Passed");
		else{
			System.out.println("Test Case 4: Failed");
			return false;
		}
		if(!g.hasPathDFS(7, 5))
			System.out.println("Test Case 5: Passed");
		else{
			System.out.println("Test Case 5: Failed");
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param g
	 * @return
	 */
	private static boolean testBFS(Graph g)
	{
		if(g.hasPathBFS(4, 1))
			System.out.println("Test Case 1: Passed");
		else{
			System.out.println("Test Case 1: Failed");
			return false;
		}
		if(g.hasPathBFS(1, 4))
			System.out.println("Test Case 2: Passed");
		else{
			System.out.println("Test Case 2: Failed");
			return false;
		}
		if(g.hasPathBFS(5, 3))
			System.out.println("Test Case 3: Passed");
		else{
			System.out.println("Test Case 3: Failed");
			return false;
		}
		if(g.hasPathBFS(3, 5))
			System.out.println("Test Case 4: Passed");
		else{
			System.out.println("Test Case 4: Failed");
			return false;
		}
		if(!g.hasPathBFS(7, 5))
			System.out.println("Test Case 5: Passed");
		else{
			System.out.println("Test Case 5: Failed");
			return false;
		}
		return true;
	}
}
