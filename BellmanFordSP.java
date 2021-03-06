public class BellmanFordSP{
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	pirvate boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Iterable<DirectedEdge> cycle;

	public BellmanFordSP(EdgeWeightedDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new Queue<Integer>();
		queue = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while (!queue.isEmpty() && !hasNegativeCycle()){
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
	}

	private void relax(EdgeWeightedDigraph G, int v){
		for (DirectedEdge e : G.adj(v)){
			int w = e.to();
			if (distTo[w] > distTO[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (!onQ[w]){
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			if (cost++ % G.V() == 0)
				findNegativeCycle();
		}
	}

	public double distTo(int v){
		//
		return distTo[v];
	}

	public boolean hasPathTo(int v){
		//
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> PathTo(int v){
		//
		if (!hasPathTo(v))	return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>():
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	private void findNegativeCycle(){
		int V = edgeTo.length;
		EdgeWeightedGraph spt;
		spt = new EdgeWeightedGraph(v);
		for (int v = 0; v < V; v++)
			if (edgeTo[v] != null)
				spt.addEdge(edgeTo[v]);

		EdgeWeightedCycleFinder cf;
		cf = new EdgeWeightedCycleFinder(spt);

		cycle = cf.cycle();
	}

	public boolean hasNegativeCycle(){
		return cycle != null;
	}

	public Iterable<Edge> negativeCycle(){
		return cycle;
	}
}
