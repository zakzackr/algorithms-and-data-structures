import java.util.List;
import java.util.ArrayList;

class Main{
    public static ArrayList<Integer> allNPrimesSieve(int n){
        boolean[] cache = new boolean[n + 1];  // initialized with false values
        for (int i = 0; i < cache.length; i++){
            cache[i] = true;
        }

        // set the first prime to 2
        for (int currentPrime = 2; currentPrime <= Math.floor(Math.sqrt(n)); currentPrime++){
            if (!cache[currentPrime]) continue;  
            int i = 2;
            int ip = currentPrime * i;
            while (ip <= n){
                cache[ip] = false;
                i++;
                ip = currentPrime * i;
            }
        }

        ArrayList<Integer> primeNumbersDynamic = new ArrayList<>();
        for (int i = 2; i < cache.length; i++){
            if (cache[i]) primeNumbersDynamic.add(i);
        }

        return primeNumbersDynamic;
    }

    public static void printIntDArr(ArrayList<Integer> dArr){
        for (int i = 0; i < dArr.size(); i++){
            System.out.println(dArr.get(i) + " ");
        }
    }

    public static void main(String[] args){
        printIntDArr(allNPrimesSieve(100));
        System.out.println("Total number of prime numbers up to 100: " + allNPrimesSieve(100).size());
    }
}
