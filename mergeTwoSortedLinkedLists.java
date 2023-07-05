class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    // ソート済みの2つの連結リストの先頭ノードを受け取り、それらのマージ後のソート済み連結リストの結果を返す
    public static SinglyLinkedListNode<Integer> mergeTwoSortedLinkedLists(SinglyLinkedListNode<Integer> head1, SinglyLinkedListNode<Integer> head2){
        SinglyLinkedListNode<Integer> currentNode1 = head1;
        SinglyLinkedListNode<Integer> currentNode2 = head2;
        // マージしたリストを格納するための連結リストを作成
        SinglyLinkedListNode<Integer> newHead = new SinglyLinkedListNode<>(Integer.MIN_VALUE);
        SinglyLinkedListNode<Integer> currNewNode =  newHead;

        // breakするまで繰り返す
        while(true){
            if (currentNode1 == null){
                currNewNode.next = currentNode2;
                break;
            }

            if (currentNode2 == null){
                currNewNode.next = currentNode1;
                break;
            }

            if (currentNode1.data <= currentNode2.data){
                currNewNode.next = currentNode1;
                currentNode1 = currentNode1.next;
            } else {
                currNewNode.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            currNewNode = currNewNode.next;
        }

        return newHead.next;
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
        int[] arr2 = {2, 4, 6, 8};
        // int[] arr2 = {};　--> [1, 3, 5, 7, 9]
        SinglyLinkedListNode<Integer> head1 = createList(arr1);
        SinglyLinkedListNode<Integer> head2 = createList(arr2);

        printList(mergeTwoSortedLinkedLists(head1, head2));
    }
}
