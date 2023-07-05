class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static SinglyLinkedListNode<Integer> insertHeadTail(SinglyLinkedListNode<Integer> head, int data){
        // 先頭と末尾に追加するNode
        SinglyLinkedListNode<Integer> newHead = new SinglyLinkedListNode<>(data);
        SinglyLinkedListNode<Integer> newTail = new SinglyLinkedListNode<>(data);

        // 空の連結リストが与えられた場合
        if (head == null){
            newHead.next = newTail;
            return newHead;
        }

        newHead.next = head;
        SinglyLinkedListNode<Integer> currentNode = newHead;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newTail;

        return newHead;
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

        printList(insertHeadTail(createList(arr1), 100));
        printList(insertHeadTail(createList(arr2), 100));
    }
}

