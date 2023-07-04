class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int arr[]){
        this.head = arr.length > 0 ? new Node(arr[0]) : null;

        Node currentNode = this.head;
        // 連結リストをプリント
        System.out.print("[");
        for (int i = 1; i < arr.length; i++){
            System.out.print(currentNode.data + " ");
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    // keyと同じデータを持つNodeのindexを返す。
    public int findNode(int key){
        if (this.head == null) return -1;
        
        Node iterator = this.head;
        int count = 0;
        while(iterator != null){
            if (iterator.data == key) return count;
            iterator = iterator.next;
            count++;
        }

        return -1;
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = {20, 40, 60, 50, 30, 10};
        SinglyLinkedList numList = new SinglyLinkedList(arr);
        System.out.println(numList.findNode(20));
        System.out.println(numList.findNode(50));
        System.out.println(numList.findNode(200));
    }
}
