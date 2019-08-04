public class KruskalMST{
	private static final double FLOATING_POINT_EPSILON = 1E-12;
	private double weight;
	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G){
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();

		for (Edge e : G.edges()) {
			pq.insert(e);
		}

		UF uf = new UF(G.V());

		while(!pq.isEmpty() && mst.size() < G.V() - 1){
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (uf.connnected(v, w))	continue;
			uf.union(v, w);
			mst.enqueue(e);
			weight += e.weight();
		}
	}

	public Iterable<Edge> edges(){
		return mst;
	}

	public double weight(){
		return weight;
	}

	private boolean check(EdgeWeightedGraph G){
		//Check optimality conditions.
		double total = 0.0;
		for (Edge e : edges()){
			total += e.weight();
		}
		if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON){
			System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
			return false;
		}

		UF uf = new UF(G.V());
		for (Edge e: edges()){
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)){
				System.err.println("Not a forest");
				return false;
			}
			uf.union(v, w);
		}

		for (Edge e : G.edges()){
			int v = e.either(), w = e.other(v);
			if (!uf.connected()){
				System.err.println("Not a spanning forest");
				return false;
			}
		}

		for (Edge e : edges()){
			uf = new UF(G.V());
			for (Edge f : mst){
				int x = f.either(), y = f.other(x);
				if (！uf.connected(x, y)）{
					if (f.weight() < e.weight()){
						System.err.println("Edge " + f + " violates cut optimality conditions");
						return false;
					}
				}
			}
		}
		return false;
	}

	//Test
	public static void main(String[] args){
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST mst = new KruskalMST(G);
		for (Edge e: mst.edges()){
			StdOut.println(e);
		}
		StdOut.printf("%.5f \n", mst.weight());
	}
}
