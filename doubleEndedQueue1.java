class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node (int data){
        this.data = data;
    }
}

class Deque{
    public Node head;
    public Node tail;

    public Deque(){};

    public Integer peekFront(){
        if (this.head == null) return null;
        return this.head.data;
    }

    public Integer peekBack(){
        if (this.tail == null) return null;
        return this.tail.data;
    }

    public void enqueueFront(int data){
        if (this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }
        else {
            this.head.prev = new Node(data);
            this.head.prev.next = this.head;
            this.head = this.head.prev;
        }
    }

    public void enqueueBack(int data){
        if (this.tail == null){
            this.tail = new Node(data);
            this.head = this.tail;
        }
        else {
            this.tail.next = new Node(data);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
    }

    public Integer dequeueFront(){
        if (this.head == null) return null;

        Node temp = this.head;
        System.out.println(this.head);  // Nodeオブジェクトのメモリアドレスの変化を確認
        this.head = this.head.next;
        System.out.println(this.head.prev);　　// Nodeオブジェクトのメモリアドレスの変化を確認
        if (this.head == null) this.tail = null;
        else this.head.prev = null;

        return temp.data;
    }

    public Integer dequeueBack(){
        if (this.tail == null) return null;

        Node temp = this.tail;
        this.tail = this.tail.prev;
        if (this.tail == null) this.head = null;
        else this.tail.next = null;

        return temp.data;
    }
}


class Main{
    public static void main(String[] args){
        Deque deque = new Deque();
        deque.enqueueFront(2);
        deque.enqueueFront(4);
        deque.enqueueBack(4);
        deque.enqueueBack(2);

        // current deque: [4, 2, 4, 2]

        System.out.println(deque.peekFront());  // --> 4
        System.out.println(deque.peekBack());  // --> 2
        System.out.println(deque.dequeueFront());  // --> 4
        System.out.println(deque.dequeueBack());  // --> 2
        System.out.println(deque.dequeueFront());  // --> 2
        System.out.println(deque.dequeueBack());  // --> 4
        System.out.println(deque.dequeueFront());  // --> null
        System.out.println(deque.dequeueBack());  // --> null
        System.out.println(deque.peekFront());  // --> null
        System.out.println(deque.peekBack());  // --> null
    }
}
