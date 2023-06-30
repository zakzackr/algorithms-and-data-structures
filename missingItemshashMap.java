import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int[] missingItems(int[] listA, int[] listB){
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int num: listB) map.put(num, num);

        for (int num: listA){
            if (map.get(num) == null) output.add(num);
        }

        int[] intArray = output.stream().mapToInt(Integer::intValue).toArray();

        return intArray;
    }

    public static void printArr(int[] arr){
        String output = "";
        for (int elem: arr){
            output += ", " + elem;
        }

        System.out.println("[" + output.substring(2) + "]");
    }

    public static void main(String[] args){
        int[] list1 = {1,2,3,4,5,6,7,8};
        int[] list2 = {1,3,5};
        int[] list3 = {1,2};
        int[] list4 = {9,8,7,6,5};

        printArr(missingItems(list1, list2));
        printArr(missingItems(list3, list4));
    }
}
