import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Main{
    public static int[] mergeSort(int[] arr){
        int[] result = new int[arr.length];
        List<Integer> dResult= mergeSortHelper(arr, 0, arr.length - 1);
        for (int i = 0; i < result.length; i++){
            result[i] = dResult.get(i);
        }
        
        return result;
    }

    public static ArrayList<Integer> mergeSortHelper(int[] arr, int start, int end){
        if (start == end) return new ArrayList<Integer>(Arrays.asList(arr[start]));

        int middle = (start + end) / 2;

        List<Integer> leftArr = mergeSortHelper(arr, start, middle);
        List<Integer> rightArr = mergeSortHelper(arr, middle + 1, end);

        leftArr.add(Integer.MAX_VALUE);
        rightArr.add(Integer.MAX_VALUE);

        int l = leftArr.size() + rightArr.size() - 2;
        int li = 0;
        int ri = 0;

        // out-of-place algorithm
        ArrayList<Integer> merge = new ArrayList<>();

        while(li + ri < l){
            if (leftArr.get(li) <= rightArr.get(ri)){
                merge.add(leftArr.get(li));
                li++;
            } else {
                merge.add(rightArr.get(ri));
                ri++;
            }
        }

        return merge;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {5, 4, 3, 2, 1};

        printArr(mergeSort(arr1));
        printArr(mergeSort(arr2));
    }
}

