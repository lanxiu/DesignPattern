package com.graph;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private final int V;
	private int E;
	private List<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E=0;
		adj = (List<Integer>[])new ArrayList [V];
		
		for(int v = 0 ; v<V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	public Graph(InputStream in) {
		V = 0;

	}

	int V() {

		return V;
	}
	int E() {

		return E;
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;

	}

	Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public String toString() {
		
		
		
		
		
		
		return "";
	}

	public static int degree(Graph G,int v) {
		
		
		int degree = 0;
		for(int w:G.adj(v))
			degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G) {
		
		int max = 0;
		for(int v=0;v<G.V();v++) 
			if(degree(G, v)>max)
				max =  degree(G, v);
		
		return max;
		
		
		
	}

	public static double avgDegree(Graph G) {
		return 2*G.E()/G.V();
	}

	
	//TODO:自环个数计算没看懂？
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for(int v= 0; v<G.V();v++)
			for(int w:G.adj(v))
				if(v==w) 
					count++;
		return count /2;
	}
	
	
	

}
