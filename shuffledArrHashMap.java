import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main{
    public static int[] shuffledPositions(int[] arr, int[] shuffledArr){
        Map<Integer, Integer> shuffledMap = new HashMap<>();
        int[] output = new int[arr.length];

        for (int i = 0; i < shuffledArr.length; i++){
            shuffledMap.put(shuffledArr[i], i);
        }

        for (int i = 0; i < arr.length; i++){
            output[i] = shuffledMap.get(arr[i]);
        }

        return output;
    }

    public static void printIntArr(int[] intArr){
        String output = "";
        for (int i = 0; i < intArr.length; i++){
            output += ", " + intArr[i];
        }

        System.out.println("[" + output.substring(2) + "]");
    }

    public static void main(String[] args){
        int[] arr1 = {10,11,12,13};
        int[] shuffledArr1 = {12,10,13,11};
        int[] arr2 = {1350,181,1714,375,1331,943,735};
        int[] shuffledArr2 = {1714,1331,735,375,1350,181,943};

        printIntArr(shuffledPositions(arr1, shuffledArr1));
        printIntArr(shuffledPositions(arr2, shuffledArr2));
    }
}
