class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> insertAtPosition(SinglyLinkedListNode<Integer> head, int position, int data){
        SinglyLinkedListNode<Integer> currentNode = head;
        int idx = 0;
        SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<>(data);

        while(currentNode != null){
            if (idx == position){
                SinglyLinkedListNode<Integer> temp = currentNode.next;
                currentNode.next = newNode;
                newNode.next = temp;
            }
            currentNode = currentNode.next;
            idx++;
        }

        return head;

        // for文で
        // for (int i = 0; i < position; i++){
        //     if (currentNode == null) return head;
        //     currentNode = currentNode.next;
        // }

        // SinglyLinkedListNode<Integer> temp = currentNode.next;
        // currentNode.next = newNode;
        // newNode.next = temp;
    }

    public static SinglyLinkedListNode<Integer> createLinkedList(int[] arr){
        if (arr.length <= 0) return null;

        SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<>(arr[0]);
        SinglyLinkedListNode<Integer> currentNode = head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new SinglyLinkedListNode<>(arr[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void printList(SinglyLinkedListNode<Integer> head){
        System.out.print("[");
        SinglyLinkedListNode iterator = head;

        while(iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int[] arr2 = {};
        int[] arr3 = {1};
        printList(insertAtPosition(createLinkedList((arr1)), 5, 7));
        printList(insertAtPosition(createLinkedList((arr2)), 3, 100));
        printList(insertAtPosition(createLinkedList((arr3)), 0, 100));
    }
}
