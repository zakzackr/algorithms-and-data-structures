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

        Node iterator = this.head;
        for (int i = 1; i < arr.length; i++){
            iterator.next = new Node(arr[i]);
            iterator = iterator.next;
        }
    }

    public void preappend(Node newNode){
        newNode.next = this.head;
        this.head = newNode;
    }

    public void printList(){
        Node currentNode = this.head;
        System.out.print("[");
        while (currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = {12, 23, 34, 45, 56};
        SinglyLinkedList numList = new SinglyLinkedList(arr);

        numList.printList();
        numList.preappend(new Node(11));
        numList.printList();
    }
}
