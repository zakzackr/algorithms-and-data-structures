class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    // オーバーロード
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
    // ソート済みのリストから平行二分探索木を作成する関数
    public static BinaryTree sortedArrayToBST(int[] nums){
        if (nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public static BinaryTree sortedArrayToBSTHelper(int[] nums, int start, int end){
        if (start == end) return new BinaryTree(nums[start], null, null); // ベースケース

        // 部分木の根ノードとなる配列の真ん中の値のindex
        int mid = (start + end) / 2;

        // 左の部分木を作成する
        BinaryTree left = null;
        if (mid - 1 >= start) left = sortedArrayToBSTHelper(nums, start, mid - 1);

        // 右の部分木を作成する
        BinaryTree right = null;
        if (mid + 1 <= end) right = sortedArrayToBSTHelper(nums, mid + 1, end);

        BinaryTree root = new BinaryTree(nums[mid], left, right);
        return root;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree balancedBST1 = sortedArrayToBST(nums1);
        BinaryTree balancedBST2 = sortedArrayToBST(nums2);

        System.out.println(balancedBST1.data);
        System.out.println(balancedBST1.left.data);
        System.out.println(balancedBST1.left.right.data);
        System.out.println(balancedBST2.data);
        System.out.println(balancedBST2.right.data);
    }
}
