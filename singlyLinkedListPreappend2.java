class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> insertAtHead(SinglyLinkedListNode<Integer> head, int data){
        if (head == null) head = new SinglyLinkedListNode<Integer>(data);

        SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<>(data);
        newNode.next = head;
        head = newNode;

        return head;
    }

    public static void printList(SinglyLinkedListNode<Integer> head){
        SinglyLinkedListNode<Integer> currentNode = head;
        System.out.print("[");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    public static SinglyLinkedListNode<Integer> createList(int[] arr){
        if (arr.length == 0) return null;

        SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<>(arr[0]);
        SinglyLinkedListNode<Integer> currentNode = head;

        for (int i = 1; i < arr.length; i++){
            currentNode.next = new SinglyLinkedListNode<>(arr[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void main(String[] args){
        int[] arr1 = {10, 100, 1000, 10000};
        int[] arr2 = {};

        SinglyLinkedListNode<Integer> head1 = createList(arr1);
        SinglyLinkedListNode<Integer> head2 = createList(arr2);

        printList(insertAtHead(head1, 1));
        printList(insertAtHead(head2, 1));
    }
}

