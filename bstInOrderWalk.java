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

    public void printInOrder(){
        this.inOrderwalk(this);
    }

    public void inOrderwalk(BinaryTree tRoot){
        if (tRoot != null){
            inOrderwalk(tRoot.left);
            System.out.println(tRoot.data + " ");
            inOrderwalk(tRoot.right);
        }
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(ArrayList<Integer> dArr){
        this.generateRandomBST(dArr);
    }

    // オーバーロード
    public BinarySearchTree(int[] sortedArr){
        if (sortedArr.length <= 0) this.root = null;
        else this.root = sortedArrToBst(sortedArr, 0, sortedArr.length - 1);
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

    public BinaryTree insert(int data){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data > data  && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (iterator.data < data && iterator.right == null) iterator.right =  new BinaryTree(data);
            iterator = iterator.data > data? iterator.left: iterator.right;
        }

        return this.root;
    }

    public static int maximumDepth(BinaryTree root){
        if (root == null) return 0;
        int maxleft = maximumDepth(root.left);
        int maxright = maximumDepth(root.right);
        return (maxleft > maxright)? maxleft + 1: maxright + 1;
    }

    public void printSorted(){
        if (this.root == null) return;
        this.root.printInOrder();
    }

    // ソート済みの配列を受け取り、bstを作成する関数
    public static BinaryTree sortedArrToBst(int[] sortedArr, int start, int end){
        if (start == end) return new BinaryTree(sortedArr[start], null, null);

        int mid = (start + end) / 2;
        
        BinaryTree left = (start == mid)? null: sortedArrToBst(sortedArr, start, mid - 1);
        BinaryTree right = (mid == end)? null: sortedArrToBst(sortedArr, mid + 1, end);

        return new BinaryTree(sortedArr[mid], left, right);
    }
}

// 名前空間
class RandomContainer{
    // 昇順に並んだサイズ=sizeの配列を作成する関数
    public static ArrayList<Integer> generateList(int size){
        ArrayList<Integer> dArr = new ArrayList<>();
        for(int i = 0; i < size; i++) dArr.add(i);
        
        return dArr;
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree balancedBST = new BinarySearchTree(RandomContainer.generateList(8));
        balancedBST.printSorted();
        System.out.println("max depth: " + BinarySearchTree.maximumDepth(balancedBST.root));

        BinarySearchTree balancedBST2 = new BinarySearchTree(new ArrayList<Integer>());
        balancedBST2.printSorted();
        System.out.println("max depth: " + BinarySearchTree.maximumDepth(balancedBST2.root));

        BinarySearchTree balancedBST3 = new BinarySearchTree(new int[]{5, 10, 15, 20, 25, 30, 35});
        balancedBST3.printSorted();
        System.out.println("max depth: " + BinarySearchTree.maximumDepth(balancedBST3.root));

        BinarySearchTree balancedBST4 = new BinarySearchTree(new int[0]);
        balancedBST4.printSorted();
        System.out.println("max depth: " + BinarySearchTree.maximumDepth(balancedBST4.root));
    }
}