import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int firstRepeatingNumber(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums){
            if (map.get(num) > 1) return num;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr1 = {2,12,5,10,9,8};
        int[] arr2 = {11,45,32,75,88,15,15};

        System.out.println(firstRepeatingNumber(arr1));
        System.out.println(firstRepeatingNumber(arr2));
    }
}
