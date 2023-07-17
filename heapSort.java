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

    public static void maxHeapify(ArrayList<Integer> arr, int heapEnd, int i){
        int l = left(i);
        int r = right(i);
        int biggest = i;

        if (l <= heapEnd && arr.get(l) > arr.get(biggest)) biggest = l;
        if (r <= heapEnd && arr.get(r) > arr.get(biggest)) biggest = r;

        if (biggest != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            maxHeapify(arr, heapEnd, biggest);
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> arr){
        int mid = parent(arr.size() - 1);
        for (int i = mid; i >= 0; i--){
            maxHeapify(arr, arr.size() - 1, i);
        }
    }

    public static void heapSort(ArrayList<Integer> arr){
        buildMaxHeap(arr);
        int heapEnd = arr.size() - 1;

        while (heapEnd > 0){
            int temp = arr.get(heapEnd);
            arr.set(heapEnd, arr.get(0));
            arr.set(0, temp);
            heapEnd--;
            maxHeapify(arr, heapEnd, 0);
        }
    }
}

class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));
        System.out.println(heap1);  // -> [2, 42, 11, 30, 10, 7, 6, 5, 9]
        Heap.heapSort(heap1);
        System.out.println(heap1);// -> [2, 5, 6, 7, 9, 10, 11, 30, 42]

        ArrayList<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap2);
        Heap.heapSort(heap2); 
        System.out.println(heap2);
    }
}
