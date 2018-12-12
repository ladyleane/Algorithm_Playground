// Find Maximum
double max = a[0];
for(int i = 1; i < a.length; i++)
	if(a[i] > max) max = a[i];


//Average
int a = N.length;
double sum = 0.0;
for(int i = 0; i < N; i++)
	sum += a[i]
double average = sum / N;


//Copy Arrays
int N = a.length
double[] b = new double[N]
for(int i = 0; i < N; i++)
	b[i] = a[i];


//Reverse Array Element Order
int N = a.length
for(int i = 0; i < N/2; i++){
	double temp = a[i];
	a[i] = a[N - i];
	a[N - i - 1] = temp;
}


//Matrix Multiplication
int N = a.length;
double[][] c = new double[N][N]
for(int i = 0; i < N; i++)
	for(int j = 0; j < N; j++){
		for(int k = 0; k < N; k++)
				c[i][j] += a[i][k] * b[k][j];
	}


