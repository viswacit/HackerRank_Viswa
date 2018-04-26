package com.example.qlikmysql;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class CandidateCode1 {
	
	
	
	static int[] result;
	
	public static void main(String args[] ) throws Exception {

    	int n = 5;
    	int m = 10;
    	
    	Graph g = new Graph(n+1);
    	
    	g.addEdge(3,4);
    	g.addEdge(1,5);
    	g.addEdge(4,2);
    	g.addEdge(5,4);
    	//g.printGraph(g);
    	result = new int[n+1];
    	for(int v=0; v<result.length; v++){
    		result[v] = 0;
    	}
    	
    	int u = 5;
        int v = 4;
        System.out.println("There is a path from " + u +" to " + v);
        //boolean[] visit = g.isReachable(u, v);
        boolean[] visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=5;
        v=4;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=3;
        v=5;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=4;
        v=3;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=4;
        v=3;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=1;
        v=3;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=3;
        v=5;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=5;
        v=4;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=1;
        v=5;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        u=3;
        v=4;
        System.out.println("There is a path from " + u +" to " + v);
        //visit = g.isReachable(u, v);
        visit = g.minEdgeBFS(u,v);
        g.calculateVertex(visit);
        
        int max =0;
        for(int j=1;j<result.length;j++) {
        	if(result[j]>max) {
        		max = result[j];
        	}
        	//System.out.println("Max Visited Vertex::"+j+"--"+result[j]);
        }
        System.out.println("Max Visited Vertex::"+max);
        /*if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
 
        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);*/
   }
	
	static class Graph {
        int V;
        static LinkedList<Integer> adjListArray[];
         
        Graph(int V)
        {
            this.V = V;
             
            adjListArray = new LinkedList[V];
             
            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
        
        static void addEdge(int src, int dest)
        {
            adjListArray[src].addFirst(dest);
             
            adjListArray[dest].addFirst(src);
        }
        
        static void printGraph(Graph graph)
        {       
            for(int v = 0; v < graph.V; v++)
            {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print("head");
                for(Integer pCrawl: graph.adjListArray[v]){
                    System.out.print(" -> "+pCrawl);
                }
                System.out.println("\n");
            }
        }
        
        boolean[] isReachable(int s, int d)
        {
        	System.out.println("S and D " + s +" to " + d);
        	LinkedList<Integer>temp;
     
            // Mark all the vertices as not visited(By default set
            // as false)
            boolean visited[] = new boolean[V];
     
            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();
     
            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);
     
            // 'i' will be used to get all adjacent vertices of a vertex
            Iterator<Integer> i;
            while (queue.size()!=0)
            {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
     
                int n;
                i = adjListArray[s].listIterator();
     
                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                while (i.hasNext())
                {
                    n = i.next();
     
                    // If this adjacent node is the destination node,
                    // then return true
                    if (n==d) {
                    	//System.out.println("n==d::"+n+"=="+d);
                    	//visited[n]=true;
                    	visited[d]=true;
                    	return visited;
                    }
                    	
                        
     
                    // Else, continue to do BFS
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
     
            
            return visited;
        }
        
        static void calculateVertex(boolean[] visit) {
        	
        	for(int k=1;k<visit.length;k++) {
            	int s = result[k];
            	if(visit[k]) {
            		System.out.println("Visited Vertex::"+k);
            		result[k] = ++s;
            	}
            	
            }
        	
        }
        
        
        boolean[] minEdgeBFS( int u, int v) {
			// visited[n] for keeping track of visited
			// node in BFS
			//Vector<Boolean> visited = new Vector<Boolean>(V);
			boolean visited[] = new boolean[V];
			for (int i = 0; i < V; i++) {
				visited[i] = false;
				//visited.addElement(false);
			}
			// Initialize distances as 0
			Vector<Integer> distance = new Vector<Integer>(V);

			for (int i = 0; i < V; i++) {
				distance.addElement(0);
			}
			// queue to do BFS.
			Queue<Integer> Q = new LinkedList<>();
			distance.setElementAt(0, u);

			Q.add(u);
			//visited.setElementAt(true, u);
			visited[u] = true;
			while (!Q.isEmpty()) {
				int x = Q.peek();
				Q.poll();
				for (int i = 0; i < adjListArray[x].size(); i++) {
					if (visited[adjListArray[x].get(i)])
						return visited;

					// update distance for i
					//distance.setElementAt(distance.get(x) + 1, edges[x].get(i));
					Q.add(adjListArray[x].get(i));
					visited[adjListArray[x].get(i)] = true;
				}
				/*for (int i = 0; i < edges[x].size(); i++) {
					if (visited.elementAt(edges[x].get(i)))
						continue;

					// update distance for i
					distance.setElementAt(distance.get(x) + 1, edges[x].get(i));
					Q.add(edges[x].get(i));
					visited.setElementAt(true, edges[x].get(i));
				}*/
			}
			return visited;
		}
        
        
    }
	
	
	
	
	
	

}
