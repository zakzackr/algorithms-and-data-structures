class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> insertNodeInSorted(SinglyLinkedListNode<Integer> head, int data){
        // Integerの最小値を要素にもつダミーノードを作成する
        SinglyLinkedListNode<Integer> dummyNode = new SinglyLinkedListNode<>(Integer.MIN_VALUE);

        // dummyNodeを連結リストの先頭にする
        dummyNode.next = head;
        SinglyLinkedListNode<Integer> currentNode = dummyNode;
        
        while (currentNode.next != null && currentNode.next.data < data){
            currentNode = currentNode.next;
        }

        // 挿入するノード
        SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<>(data);
        // 新しいノードを挿入する
        SinglyLinkedListNode<Integer> temp = currentNode.next;
        currentNode.next = newNode;
        newNode.next = temp;

        return dummyNode.next;
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
        printList(insertNodeInSorted(createLinkedList((arr1)), 7));
        printList(insertNodeInSorted(createLinkedList((arr2)), 100));
        printList(insertNodeInSorted(createLinkedList((arr3)), -1));
        printList(insertNodeInSorted(createLinkedList((arr3)), 2));
    }
}
