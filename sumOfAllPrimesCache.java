import java.util.ArrayList;

class Main{
    public static int sumOfAllPrimes(int n){
        int[] primeNumbers = allNPrimesSieve(n);
        int output = 0;

        for (int prime: primeNumbers) output += prime;

        return output;
    }

    public static int[] allNPrimesSieve(int n){
        boolean[] cache = new boolean[n + 1];
        for (int i = 0; i < cache.length; i++){
            cache[i] = true;
        }

        for (int currentPrime = 2; currentPrime <= Math.floor(Math.sqrt(n)); currentPrime++){
            if (!cache[currentPrime]) continue;

            int i = 2;
            while(i * currentPrime <= n){
                cache[i * currentPrime] = false;
                i++;
            }
        }

        ArrayList<Integer> primeNumbersDynamic = new ArrayList<>();
        for (int i = 2; i < cache.length; i++){
            if (cache[i]) primeNumbersDynamic.add(i);
        }

        return toIntArray(primeNumbersDynamic);
    }

    public static int[] toIntArray(ArrayList<Integer> dIntArr){
        int[] intArray = dIntArr.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        return intArray;
    }

    public static void main(String[] args){
        System.out.println(sumOfAllPrimes(5));  // --> 10
        System.out.println(sumOfAllPrimes(10));  // --> 17
        System.out.println(sumOfAllPrimes(100));  // 1060
    }
}


// class Main{
//     public static int sumOfAllPrimes(int n){
//         int output = 0;
//         for (int i = 0; i <= n; i++){
//             if (isPrime(i)) output += i;
//         }

//         return output;
//     }

//     public static boolean isPrime(int n){
//         for (int i = 2; i <= Math.floor(Math.pow(n, 0.5)); i++){
//             if (n % i == 0) return false;
//         }

//         return n > 1;
//     }

//     public static void main(String[] main){
//         System.out.println(sumOfAllPrimes(5));  // --> 10
//         System.out.println(sumOfAllPrimes(10));  // --> 17
//         System.out.println(sumOfAllPrimes(100));  // 1060
//     }
// }






