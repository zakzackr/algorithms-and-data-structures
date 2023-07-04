class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static void printList(SinglyLinkedListNode<Integer> head){
        SinglyLinkedListNode iterator = head;

        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

    // クラス定義時に<E>のようにジェネリクスを定義しているため、実装時に<Integer>などの型パラメータを渡していない場合、
    // Note: Main.java uses unchecked or unsafe operations.
    // Note: Recompile with -Xlint:unchecked for details.  
    // エラーがでる（非推奨だが実行はできる）。

    public static SinglyLinkedListNode<Integer> getLinkedList(int[] arr){
        SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<>(arr[0]);

        SinglyLinkedListNode<Integer> currentNode = head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new SinglyLinkedListNode<Integer>(arr[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void main(String[] args){
        int[] arr = {34,35,64,34,10,2,14,5,353,23,35,63,23};
        printList(getLinkedList(arr));
    }
}
