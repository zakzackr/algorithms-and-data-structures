import java.util.Arrays;
import java.util.ArrayList;

class Heap{
    public static int left(int i){
        return 2*i + 1;
    }

    public static int right(int i){
        return 2*i + 2;
    }

    public static int parent(int i){
        return (i - 1) / 2;
    }

    public static void maxHeapify(ArrayList<Integer> arr, int i){
        int l = left(i);
        int r = right(i);
        int biggest = i;

        if (l < arr.size() && arr.get(l) > arr.get(biggest)) biggest = l;
        if (r < arr.size() && arr.get(r) > arr.get(biggest)) biggest = r;

        if (biggest != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            maxHeapify(arr, biggest);
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> arr){
        int mid = parent(arr.size() - 1);
        // 葉ノードはヒープ条件を満たすから、最後の葉ノードを子にもつノードからmaxHeapify()でヒープ条件を確認する
        for (int i = mid; i >= 0; i--){
            maxHeapify(arr, i);
        }
    }
}

class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println(heap1);
        Heap.buildMaxHeap(heap1);
        System.out.println(heap1);

        ArrayList<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));
        System.out.println(heap2);
        Heap.buildMaxHeap(heap2);
        System.out.println(heap2);

        ArrayList<Integer> heap3 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap3);
        Heap.buildMaxHeap(heap3); 
        System.out.println(heap3); 
    }
}
