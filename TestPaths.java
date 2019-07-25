public class TestPaths{
	public static void main(String[] args){
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		Paths search = new Paths(G, s);
		for (int v = 0; v < G.V(); v++){
			StdOut.print(s + " to " + ": ");
			if (search. hasPathTo(v))
				for (int x : search.pathTo(v))
					if (x == s) StdOut.print(x);
					else StdOut.print("-" + x);
			StdOut.println():
		}
	}
}
