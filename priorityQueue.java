import java.util.Arrays;
import java.util.ArrayList;

class HeapLibrary{
    public static int left(int i){
        return 2*i + 1;
    }

    public static int right(int i){
        return 2*i + 2;
    }

    public static int parent(int i){
        return (i - 1) / 2;
    }

    public static void buildMaxHeap(ArrayList<Integer> arr){
        int mid = parent(arr.size() - 1);
        for (int i = mid; i >= 0; i--){
            maxHeapify(arr, arr.size() - 1, i);
        }
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
}

class PriorityQueue{
    public ArrayList<Integer> maxHeap;

    public PriorityQueue(ArrayList<Integer> arr){
        this.maxHeap = new ArrayList<Integer>(arr);
        HeapLibrary.buildMaxHeap(this.maxHeap);
    }

    public int top(){
        return this.maxHeap.get(0);
    }

    public int pop(){
        int temp = this.top();
        this.maxHeap.set(0, this.maxHeap.remove(this.maxHeap.size() - 1));
        HeapLibrary.maxHeapify(this.maxHeap, this.maxHeap.size() - 1, 0);
        return temp;
    }

    public void push(int data){
        this.maxHeap.add(data);
    }

    public void insert(int x){
        this.push(x);
        int i = this.maxHeap.size() - 1;  // 追加した要素のindex
        int parent = HeapLibrary.parent(i);

        while (parent >= 0 && x > this.maxHeap.get(parent)){
            int temp = this.maxHeap.get(parent); 
            this.maxHeap.set(parent, x);
            this.maxHeap.set(i, temp);
            i = parent;
            parent = HeapLibrary.parent(i);
        }
    }
}

class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap = new ArrayList<Integer>(Arrays.asList(new Integer[]{2,3,43,2,53,6,75,10}));
        System.out.println(heap);
        PriorityQueue pq = new PriorityQueue(heap);
        System.out.println(pq.maxHeap);
        pq.insert(5);
        System.out.println(pq.maxHeap);
        pq.insert(10);
        System.out.println(pq.maxHeap);
        pq.insert(100);
        System.out.println(pq.maxHeap);
        pq.insert(1);
        System.out.println(pq.maxHeap);
        pq.pop();
        System.out.println(pq.maxHeap);
    }
}
