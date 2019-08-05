public class EdgeWeightedGraph{
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V;
		for (int v = 0; v < V; v++){
			adj[v] = new Bag<DirectedEdge>();
		}
	}

	public EdgeWeightedGraph(In in){
		//4.4.2
		this(in.readInt());
		int E = in.readInt();
		if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		for (int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			addEdge(new DirectedEdge(v, w, weight));
		}
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
	}

	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}

	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++){
			for (DirectedEdge e : adj[v]){
				bag.add(e);
			}
		}
		return bag;
	}
}
