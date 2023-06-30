import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int shuffleSuccessRate(int[] arr, int[] shuffledArr){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < shuffledArr.length; i++){
            map.put(shuffledArr[i], i);
        }

        // counting how many elements were shuffled
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (i != map.get(arr[i])) count++;
        }

        return (int)(Math.floor(count * 100d / arr.length));
    }

    public static void main(String[] args){
        int[] arr1 = {2,32,45};
        int[] shuffledArr1 = {45,32,2};
        int[] arr2 = {2,32,45,67,89};
        int[] shuffledArr2 = {2,89,67,45,32};

        System.out.println(shuffleSuccessRate(arr1, shuffledArr1));
        System.out.println(shuffleSuccessRate(arr2, shuffledArr2));
    }
}

