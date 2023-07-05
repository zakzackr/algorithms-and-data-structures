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
        for(int i=0; i < index; i++){
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }

    // リストを逆向きに変更する reverse
    public void reverse(){
        if (this.head == null) return;

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
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        int[] arr2 = {};
        DoublyLinkedList numList1 = new DoublyLinkedList(arr1);
        DoublyLinkedList numList2 = new DoublyLinkedList(arr2);

        numList1.printList();
        numList1.printInReverse();
        numList1.reverse();
        numList1.printList();
        numList2.printInReverse();
        numList2.reverse();
        numList2.printList();
    }
}
