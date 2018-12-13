public static int[] histogram(int[] a, int M){
    int[] b = new int [M];
    int n = 0;
    int m = 0;
    for(int i = 0; i < M; i++){
        for(int j = 0; j < a.length; j++){
            if(i == a[j]){
                n++;
            }
            b[i] = n;             
        }
        n = 0;        
    }    
    // for(int i = 0; i < M; i++){
    //     m = m + b[i];
    // }
    return b;
}
        
