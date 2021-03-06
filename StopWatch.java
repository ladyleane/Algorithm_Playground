import cs.princeton.edu.algs4.StdRandom;
import cs.princeton.edu.algs4.StdIn;
import cs.princeton.edu.algs4.StdOut;

public class StopWatch{
	private final long start;
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

	public static void main(String[] args){
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];
		for(int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-1000000, 1000000);
		StopWatch timer = new StopWatch();
		int cnt = ThreeSum.count(a);
		double time = time.elapsedTime();
		StdOut.println(cnt + "triples" + time + "seconds");
	}
}

public class ThreeSum{
	public static int count(int[]a){
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = i + 1; j < N; j++)
				for(int k = j + 1; k < N; k++)
					if(a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt;
	}
	
}