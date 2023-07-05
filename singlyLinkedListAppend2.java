class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    // 連結リストの末尾に要素を追加する関数
    public static SinglyLinkedListNode<Integer> insertAtTail(SinglyLinkedListNode<Integer> head, int data){
        if (head == null){
            head = new SinglyLinkedListNode<Integer>(data);
            return head;
        }

        SinglyLinkedListNode<Integer> currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new SinglyLinkedListNode<Integer>(data);

        return head;
    }

    // 連結リストをプリントする関数
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
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};

        printList(insertAtTail(createList(arr1), 6));
        printList(insertAtTail(createList(arr2), 6));
    }
}

