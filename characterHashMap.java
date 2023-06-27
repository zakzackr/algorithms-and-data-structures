import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main{
    public static int[] characterLocation(String commands){
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('N', new int[]{0, 1});
        directions.put('E', new int[]{1, 0});
        directions.put('W', new int[]{-1, 0});
        directions.put('S', new int[]{0, -1});

        int[] currLocation = {0, 0};
        for (int i = 0; i < commands.length(); i++){
            int[] direction = directions.get(commands.charAt(i));
            if (direction != null){
                // updating the character's location
                currLocation[0] += direction[0];
                currLocation[1] += direction[1];
            }
        }

        return currLocation;
    }

    public static void printArr(int[] arr){
        String output = "";
        for (int num: arr){
            output += "," + num;
        }
        System.out.println("[" + output.substring(1) + "]");
    }

    public static void main(String[] args){
        printArr(characterLocation("NNNN"));
        printArr(characterLocation("NESW"));
        printArr(characterLocation("NW"));
        printArr(characterLocation("AWFGMD"));
        printArr(characterLocation("NSSNWENSSNNN"));
    }
}
