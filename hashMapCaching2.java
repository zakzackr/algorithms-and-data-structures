import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int[] listIntersection(int[] targetList, int[] searchList){
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < targetList.length; i++){
            map.put(targetList[i], targetList[i]);
        }

        for (int i = 0; i < searchList.length; i++){
            if (map.get(searchList[i]) != null && !output.contains(searchList[i])) output.add(searchList[i]);
        }

        // converting from ArrayList<Integer> to int[] using stream API
        int[] intArray = output.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(intArray);

        // returning int[] in ascending order
        return intArray;
    }

    public static void printIntArr(int[] intArr){
        String output = "";
        for (int num: intArr) output += ", " + num;

        System.out.println("[" + output.substring(2) + "]");
    }

    public static void main(String[] args){
        int[] targetList1 = {1,2,3,4,5,6};
        int[] searchList1 = {1,4,4,5,8,9,10,11};
        int[] targetList2 = {3,4,5,10,2,20,4,5};
        int[] searchList2 = {4,20,22,2,2,2,10,1,4};
        printIntArr(listIntersection(targetList1, searchList1));
        printIntArr(listIntersection(targetList2, searchList2));
    }
}
