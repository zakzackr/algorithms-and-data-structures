class Item{
    public int data;
    public Item next;

    public Item(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Item head;

    public SinglyLinkedList(Item head){
        this.head = head;
    }
}

class Main{
    public static void main(String[] args){
        Item item1 = new Item(2);
        Item item2 = new Item(100);
        Item item3 = new Item(16);

        item1.next = item2;
        item2.next = item3;

        SinglyLinkedList numList = new SinglyLinkedList(item1);
        // numList.head.next = item2;
        // numList.head.next.next = item3;

        Item iterator = numList.head;
        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }
}

