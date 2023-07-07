import java.util.ArrayList;

class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Deque{
    public Node head;
    public Node tail;

    public Deque(){
        this.head = null;
        this.tail = null;
    }

    public Integer peekFront(){
        if(this.head == null) return null;
        return this.head.data;
    }

    public Integer peekBack(){
        if(this.tail == null) return null;
        return this.tail.data;

    }

    public void enqueueFront(int data){
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else {
            Node node = new Node(data);
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }  
    }

    public void enqueueBack(int data){
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
            Node node = new Node(data);
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    public Integer dequeueFront(){
        if(this.head == null) return null;

        Node temp = this.head;
        this.head = this.head.next;
        if(this.head != null) this.head.prev = null;
        else this.tail = null;
        return temp.data;
    }

    public Integer dequeueBack(){
        if(this.tail == null) return null;

        Node temp = this.tail;
        this.tail = this.tail.prev;

        if(this.tail != null) this.tail.next = null;
        else this.head = null;
        return temp.data;
    }
}

class Main{
    // size kの部分配列の最大値を格納した配列を返す
    public static ArrayList<Integer> getMaxWindows(int[] arr, int k){
        ArrayList<Integer> output = new ArrayList<Integer>();
        if (k > arr.length) return output;

        Deque deque = new Deque();

        // ウィンドウの初期状態を作成
        for (int i = 0; i < k; i++){
            while (deque.peekBack() != null && arr[deque.peekBack()] <= arr[i]){
                deque.dequeueBack();
            }
            deque.enqueueBack(i);
        }

        // ウィンドウの対象を右に一つずつずらす
        for (int i = k; i < arr.length; i++){
            output.add(arr[deque.peekFront()]);

            // ウィンドウを更新し、ウィンドウの外になった要素をdequeueFront()で先頭からdequeしていく
            // while(deque.peekFront() != null && deque.peekFront() <= i - k) deque.dequeueFront();
            if (deque.peekFront() <= i - k) deque.dequeueFront();

            // 新たにウィンドウに追加される要素が既存の要素より大きい場合は、新たな要素より小さい既存の要素をウィンドウから削除
            // これによりウィンドウの一番左は常にその部分配列の最大値となる
            while(deque.peekFront() != null && arr[deque.peekBack()] <= arr[i]) deque.dequeueBack();
            deque.enqueueBack(i);
        }

        output.add(arr[deque.peekFront()]);
        return output;
    }

    public static void main(String[] args){
        //[64, 64, 64, 34, 14, 353, 353, 353, 353, 63]
        System.out.println(getMaxWindows(new int[]{34,35,64,34,10,2,14,5,353,23,35,63,23}, 4));
        // [94, 94, 94, 94, 14, 353, 353, 353, 353, 63]
        System.out.println(getMaxWindows(new int[]{34,35,64,94,10,2,14,5,353,23,35,63,23}, 4));
        // [3, 4, 6]
        System.out.println(getMaxWindows(new int[]{3, 2, 4, 6}, 2));
        // []
        System.out.println(getMaxWindows(new int[]{3, 2, 4, 6}, 5));
        // [3, 2, 4, 6]
        System.out.println(getMaxWindows(new int[]{3, 2, 4, 6}, 1));
        // [6]
        System.out.println(getMaxWindows(new int[]{3, 2, 4, 6}, 4));
    }
}
