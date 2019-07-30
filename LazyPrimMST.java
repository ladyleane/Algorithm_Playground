public class LazyPrimMST{
	private static final double FLOATING_POINT_EPSILON = 1E-12;

	private double weight;
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();

		visit(G, 0);
		while (!pq.isEmpty()){
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w]) continue;
			mst.enqueue(e);
			if (!marked[v])	visit(G, v);
			if (!marked[w]) visit(G, w);
		}
	}

	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for (Edge e: G.adj(v))
			if (!marked[e.other(v)])	pq.insert(e);
	}

	public Iterable<Edge> edges(){
		return mst;
	}

	public double weight(){
		return weight;
	}

	private boolean check(EdgeWeightedGraph G){
		double totalWeight = 0.0;
		for (Edge e : edges()){
			totalWeight += e.weight();
		}

		if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON){
			System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
			return false;
		}

		UF uf = new UF(G.V());
		for (Edge e : edges()){
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)){
				System.err.println("Not a forest");
				return false;
			}
			uf.union(v, w);
		}

		for (Edge e : G.edges()){
			int v = e.either(), w = e.other(v);
			if (!uf.connected(v, w)){
				System.err.println("Not a spanning forest");
				return false;
			}
		}

		for (Edge e : edges()){
			uf = new UF(G.V());
			for (Edge f : mst){
				int x = f.either(), y = f.other(x);
				if (f != e)	uf.union(x, y);
			}

			for (Edge f : G.edges()){
				int x = f.either(), y = f.other(x);
				if (!uf.connected(x, y)){
					if (f.weight() < e.weight()){
						System.err.println("Edge " + f + " violates cut optimality conditions");
						return false;
					}
				}
			}
		}
		return true;
	}

	//TEST
	public static void main(String[] args){
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		LazyPrimMST mst = new LazyPrimMST(G);
		for (Edge e : mst.edges()){
			StdOut.println(e);
		}
		StdOut.printf("%.5f\n", mst.weight());
	}
}
