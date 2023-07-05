class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }

    public void addNextNode(Node newNode){
        Node tempNode = this.next;
        this.next = newNode;
        newNode.next = tempNode;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]) : null;

        Node currentNode = this.head;
        for(int i=1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    public Node at(int index){
        Node iterator = this.head;
        for(int i=1; i < index; i++){
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }

    public void preappend(Node newNode){
        newNode.next = this.head;
        this.head = newNode;
    }

    public void popFront(){
        this.head = this.head.next;
    }

    public void delete(int index){
        if (index == 0) this.popFront();
        Node iterator = this.head;
        for(int i = 0; i < index-1; i++){
            if(iterator.next == null) return;
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;        
    }

    public void reverse(){
        Node prev = null;
        Node current = this.head; 

        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;  // 現在の反転リストの先頭のノードを渡す
            current = nextNode;
        }

        this.head = prev;
    }


    public void printList(){
        Node currentNode = this.head;
        System.out.print("[");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }
}

class Main{

    public static void main(String[] args){

        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);

        // 逆側に表示してみましょう。
        numList.printList();
        numList.reverse();
        numList.printList();
    }
}
