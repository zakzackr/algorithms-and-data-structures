class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> reverseLinkedList(SinglyLinkedListNode<Integer> head){
        SinglyLinkedListNode<Integer> prev = null;
        SinglyLinkedListNode<Integer> current = head;

        while(current != null){
            SinglyLinkedListNode<Integer> nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        head = prev;
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

    // 配列を受け取り連結リストを作成する関数
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
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {};

        SinglyLinkedListNode<Integer> head1 = createList(arr1);
        SinglyLinkedListNode<Integer> head2 = createList(arr2);

        printList(reverseLinkedList(head1));
        printList(reverseLinkedList(head2));
    }
}
