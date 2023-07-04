class Node{
    public int data;
    public Node next;

    // null will be automatically assigned to the next variable
    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(Node head){
        this.head = head;
    }
}

class Main{
    // printing each element of a singlyLinkedList
    public static void printNumList(SinglyLinkedList numList){
        Node iterator = numList.head;

        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

    public static void main(String[] args){
        int[] intArr = {35,23,546,67,86,234,56,767,34,1,98,78,555};
        // creating a singlyLinkedList
        SinglyLinkedList numList = new SinglyLinkedList(new Node(intArr[0]));
        Node currentNode = numList.head;
        for (int i = 1; i < intArr.length; i++){
            currentNode.next = new Node(intArr[i]);
            currentNode = currentNode.next;
        }

        printNumList(numList);
    }
}
