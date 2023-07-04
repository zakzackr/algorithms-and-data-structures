// 分割統治法: divide-and-conquer method

class Main{
    public static int sumOfArray(int[] arr){
        return sumOfArrayHelper(arr, 0, arr.length - 1);
    }

    // 補助関数でindexを追跡する
    public static int sumOfArrayHelper(int[] arr, int start, int end){
        if (start == end) return arr[start];  // ベースケース

        int middle = (start + end) / 2;
        
        int leftArr = sumOfArrayHelper(arr, start, middle);
        int rightArr = sumOfArrayHelper(arr, middle + 1, end);

        return leftArr + rightArr;
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(sumOfArray(arr1));
        System.out.println(sumOfArray(arr2));
    }
}
