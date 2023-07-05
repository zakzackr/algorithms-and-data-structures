class SinglyLinkedListNode<E>{
    public E data;
    public SinglyLinkedListNode<E> next;

    public SinglyLinkedListNode(E data){
        this.data = data;
        this.next = null;
    }
}

class Main{
    public static int getIndexValue(SinglyLinkedListNode<Integer> head, int index){
        if (index == 1) return head.data;
        return getIndexValue(head.next, index - 1);
    }

    public static void main(String[] args){
        // 連結リストを作成
        int[] arr = {1, 2, 3, 4, 5};
        SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<>(arr[0]);
        SinglyLinkedListNode<Integer>  currentNode = head;

        for (int i = 1; i < arr.length; i++){
            currentNode.next = new SinglyLinkedListNode<>(arr[i]);
            currentNode = currentNode.next;
        }

        System.out.println(getIndexValue(head, 1));
        System.out.println(getIndexValue(head, 4));
    }
}
