class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
    public Node head;
    public Node tail;

    public DoublyLinkedList(int[] arr){
        if (arr.length <= 0){
            this.head = null;
            this.tail = this.head;
            return;
        }

        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }

    // index+1 番目のnodeを返す
    public Node at(int index){
        if (this.head == null) return null;
        Node currentNode = this.head;

        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
            if (currentNode == null) return null;
        }

        return currentNode;
    }
}

class Main{
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {};
        DoublyLinkedList numList1 = new DoublyLinkedList(arr1);
        DoublyLinkedList numList2 = new DoublyLinkedList(arr2);

        System.out.println(numList1.at(0).data);
        System.out.println(numList1.at(5).data);
        System.out.println(numList1.at(100));
        System.out.println(numList2.at(1));
    }
}
