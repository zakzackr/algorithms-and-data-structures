class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> reproduceByN(SinglyLinkedListNode<Integer> head, int n){
        // headから独立した新しい連結リストを作成
        SinglyLinkedListNode<Integer> newList = new SinglyLinkedListNode<>(null);
        // 連結リストの先頭のメモリアドレスを保存
        SinglyLinkedListNode<Integer> newHead = newList;

        for (int i = 0; i < n; i++){
            // 毎回currentNodeを先頭に戻す
            SinglyLinkedListNode<Integer> currentNode = head;            
            while(currentNode != null){
                newList.next = new SinglyLinkedListNode<Integer>(currentNode.data);
                newList = newList.next;
                currentNode = currentNode.next;
            }
        }
        
        return newHead.next;
    }

    // 別解
    // public static SinglyLinkedListNode<Integer> reproduceByN(SinglyLinkedListNode<Integer> head, int n){
    //     SinglyLinkedListNode<Integer> currentNode = head;
    //     // SinglyLinkedListNode<Integer> copyHead = head;  // shallow copy
    //     SinglyLinkedListNode<Integer> copyHead = createDeepCopy(head);  // deep copy

    //     for (int i = 1; i < n; i++){
    //         // 最後のノードまでたどる
    //         while (currentNode.next != null){
    //             currentNode = currentNode.next;
    //         }

    //         copyHead = createDeepCopy(copyHead);  // deep copyを更新
    //         System.out.println("reference to a deep copy of head: " + copyHead);
    //         currentNode.next = copyHead;
    //         currentNode = currentNode.next;
    //     }

    //     return head;
    // }

    // public static SinglyLinkedListNode<Integer> createDeepCopy(SinglyLinkedListNode<Integer> head){
    //     if (head == null) return null;

    //     SinglyLinkedListNode<Integer> newHead = new SinglyLinkedListNode<>(head.data);
    //     SinglyLinkedListNode<Integer> currentNode = newHead;

    //     while(head.next != null){
    //         head = head.next;
    //         currentNode.next = new SinglyLinkedListNode<Integer>(head.data);
    //         currentNode = currentNode.next;
    //     }

    //     return newHead;
    // }


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
        printList(reproduceByN(createLinkedList((arr1)), 0));
        printList(reproduceByN(createLinkedList((arr1)), 1));
        printList(reproduceByN(createLinkedList((arr1)), 2));
        printList(reproduceByN(createLinkedList((arr2)), 20));
        printList(reproduceByN(createLinkedList((arr3)), -1));
        printList(reproduceByN(createLinkedList((arr3)), 2));
    }
}
