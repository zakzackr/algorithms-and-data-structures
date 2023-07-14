import java.util.Arrays;
import java.util.ArrayList;
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

    public void inOrderwalk(BinaryTree root){
        if (root != null){
            inOrderwalk(root.left);
            System.out.print(root.data + " ");
            inOrderwalk(root.right);
        }
    }

    public void printInOrder(){
        this.inOrderwalk(this);
        System.out.println("");
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(ArrayList<Integer> arrList){
        this.generateRandomBST(arrList);
    }

    public void generateRandomBST(ArrayList<Integer> arrList){
        if (arrList.isEmpty()) this.root = null;
        else {
            Collections.shuffle(arrList);
            this.root = new BinaryTree(arrList.get(0));
            for (int i = 1; i < arrList.size(); i++){
                this.insert(arrList.get(i));
            }
        }
    }

    public void insert(int data){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = iterator.data > data? iterator.left: iterator.right;
        }
    }

    public void printSorted(){
        this.root.printInOrder();
    }
}

class RandomContainer{
    // 昇順に並んだ配列を作成
    public static ArrayList<Integer> generateList(int size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) list.add(i);

        return list;
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(RandomContainer.generateList(16));
        bst.printSorted();

        bst.insert(16);
        bst.printSorted();
    }
}
