class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }

    // 現在のノードの次に新たなノードを挿入する
    public void addNextNode(Node newNode){
        Node tempNode = this.next;
        this.next = newNode;
        newNode.next = tempNode;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]): null;

        Node currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    public void printList(){
        System.out.print("[");
        Node currentNode = this.head;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = {35,23,546,67,86,234,56,767,34,1,98,78,555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);
        numList.printList();

        // リストのindexが偶数の要素を2 倍にし、それぞれの要素の後ろに追加する
        Node iterator = numList.head;
        int i = 0;
        while (iterator != null){
            Node currentNode = iterator;
            iterator = iterator.next;
            if (i % 2 == 0) currentNode.addNextNode(new Node(currentNode.data * 2));
            i++;
        }

        numList.printList();
    }
}
