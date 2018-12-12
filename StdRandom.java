//Random double between [a, b)
public static double uniform(double a, double b){
	return a + StdRandom.random() * (b - a);
}


//[0, N)
public static int uniform(int N){
	return (int) (StdRandom.random() * N);
}


//[low, high)
public static int uniform(int low, int high){
	return low + StdRandom.uniform() * (high - low);
}


//Return value according to discrete prob
public static int discrete(double[] a){
	//sum(a[i]) == 1
	double r = StdRandom.random();
	double sum = 0.0;
	for(int i = 0; i < a.length; i++){
		sum = sum + a[i];
		if(sum >= r) return i;
	}
	return -1;
}


//Shuffle sorting
public static void shuffle(double[] a){
	int N = a.length;
	for(int i = 0; i < N; i++){
		int r = i + StdRandom.uniform(N - i);
		double temp = a[i];
		a[i] = a[r];
		a[r] = temp;
	}
}