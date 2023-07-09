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

class Main{
    public static BinaryTree sortedArrayToBST(int[] nums){
        if (nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public static BinaryTree sortedArrayToBSTHelper(int[] nums, int start, int end){
        if (start == end) return new BinaryTree(nums[start], null, null);

        int mid = (start + end) / 2;

        BinaryTree left = null;
        if (mid - 1 >= start) left = sortedArrayToBSTHelper(nums, start, end - 1);
        
        BinaryTree right = null;
        if (mid + 1 <= end) right = sortedArrayToBSTHelper(nums, mid + 1, end);

        BinaryTree root = new BinaryTree(nums[mid], left, right);
        return root; 
    }

    public static boolean keyExist(int key, BinaryTree bst){
        if (bst == null) return false;
        if (bst.data == key) return true;

        if (key < bst.data) return keyExist(key, bst.left);
        else return keyExist(key, bst.right);
    }

    public static void main(String[] args){
        BinaryTree bst = sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(keyExist(5, bst));
        System.out.println(keyExist(0, bst));
        System.out.println(keyExist(9, bst));
    }
}
