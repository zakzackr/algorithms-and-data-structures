import java.util.Arrays;
import java.util.ArrayList;

class Main{
    public static int[] merge(int[] leftArr, int[] rightArr){
        int[] output = new int[leftArr.length + rightArr.length];
        ArrayList<Integer> leftDArr = new ArrayList<>();
        ArrayList<Integer> rightDArr = new ArrayList<>();

        for (int num: leftArr){
            leftDArr.add(num);
        }

        for (int num: rightArr){
            rightDArr.add(num);
        }

        // それぞれの配列の最後に無限大を格納する
        leftDArr.add(Integer.MAX_VALUE);
        rightDArr.add(Integer.MAX_VALUE);

        int left = 0;
        int right = 0;
        int idx = 0;

        while (idx < output.length){
            if (leftDArr.get(left) <= rightDArr.get(right)){
                output[idx++] = leftDArr.get(left);
                left++;
            } else {
                output[idx++] = rightDArr.get(right);
                right++;
            }
            // idx++;
        }

        return output;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        printArr(merge(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
        printArr(merge(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8}));
        printArr(merge(new int[]{1, 100}, new int[]{2, 4}));
    }
}

