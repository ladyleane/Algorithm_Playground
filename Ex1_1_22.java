public class Ex1_1_22 {
    public static int rank(int key, int[] a, int depth){
        return rank(key, a, 0, a.length - 1, depth);
    }
    public static int rank(int key, int[] a, int low, int high, int depth){
        System.out.println("depth = " + depth + ", low = " + low + ", high = " + high);
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (key < a[mid]){
            depth++;
            return rank(key, a, low, mid - 1, depth);
        }
        else if (key > a[mid]) {
            depth++;
            return rank(key, a, mid + 1, high, depth);
        }
        else
            return mid;
    }
    public static void main(String[] args) {
        int[] a = {10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
        rank(23, a, 0);
    }
}
