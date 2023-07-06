class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
    public Node head;
    public Node tail;

    public DoublyLinkedList(int[] arr){
        // 配列空の場合
        if (arr.length <= 0){
            this.head = null;
            this.tail = this.head;
            return;
        }

        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }

    // 連結リストのindex+1 番目のnodeを返す
    public Node at(int index){
        Node currentNode = this.head;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
            if (currentNode == null) return null;
        }

        return currentNode;
    }

    public void preappend(Node newNode){
        this.head.prev = newNode;
        newNode.next = this.head;
        newNode.prev = null;
        this.head = newNode;
    }

    public void append(Node newNode){
        this.tail.next = newNode;
        newNode.prev = this.tail;
        newNode.next = null;
        this.tail = newNode;
    }

    public void addNextNode(Node node, Node newNode){
        Node temp = node.next;
        node.next = newNode;
        newNode.next = temp;
        newNode.prev = node;

        if (node == this.tail) this.tail = newNode;
        else temp.prev = newNode;
    }

    // リストの先頭から要素を削除: O(1)
    public void popFront(){
        this.head = this.head.next;
        this.head.prev = null;
    }

    // リストの末尾からnodeを削除: O(1)
    public void pop(){
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

    // 双方向リストでは与えられたnodeを削除する場合、prevポインタで前のnodeを参照できる
    // O(1)で削除可能
    public void deleteNode(Node node){
        if (node == this.head) this.popFront();
        else if (node == this.tail) this.pop();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void reverse(){
        Node reverse = this.tail;
        Node iterator = this.tail.prev;

        Node currentNode = reverse;
        while(iterator != null){
            currentNode.next = iterator;  // reverseした連結リストの現在のnode
            iterator = iterator.prev;  // 元の連結リストを逆から辿る時の現在のnode
            if (iterator != null) iterator.next = null;

            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        
        this.tail = currentNode;
        this.head = reverse;
        this.head.prev = null;
    }

    public void printList(){
        Node currentNode = this.head;
        System.out.print("[");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    public void printInReverse(){
        Node currentNode = this.tail;
        System.out.print("[");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.prev;
        }
        System.out.println("]");
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = {21, 34, 46, 51, 60, 79, 81};
        DoublyLinkedList numList = new DoublyLinkedList(arr);
        numList.printList();

        // 19をpreappend, 0をpreappend
        numList.preappend(new Node(19));
        numList.preappend(new Node(0));
        numList.printList();

        // 91と103をappned
        numList.append(new Node(91));
        numList.append(new Node(103));
        numList.printList();

        // 先頭、末尾のnodeを削除
        numList.popFront();
        numList.pop();
        numList.printList();

        // 指定した場所にnodeを追加
        numList.addNextNode(numList.at(4), new Node(51));
        numList.printList();

        // 指定したnodeを削除
        numList.deleteNode(numList.at(5));
        numList.printList();

        numList.printInReverse();
        numList.reverse();
        numList.printList();

        // // 空の配列
        int[] emptyArr = {};
        DoublyLinkedList emptyNumList = new DoublyLinkedList(emptyArr);
        emptyNumList.printList();  

        // append()やpop() 等にthis.head == nullの時などの処理が必要
        // emptyNumList.preappend(new Node(100));
    }
}

