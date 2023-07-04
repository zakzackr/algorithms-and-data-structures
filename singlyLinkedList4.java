class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        // 配列に要素が存在しない場合はnullを格納
        this.head = arr.length > 0 ? new Node(arr[0]) : null;

        Node currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    public Node at(int index){
        if (this.head == null) return null;

        Node iterator = this.head;
        for (int i = 0; i < index; i++){
            // もしnextがnullの場合、nullを返す。これはインデックスが範囲外にあることを示す。
            iterator = iterator.next;
            if (iterator == null) return null;
        }

        return iterator;
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        SinglyLinkedList numList = new SinglyLinkedList(arr);
        System.out.println(numList.at(3).data);
        System.out.println(numList.at(4).data);
        System.out.println(numList.at(5));  // --> null
        
        // System.out.println(numList.at(5).data);  --> error
        // System.out.println(new Node(7).next.data);  --> error
    }
}
