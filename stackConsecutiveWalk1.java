import java.util.ArrayList;

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
    // 単調減少している最後の部分配列を取り出す
    public static int[] consecutiveWalk(int[] arr){
        Stack stack = new Stack();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (stack.peek() <= arr[i]){
                while (stack.pop() != null);
            }
            stack.push(arr[i]);
        }

        // NullPointerException...
        // for (int num: arr){
        //     if (stack.peek() <= num){
        //         while (stack.pop() != null);
        //     }
        //     stack.push(num);
        // }

        ArrayList<Integer> resDynamic = new ArrayList<>();
        while (stack.peek() != null) resDynamic.add(0, stack.pop());

        int[] res = new int[resDynamic.size()];
        for (int i = 0; i < res.length; i++) res[i] = resDynamic.get(i);

        return res;
    }

    public static void printList(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        printList(consecutiveWalk(new int[]{3,4,20,45,56,6,4,3,5,3,2})); 
        printList(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54}));
        printList(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54,4}));
    }
}
