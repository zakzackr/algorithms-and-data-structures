class Item{
    public int data;
    public Item next;
    public Item prev;

    public Item(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
    public Item head;
    public Item tail;

    public DoublyLinkedList(int[] arr){
        if (arr.length <= 0){
            this.head = null;
            this.tail = this.head;
            return;
        }

        this.head = new Item(arr[0]);
        Item currentNode = this.head;
        for (int i = 1; i < arr.length; i++){
            currentNode.next = new Item(arr[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }
}

class MyClass{
    public static void main(String[] args){
        DoublyLinkedList numList = new DoublyLinkedList(new int[]{1,2,3,4,5,6,7});
        System.out.println(numList.head.data);
        System.out.println(numList.head.next.data);
        System.out.println(numList.head.next.prev.data);
        System.out.println(numList.tail.data);
        System.out.println(numList.tail.prev.data);
        System.out.println(numList.tail.prev.prev.data);
    }
}
