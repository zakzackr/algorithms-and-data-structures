class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }

    public void addNewNode(SinglyLinkedListNode<E> newNode){
        SinglyLinkedListNode<E> temp = this.next;
        this.next = newNode;
        newNode.next = temp;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> doubleEvenNumber(SinglyLinkedListNode<Integer> head){
        if (head == null) return null;

        SinglyLinkedListNode<Integer> iterator = head;
        int i = 0;

        while(iterator != null){
            SinglyLinkedListNode<Integer> currentNode = iterator;
            iterator = iterator.next;
            if (i % 2 == 0){
                SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<>(currentNode.data * 2);
                currentNode.addNewNode(newNode);
            }
            i++;
        }

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

    public static void main(String[] args){
        // creating a singlyLinkedList
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<>(arr[0]);
        SinglyLinkedListNode<Integer> iterator = head;
        for (int i = 1; i < arr.length; i++){
            iterator.next = new SinglyLinkedListNode<Integer>(arr[i]);
            iterator = iterator.next;
        }

        printList(head);
        printList(doubleEvenNumber(head));
    }
}

