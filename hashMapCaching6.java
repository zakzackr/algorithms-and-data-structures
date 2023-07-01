import java.util.Map;
import java.util.HashMap;

class Main{
    public static int longestPalindromeLength(String string){
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < string.length(); i++){
            if (map.get(string.charAt(i)) == null || map.get(string.charAt(i)) == 0){
                map.put(string.charAt(i), 1);
            } else {
                map.replace(string.charAt(i), 0);
                count++;
            }
        }

        for (int value: map.values()){
            if (value == 1) return 2 * count + 1;
        }
        return 2 * count;
    }

    public static void main(String[] args){
        String arr1 = "abcccdd";
        String arr2 = "nursesrunatthehole";

        System.out.println(longestPalindromeLength(arr1));
        System.out.println(longestPalindromeLength(arr2));
    }
}
