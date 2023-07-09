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
}

class BinarySearchTree{
    public BinaryTree root;

    // 配列を受け取りコンストラクタ内で平衡二分探索木を作成する
    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = sortedArrayToBST(arr, 0, arr.length - 1);
    }

    public BinaryTree search(int key){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data == key) return iterator;
            if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return iterator;
    }

    public boolean keyExist(int key){
        BinaryTree iterator = this.root;
        while (iterator != null){
            if (iterator.data == key) return true;
            if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return false;
    }

    public static BinaryTree sortedArrayToBST(int[] nums, int start, int end){
        if (nums.length == 0) return null; 

        // ベースケース
        if (start == end) return new BinaryTree(nums[start], null, null);

        int mid = (start + end) / 2;

        BinaryTree left = null;
        if (mid - 1 >= start) left = sortedArrayToBST(nums, start, end - 1);

        BinaryTree right = null;
        if (mid + 1 <= end) right = sortedArrayToBST(nums, end + 1, end);

        BinaryTree root = new BinaryTree(nums[mid], left, right);
        return root;
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(new int[]{8, 6, 4, 2, 1, 3, 5, 7});
        System.out.println(bst.search(8).data);
        System.out.println(bst.keyExist(8));
        System.out.println(bst.keyExist(100));

        // 空のbst
        BinarySearchTree emptyBst = new BinarySearchTree(new int[]{});
        System.out.println(emptyBst.search(8));
        System.out.println(emptyBst.keyExist(8));
    }
}
