//Absolute value of int
public static int abs(int x){
	if (x < 0) return -x;
	else return x;
}


//Absolute value of float
public static int abs(float x){
	if (x < 0.0) return -x;
	else return x;
}


//isPrime?
public static boolean isPrime(int N){
	if(N < 2) return false;
	for(int i = 2; i*i < N; i++){
		if(N % i = 0) return false;
	}
	return true;
}


//SquareRoot(Newton Iteration)
public static double sqrt(double c){
	if (c < 0) return Double.NaN;
	double err = 1e-15;
	double t = c;
	while(Math.abs(t - c/t) > err * t)
		t = (c/t + t)/2.0;
	return t;
}


