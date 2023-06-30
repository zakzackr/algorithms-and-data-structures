import java.util.Arrays;

class Main{
    public static int primesUpToNCount(int n){
        boolean[] cache = new boolean[n];
        Arrays.fill(cache, true);

        // counter for counting non-prime numbers
        int count = 2;

        for (int i = 2; i * i < n; i++){
            int p = 2;
            while(i * p < n){
                if (cache[i * p]) count++;
                cache[i * p] = false;
                p++;
            }
        }

        return cache.length - count;
    }

    public static void main(String[] main){
        System.out.println(primesUpToNCount(2));  // --> 0
        System.out.println(primesUpToNCount(10));  // --> 4
        System.out.println(primesUpToNCount(100));  // --> 25
    }
}
