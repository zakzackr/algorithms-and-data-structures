// stackは先頭を定義し、先頭に要素を追加・削除する

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head;

    public Stack(){
        this.head = null;
    }

    // public Stack(){};

    public void push(int data){
        Node temp = this.head;
        this.head = new Node(data);
        this.head.next = temp;
    }

    // nullはintタイプではない
    // Integerタイプはnullを返すことができる
    public Integer pop(){
        if (this.head == null) return null;
        Node temp = this.head;
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
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.pop();
        System.out.println(stack.peek());   

        stack.pop();
        stack.pop();
        System.out.println(stack.peek());   
    }
}
