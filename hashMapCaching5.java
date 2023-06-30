import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Main{
    public static String[] charFrequency(String message){
        message = message.replaceAll(" ", "");
        Map<Character, Integer> treemap = new TreeMap<>();
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < message.length(); i++){
            Character currKey = message.charAt(i);
            treemap.put(currKey, treemap.getOrDefault(currKey, 0) + 1);
        }

        for (Character key: treemap.keySet()){
            System.out.println(key);
            output.add(key + " : " + treemap.get(key));
        }

        String[] strArray = output.stream().toArray(String[]::new);

        return strArray;
    }

    public static void printArr(String[] arr){
        String output = "";
        for (int i = 0; i < arr.length; i++){
            output += ", " + arr[i];
        }

        System.out.println("[" + output.substring(2) + "]");
    }

    public static void main(String[] args){
        String case1 = "aaaaa";
        String case2 = "i like ramen and sushi";

        printArr(charFrequency(case1));
        printArr(charFrequency(case2));
    }
}
