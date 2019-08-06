public class DijkstraAllPairsSP{
	private DijkstraAllPairsSP[] all;

	DijkstraAllPairsSP(EdgeWeightedGraph G){
		all = new DijkstraSP[G.V()];
		for (int v = 0; v < G.V(); v++)
			all[v] = new DijkstraSP(G, v);
	}

	Iterable<DirectedEdge> path(int s, int t){
		return all[s].pathTo(t);
	}

	double idst(int s, int t){
		return all[s].distTo(t);
	}
}
