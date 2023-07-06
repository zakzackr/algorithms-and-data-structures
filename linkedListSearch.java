class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static int linkedListSearch(SinglyLinkedListNode<Integer> head, int data){
        SinglyLinkedListNode<Integer> currentNode = head;
        int idx = 0;

        while (currentNode != null){
            if (currentNode.data == data) return idx;
            currentNode = currentNode.next;
            idx++;
        }

        return -1;
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
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(linkedListSearch(createLinkedList(arr), 5));
        System.out.println(linkedListSearch(createLinkedList(arr), 10));
    }
}
