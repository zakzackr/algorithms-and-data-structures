class Node{
    public int data;
    public Node prev;  
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
    public Node head;  
    public Node tail;

    public DoublyLinkedList(int[] arr){
        if(arr.length <= 0){
            this.head = null;
            this.tail = this.head;
            return;
        }

        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for(int i=1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }

    public Node at(int index){
        Node iterator = this.head;
        for (int i = 0; i < index; i++){
            iterator = iterator.next;
            if (iterator == null) return null;
        }

        return iterator;
    }

    // リストの先頭に追加する
    public void preappend(Node newNode){
        this.head.prev = newNode;
        newNode.next = this.head;
        newNode.prev = null;
        this.head = newNode;
    }    

    // リストの最後に追加する
    public void append(Node newNode){
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.tail.next = null;
    }

    // 与えられたノードの次に追加する
    public void addNextNode(Node node, Node newNode){
        if (this.head == null) return;

        Node temp = node.next;
        node.next = newNode;
        newNode.next = temp;
        newNode.prev = node;

        // nodeがリストの末尾ノードのとき
        if (node == this.tail) this.tail = newNode;
        else temp.prev = newNode;
    }

    // リストを逆向きに変更する reverse
    public void reverse(){
        Node reverse = this.tail;  // 逆にした連結リストの先頭
        Node iterator = this.tail.prev;  // 元の連結リストを辿っていくときの現在のnode

        Node currentNode = reverse;
        while(iterator != null){
            currentNode.next = iterator;
            iterator = iterator.prev;
            if (iterator != null) iterator.next = null;
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }

        this.head = reverse;
        this.tail = currentNode;
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
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        DoublyLinkedList numList = new DoublyLinkedList(arr);

        numList.printList();

        // 45をpreappend
        numList.preappend(new Node(45));
        System.out.println(numList.head.data);
        numList.printList();

        // 71をappend
        numList.append(new Node(71));
        System.out.println(numList.tail.data);
        numList.printList();

        // ノードの後に新しいノードを追加
        numList.addNextNode(numList.at(3), new Node(4));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.addNextNode(numList.at(15), new Node(679));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.printInReverse();
    }
}
