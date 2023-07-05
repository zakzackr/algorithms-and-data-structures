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

    public void append(Node lastNode){
        if (this.head == null){
            this.head = lastNode;
            return;
        }

        Node iterator = this.head;
        while(iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = lastNode;
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
        int[] arr1 = {10, 20, 30, 40};
        int[] arr2 = {};
        SinglyLinkedList numList1 = new SinglyLinkedList(arr1);
        SinglyLinkedList numList2 = new SinglyLinkedList(arr2);
        numList1.append(new Node(50));
        numList2.append(new Node(10));

        numList1.printList();
        numList2.printList();
    }
}
