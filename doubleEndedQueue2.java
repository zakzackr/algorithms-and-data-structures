class Item{
    public int data;
    public Item next;
    public Item prev;  // 片方向連結リストではdequeueBack()が行えず、双方向である必要がある。prevポインタ必要

    public Item(int data){
        this.data = data;
    }
}

class Deque{
    public Item head;
    public Item tail;

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
            this.head = new Item(data);
            this.tail = this.head;
        }
        else {
            this.head.prev = new Item(data);
            this.head.prev.next = this.head;
            this.head = this.head.prev;
        }
    }

    public void enqueueBack(int data){
        if (this.tail == null){
            this.tail = new Item(data);
            this.head = this.tail;
        }
        else {
            this.tail.next = new Item(data);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
    }

    public Integer dequeueFront(){
        if (this.head == null) return null;

        Item temp = this.head;
        this.head = this.head.next;
        if (this.head == null) this.tail = null;
        else this.head.prev = null;

        return temp.data;
    }

    public Integer dequeueBack(){
        if (this.tail == null) return null;

        Item temp = this.tail;
        this.tail = this.tail.prev;
        if (this.tail == null) this.head = null;
        else this.tail.next = null;

        return temp.data;
    }
}

class MyClass{
    public static void main(String[] args){
        Deque q = new Deque();
        q.enqueueBack(4);
        q.enqueueBack(50);
        System.out.println(q.peekFront());  // --> 4
        System.out.println(q.peekBack());  // --> 50
        q.enqueueFront(36);
        q.enqueueFront(96);
        System.out.println(q.peekFront());  // --> 96
        System.out.println(q.peekBack());  // --> 50
        System.out.println(q.dequeueBack());  // --> 50
        System.out.println(q.dequeueBack()); //  --> 4
        System.out.println(q.peekFront());  // --> 96
        System.out.println(q.peekBack());  // --> 36
        q.enqueueFront(20);
        System.out.println(q.dequeueBack());  // --> 36
    }
}
