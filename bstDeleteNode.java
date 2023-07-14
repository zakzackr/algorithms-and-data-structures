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

    public void inOrderWalk(BinaryTree root){
        if (root != null){
            inOrderWalk(root.left);
            System.out.print(root.data + " ");
            inOrderWalk(root.right);
        }
    }

    public void printInOrder(){
        this.inOrderWalk(this);
        System.out.println(" ");
    }
}

class BinarySearchTree{
    public BinaryTree root;

    // 配列を受け取りbstを作成する
    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = sortedBST(arr, 0, arr.length - 1);
    }

    // ソート済みの配列からbstを作成する
    public static BinaryTree sortedBST(int[] sortedArr, int start, int end){
        // 葉ノード
        if (start == end) return new BinaryTree(sortedArr[start], null, null);

        int mid = (start + end) / 2;

        BinaryTree left = sortedBST(sortedArr, start, mid - 1);
        BinaryTree right = sortedBST(sortedArr, mid + 1, end);

        return new BinaryTree(sortedArr[mid], left, right);
    }

    // keyを値にもつノードがbst内に存在するかbooleanで返す
    public boolean keyExist(int key){
        BinaryTree iterator = this.root;

        while (iterator != null){
            if (iterator.data == key) return true;
            else if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return false;
    }

    // keyを値にもつbst内のノードを返す
    public BinaryTree search(int key){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data == key) return iterator;
            else if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return null;
    } 

    // 新しいノードをbstに挿入
    public void insert(int data){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = iterator.data > data ? iterator.left: iterator.right;
        }
    }

    //// bstからノードを削除する処理

    // nodeParentの子ノードをnodeからtargetに変更 
    // nodeの左or右部分木が空の時だけ使える
    public void transplant(BinaryTree nodeParent, BinaryTree node, BinaryTree target){
        if (nodeParent == null) this.root = target;
        else if (nodeParent.left == node) nodeParent.left = target;
        else nodeParent.right = target;
    }

    public void deleteNode(int key){
        if (this.root == null) return;
        if (!keyExist(key)) return;
        // 削除したいノード
        BinaryTree node = this.search(key);

        BinaryTree parent = this.findParent(node);
        // case1: nodeが葉ノードの時
        if (node.left == null & node.right == null){
            if (parent.left == node) parent.left = null;
            else if (parent.right == node) parent.right = null;
            // else parent.right = null;
        }
        // case2: nodeに左部分木が存在しない時(nodeが1つの子しか持たない時)
        if (node.left == null) this.transplant(parent, node, node.right);
        // case3: nodeに右部分木が存在しない時
        else if (node.right == null) this.transplant(parent, node, node.left);
        // case4: nodeが２つの子を持っている時
        else {
            BinaryTree successor = this.findSuccessor(node);
            BinaryTree successorP = this.findParent(successor);
            // case4-1: そのうちnodeの子ノードがsuccessorの時: この場合nodeの親であるparentの部分木にsuccessorを移植する
            // case4-2: successorがnodeの部分木の深層部にある時: if文の処理実行
            if (node.right != successor){
                // 後継ノードsuccessorをその右部分木で移植する
                this.transplant(successorP, successor, successor.right);
                successor.right = node.right;  // successorの右部分木を更新する
            }
            this.transplant(parent, node, successor);  // nodeをsuccessorで移植する
            successor.left = node.left;  // successorの左部分木を更新する
        }
    }

    public BinaryTree findParent(BinaryTree node){
        BinaryTree iterator = this.root;  // 根ノードから順に辿って探す
        BinaryTree parent = null;
        while (iterator.data != node.data){
            parent = iterator;
            iterator = iterator.data > node.data? iterator.left: iterator.right;
        }

        return parent;
    }

    // 後継ノードを探す
    // 後継ノード：該当ノードの値よりも大きく、それらの中で最も小さい値を持つノード
    public BinaryTree findSuccessor(BinaryTree node){
        BinaryTree targetNode = node;
        if (targetNode == null) return null;
        // 後継ノードがtargetNodeの右の部分木に存在する場合
        if (targetNode.right != null) return this.minimumNode(targetNode.right);

        // targetNodeに右の部分木が存在せず、bst内を順に辿ることによって後継ノードを探す場合
        BinaryTree successor = null;
        BinaryTree iterator = this.root;

        while (iterator != null){
            if (targetNode.data == iterator.data) return successor;
            if (targetNode.data < iterator.data && (successor == null || iterator.data == successor.data)) successor = iterator;
            // 条件に応じてiteratorをアップデートする
            if (targetNode.data > iterator.data) iterator = iterator.left;
            else iterator = iterator.right;
        }
        
        return successor;
    }

    public BinaryTree minimumNode(BinaryTree node){
        BinaryTree iterator = node;
        while (iterator != null && iterator.left != null) iterator = iterator.left;

        return iterator;
    }

    public void printSorted(){
        this.root.printInOrder();
    }
}


class Main{
    public static void main(String[] args){
        // BinarySearchTree bst = new BinarySearchTree(new int[]{8, 1, 7, 2, 6, 3, 5, 4, 9, 10});
        // bst.printSorted();

        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{4,43,36,46,32,7,97,95,34,8,96,35,85,1010,232});
        balancedBST.printSorted();
        balancedBST.deleteNode(43);
        balancedBST.printSorted();
        balancedBST.deleteNode(7);
        balancedBST.printSorted();
        balancedBST.deleteNode(4);
        balancedBST.printSorted();
        balancedBST.deleteNode(1010);
        balancedBST.printSorted();
        // 存在しない0をdeleteNodeする
        balancedBST.deleteNode(0);
        balancedBST.printSorted();   
        // 要素を新たに追加
        balancedBST.insert(2020);
        balancedBST.printSorted();
    }
}
