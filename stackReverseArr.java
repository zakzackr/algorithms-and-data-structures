class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head;

    public Stack(){};

    public void push(int data){
        Node temp = this.head;
        this.head = new Node(data);
        this.head.next = temp;

    }

    public Integer pop(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }

    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
}

class Main{
    public static int[] reverse(int[] arr){
        Stack stack = new Stack();
        int[] output = new int[arr.length];

        for (int num: arr){
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++){
            output[i] = stack.pop();
        }

        return output;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        printArr(arr);
        printArr(reverse(arr));

        int[] arr1 = {};
        printArr(arr1);
        printArr(reverse(arr1));
    }
}

