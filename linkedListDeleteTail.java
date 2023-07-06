class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> deleteTail(SinglyLinkedListNode<Integer> head){
        if (head == null || head.next == null) return null;
        
        SinglyLinkedListNode<Integer> currentNode = head;
        while(currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = null;

        return head;
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
        int[] arr = {34,35,64,34,10,2,14,5,353,23,35,63,23};
        printList(deleteTail(createLinkedList((arr))));
    }
}
