import java.util.Arrays;
import java.util.ArrayList;

class Heap{
    public static int left(int i){
        return 2*i + 1;
    }

    public static int right(int i){
        return 2*i + 2;
    }

    // ノードiの左右の部分木が最大ヒープであることを前提
    public static void maxHeapify(ArrayList<Integer> arr, int i){
        // 親ノードiの左右の子ノード
        int left = left(i);
        int right = right(i);
        // 親ノードを現在の最大値に設定
        int biggest = i;

        if (left < arr.size() && arr.get(left) > arr.get(biggest)) biggest = left;
        if (right < arr.size() && arr.get(right) > arr.get(biggest)) biggest = right;

        if (biggest != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            maxHeapify(arr, biggest);
        }
    }
}

class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));
        System.out.println(heap1);
        Heap.maxHeapify(heap1,0); 
        System.out.println(heap1);

        ArrayList<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap2);
        Heap.maxHeapify(heap2,1); 
        System.out.println(heap2);

        ArrayList<Integer> heap3 = new ArrayList<>(Arrays.asList(new Integer[]{56,54,51,10,12,5,12,4,6,5}));
        System.out.println(heap3);
        Heap.maxHeapify(heap3,0); 
        System.out.println(heap3);

    }
}
