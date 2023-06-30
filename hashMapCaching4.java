import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Collections;

class Main{
    public static int[] appearTheMost(int[] levels){
        // TreeMap sorts keys automatically
        Map<Integer, Integer> treemap = new TreeMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int level: levels){
            treemap.put(level, treemap.getOrDefault(level, 0) + 1);
        }

        int maxValue = Collections.max(treemap.values());

        for (Integer key: treemap.keySet()){
            if(treemap.get(key) == maxValue) output.add(key);
        }

        // inserting same keys into the output array multiple times
        // for (int level: levels){
        //     if (treemap.get(level) == maxValue && !output.contains(level)) output.add(level);
        // }

        int[] intArray = output.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();
        
        return intArray;
    }

    public static void printArr(int[] arr){
        String output = "";
        for (int num: arr){
            output += num + " ";
        }
        
        System.out.println(output);
    }

    public static void main(String[] args){
        int[] arr1 = {1,1,2,2,3,3,3,4,5,6};
        int[] arr2 = {1,1,1,3,3,3,2,2,2,5};

        printArr(appearTheMost(arr1));
        printArr(appearTheMost(arr2));
    }
}


// class Main{
//     public static int[] appearTheMost(int[] levels){
//         Map<Integer, Integer> hashmap = new HashMap<>();
//         ArrayList<Integer> output = new ArrayList<>();

//         for (int level: levels){
//             hashmap.put(level, hashmap.getOrDefault(level, 0) + 1);
//         }

//         int maxValue = Collections.max(hashmap.values());

//         for (Integer key: hashmap.keySet()){
//             if(hashmap.get(key) == maxValue) output.add(key);
//         }

//         int[] intArray = output.stream()
//                                 .mapToInt(Integer::intValue)
//                                 .toArray();
        
//         // hashmap does not sort the keys, so need to use the sort() method
//         Arrays.sort(intArray);

//         return intArray;
//     }

//     public static void printArr(int[] arr){
//         String output = "";
//         for (int num: arr){
//             output += num + " ";
//         }
        
//         System.out.println(output);
//     }

//     public static void main(String[] args){
//         int[] arr1 = {1,1,2,2,3,3,3,4,5,6};
//         int[] arr2 = {1,1,1,3,3,3,2,2,2,5};

//         printArr(appearTheMost(arr1));
//         printArr(appearTheMost(arr2));
//     }
// }

