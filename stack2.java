class Item{
    public int data;
    public Item next;

    public Item(int data){
        this.data = data;
    }
}

class Stack{
    public Item head;  // デフォルトでnull

    public Stack(){};

    // Stackの先頭にItemを追加
    public void push(int data){
        Item temp = this.head;
        this.head = new Item(data);
        this.head.next = temp;
    }

    // Stackの先頭からItemをpopして、そのItemの値を返す
    public Integer pop(){
        if (this.head == null) return null;
        Item temp = this.head;
        this.head = this.head.next;
        return temp.data;
    } 

    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
}

class Main{
    public static void main(String[] args){
        Stack s1 = new Stack();
        s1.push(2);
        System.out.println(s1.peek());  // --> 2
        s1.push(4);
        s1.push(3);
        s1.push(1);
        System.out.println(s1.pop());  // --> 1
        System.out.println(s1.peek());  // --> 3

        Stack s2 = new Stack();
        s2.pop();
        s2.push(9);
        s2.push(8);
        System.out.println(s2.peek());  // --> 8
    }
}
