public class KMP{
	private String pat;
	private int[][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++){
			//Calculate dfa[][j]
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];	//Copy value when fail
			dfa[pat.charAt(j)][j] = j + 1;	//Set value when success
			X = dfa[pat.charAt(j)][X];	//Update
		}
	}

	public int search(String txt){
		int i, j, N = txt.length(), M = pat.length();
		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M)	return i - M;	//Match
		else	return N;	//Not match
	}

	public static void main(String[] args){
		//Test
		String pat = args[0];
		String txt = args[1];
		KMP kmp = new KMP(pat);
		StdOut.println("text:	" + txt);
		int offset = kmp.search(txt);
		StdOut.print("pattern: ");
		for (int i = 0; i < offset; i++) {
			StdOut.print(" ");
		}
		StdOut.println(pat);
	}
}
