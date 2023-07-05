class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    // 真ん中のnodeを返す関数
    public static SinglyLinkedListNode<Integer> middleNode(SinglyLinkedListNode<Integer> head){
        SinglyLinkedListNode<Integer> slow = head;  // 通常のスピードで進む
        SinglyLinkedListNode<Integer> fast = head;  // 2倍のスピードで進む

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    // 別解
    
    // public static SinglyLinkedListNode<Integer> middleNode(SinglyLinkedListNode<Integer> head){
    //     int length = getLength(head);
    //     int middle = length / 2;

    //     SinglyLinkedListNode<Integer> iterator = head;
    //     for (int i = 0; i < middle; i++){
    //         iterator = iterator.next;
    //     }

    //     return iterator;
    // }

    // public static int getLength(SinglyLinkedListNode<Integer> head){
    //     if (head == null) return 0;

    //     SinglyLinkedListNode<Integer> iterator = head;
    //     int count = 1;

    //     while(iterator.next != null){
    //         iterator = iterator.next;
    //         count++;
    //     }

    //     return count;
    // }

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

        printList(middleNode(createList(arr1)));
        printList(middleNode(createList(arr2)));
    }
}

