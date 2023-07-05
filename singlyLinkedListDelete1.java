class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]): null;

        Node currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    // 最初の要素を削除: O(1)
    public void popFront(){
        if (this.head == null) return;
        this.head = this.head.next;
    }

    // indexの要素を削除: O(n)
    public void delete(int index){
        if (this.head == null) return;
        if (index == 0){
            this.popFront();
            return;
        }

        Node currentNode = this.head;
        for (int i = 0; i < index-1; i++){
            if (currentNode.next == null) return;
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
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
}

class Main{
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};

        SinglyLinkedList numList1 = new SinglyLinkedList(arr1);
        SinglyLinkedList numList2 = new SinglyLinkedList(arr2);

        numList1.delete(1);
        numList1.delete(3);
        numList1.delete(100);
        numList2.delete(1);
        numList2.popFront();

        numList1.printList();
        numList2.printList();
    }
}
