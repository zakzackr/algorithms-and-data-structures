import java.util.*;

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

    public void reverseInOrderWalk(BinaryTree root){
        if (root != null){
            reverseInOrderWalk(root.right);
            System.out.println(root.data + " ");
            reverseInOrderWalk(root.left);
        }
    }

    public void printReverseInOrder(){
        this.reverseInOrderWalk(this);
    }
}

class BinarySearchTree{
    public BinaryTree root;
    
    public BinarySearchTree(ArrayList<Integer> dArr){
        this.generateRandomBST(dArr);
    }

    public void generateRandomBST(ArrayList<Integer> dArr){
        if (dArr.isEmpty()) this.root = null;
        else {
            Collections.shuffle(dArr);
            this.root = new BinaryTree(dArr.get(0));
            for (int i = 1; i < dArr.size(); i++){
                this.insert(dArr.get(i));
            }
        }
    }

    public void insert(int data){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = (iterator.data > data)? iterator.left: iterator.right; 
        }
    }

    public void printSorted(){
        this.root.printReverseInOrder();
    }
}

// 名前空間
class RandomContainer{
    public static ArrayList<Integer> createDArr(int size){
        ArrayList<Integer> dArr = new ArrayList<>();
        for (int i = 0; i < size; i++) dArr.add(i);

        return dArr;
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(RandomContainer.createDArr(15));
        bst.printSorted();
    }
}
