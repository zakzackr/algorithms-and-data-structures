import java.util.ArrayList;

class Item{
    public int data;
    public Item next;

    public Item(int data){
        this.data = data;
    }
}

class Stack{
    public Item head;  // デフォルトでnull

    public Stack(){};

    // Stackの先頭にItemを追加
    public void push(int data){
        Item temp = this.head;
        this.head = new Item(data);
        this.head.next = temp;
    }

    // Stackの先頭からItemをpopして、そのItemの値を返す
    public Integer pop(){
        if (this.head == null) return null;
        Item temp = this.head;
        this.head = this.head.next;
        return temp.data;
    } 

    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
}

class Main{
    // 単調増加する最後の部分配列を返す
    public static int[] consecutiveWalk(int[] arr){
        if (arr.length <= 0) return new int[0];
        Stack stack = new Stack();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if (stack.peek() >= arr[i]){
                while (stack.pop() != null);
            }
            stack.push(arr[i]);
        }

        ArrayList<Integer> resDynamic = new ArrayList<>();
        while (stack.peek() != null) resDynamic.add(0, stack.pop());
        // ArrayList<Integer> から int[]に変換
        int[] output = resDynamic.stream().mapToInt(Integer::intValue).toArray();

        return output;
    }

    public static void printList(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        printList(consecutiveWalk(new int[]{3,4,20,45,56,6,4,3,2,3,9}));
        printList(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54,4}));
        printList(consecutiveWalk(new int[0]));
        printList(consecutiveWalk(new int[]{1}));
    }
}
