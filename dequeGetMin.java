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

    // O(1)
    public void enqueueFront(int data){
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else {
            this.head.prev = new Node(data);
            this.head.prev.next = this.head;
            this.head = this.head.prev;
        }
    }

    // O(1)
    public void enqueueBack(int data){
        if(this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else{
            this.tail.next = new Node(data);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
    }

    public Integer dequeueFront(){
        if(this.head == null) return null;

        Node temp = this.head;
        this.head = this.head.next;
        if(this.head == null) this.tail = null;
        else this.head.prev = null;
        return temp.data;
    }

    public Integer dequeueBack(){
        if(this.tail == null) return null;

        Node temp = this.tail;
        this.tail = this.tail.prev;
        if(this.tail == null) this.head = null;
        else this.tail.next = null;
        return temp.data;
    }
}

class Main{
    public static Integer getMin(int[] arr){
        if (arr.length <= 0) return null;

        Deque deque = new Deque();
        deque.enqueueFront(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < deque.peekFront()) deque.enqueueFront(arr[i]);
            else deque.enqueueBack(arr[i]);
        }

        return deque.peekFront();
    }

    public static void main(String[] args){
        System.out.println(getMin(new int[]{3,2,1,5,6,4}));
        System.out.println(getMin(new int[]{7,8,2,3,1,7,8,11,4,3,2}));
        System.out.println(getMin(new int[]{34,35,64,34,10,2,14,5,353,23,35,63,23}));
        System.out.println(getMin(new int[]{1}));
        System.out.println(getMin(new int[0]));
    }
}
