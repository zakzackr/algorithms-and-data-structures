import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int seachList(int[] numList, int value){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numList.length; i++){
            map.put(numList[i], i);
        }

        return map.getOrDefault(value, -1);
        // return (map.get(value) != null)? map.get(value): -1;
    }

    public static void main(String[] main){
        int[] arr = {3,22,23,3,-1,50,2,3,4,8,62,1,-2};

        System.out.println(seachList(arr, 23));
        System.out.println(seachList(arr, 1));
        System.out.println(seachList(arr, 111));
    }
}
