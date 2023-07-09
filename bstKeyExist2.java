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
        if (mid - 1 >= start) left = sortedArrayToBSTHelper(nums, start, mid - 1);

        BinaryTree right = null;
        if (mid + 1 <= end) right = sortedArrayToBSTHelper(nums, mid + 1, end);

        BinaryTree root = new BinaryTree(nums[mid], left, right);
        return root;
    }

    // 再帰ではなく反復iteratorを使用する
    public static boolean keyExist(int key, BinaryTree bst){
        BinaryTree iterator = bst;
        while (iterator != null){
            if (iterator.data == key) return true;

            if (iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return false;
    }

    public static void main(String[] args){
        BinaryTree bst1 = sortedArrayToBST(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
        System.out.println(keyExist(0, bst1));
        System.out.println(keyExist(20, bst1));

        BinaryTree bst2 = sortedArrayToBST(new int[]{});
        System.out.println(keyExist(0, bst1));
    }
}
