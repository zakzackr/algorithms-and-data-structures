class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static int linkedListLength(SinglyLinkedListNode<Integer> head){
        if (head == null) return 0;

        int count = 1;
        SinglyLinkedListNode<Integer> currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            count++;
        }

        return count;
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

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(linkedListLength(createLinkedList(arr)));
    }
}

