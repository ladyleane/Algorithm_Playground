public class PrimMST{
	private static final double FLOATING_POINT_EPSILON = 1E-12;

	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());

		distTo[o] = 0.0;
		pq.insert(0, 0.0);
		while (!pq.isEmpty())
			visit(G, pq.delMin());
	}

	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for (Edge e : G.adj(v)){
			int w = e.other(v);

			if (marked[v]) continue;
			if (e.weight() < distTo[w]){
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w))	pq.change(w, distTo[w]);
				else	pq.insert(w, distTo[w]);
			}
		}
	}

	public Iterable<Edge> edges(){
		//4.3.21
		Queue<Edge> mst = new Queue<Edge>();
		for (int v = 0; v < edgeTo.length; v++){
			Edge e = edgeTo[v];
			if (e != null){
				mst.enqueue(e):
			}
		}
		return mst;
	}

	public double weight(){
		//4.3.31
		double weight = 0.0;
		for (Edge e : edges())
			weight += e.weight();
		return weight;
	}

	//Test
	public static void main(String[] args){
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges()){
			StdOut.println(e);
		}
		StdOut.printf("%.5f\n", mst.weight());
	}
}
