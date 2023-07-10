import java.util.Arrays;

class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }

    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void inOrderwalk(BinaryTree root){
        if (root != null){
            inOrderwalk(root.left);
            System.out.println(root.data);
            inOrderwalk(root.right);
        }
    }

    public void printInOrder(){
        this.inOrderwalk(this);
    }
}

class BinarySearchTree{
    public BinaryTree root;
    
    public BinarySearchTree(int[] arr){
        if (arr.length == 0) this.root = null;
        Arrays.sort(arr);
        this.root = sortedBST(arr, 0, arr.length - 1);
    }

    public static BinaryTree sortedBST(int[] arr, int start, int end){
        if (start == end) new BinaryTree(arr[start], null, null);

        int mid = (start + end) / 2;

        BinaryTree left = (start == mid)? null: sortedBST(arr, start, mid - 1);
        BinaryTree right = (mid == end)? null: sortedBST(arr, mid + 1, end);

        return new BinaryTree(arr[mid], left, right);
    }

    // 新たなnodeをbstに追加する
    public void insert(int data){
        if (this.root == null) this.root = new BinaryTree(data);
        else {
            BinaryTree iterator = this.root;
            while (iterator != null){
                if (iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
                else if (iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
                iterator = (iterator.data > data)? iterator.left: iterator.right;
            }
        }
    }

    public void printSorted(){
        this.root.printInOrder();
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(new int[]{7, 2, 4, 3, 5, 1, 6});
        bst.printSorted();
        bst.insert(8);
        bst.printSorted();
        bst.insert(0);
        bst.insert(10);
        bst.insert(9);
        bst.printSorted();
    }
}
