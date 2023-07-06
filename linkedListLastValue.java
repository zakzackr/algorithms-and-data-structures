class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static int linkedListLastValue(SinglyLinkedListNode<Integer> head){
        SinglyLinkedListNode<Integer> currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }

        return currentNode.data;
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
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(linkedListLastValue(createLinkedList(arr)));
    }
}

