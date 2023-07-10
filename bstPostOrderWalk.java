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

    public void postOrderWalk(BinaryTree root){
        if (root != null){
            postOrderWalk(root.left);
            postOrderWalk(root.right);
            System.out.println(root.data);
        }
    }

    public void printOrder(){
        this.postOrderWalk(this);
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] arr){
        if (arr.length == 0) this.root = null;
        else {
            Arrays.sort(arr);
            this.root = sortedArrayToBST(arr, 0, arr.length - 1);
        }
    }

    public static BinaryTree sortedArrayToBST(int[] sortedArr, int start, int end){
        if (start == end) return new BinaryTree(sortedArr[start], null, null);

        int mid = (start + end) / 2;

        BinaryTree left = (start == mid)? null: sortedArrayToBST(sortedArr, start, mid - 1);
        BinaryTree right = (end == mid)? null: sortedArrayToBST(sortedArr, mid + 1, end);

        return new BinaryTree(sortedArr[mid], left, right);
    }

    public void printSorted(){
        this.root.printOrder();
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(new int[]{5, 10, 15, 20, 25, 30, 35});
        bst.printSorted();
    }
}
