// [0, 1, 2, 3, 4] -> 5
// [0, 2, 3, 4, 5] -> 1

class Main{
    public static int smallestMissingNumber(int[] arr){
        return smallestMissingNumberHelper(arr, 0, arr.length - 1);
    }

    public static int smallestMissingNumberHelper(int[] arr, int start, int end){
        // ベースケース
        if (start == end){
            return (arr[start] != start) ? start : start + 1;
        }

        int middle = (start + end) / 2;

        // 欠番はIdx middleよりも左側に
        if (arr[middle] != middle){
            return smallestMissingNumberHelper(arr, start, middle);
        } 
        //　欠番はIdx middleよりも右側に
        else {
            return smallestMissingNumberHelper(arr, middle + 1, end);
        }
    }

    public static void main(String[] args){
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {0, 2, 3, 4, 5};
        int[] arr3 = {0, 1, 2, 3, 4, 6};

        System.out.println(smallestMissingNumber(arr1));
        System.out.println(smallestMissingNumber(arr2));
        System.out.println(smallestMissingNumber(arr3));
    }
}

//  再帰関数を用いない方法
// class Main{
//     public static int smallestMissingNumber(int[] arr){
//         // 関数を完成させてください
//         for (int i = 0; i <= arr[arr.length-1]; i++){
//             if (arr[i] != i) return i;
//         }

//         return arr[arr.length - 1] + 1;
//     }

//     public static void main(String[] args){
//         int[] arr1 = {0, 1, 2, 3, 4};
//         int[] arr2 = {0, 2, 3, 4, 5};
//         int[] arr3 = {0, 1, 2, 3, 4, 6};

//         System.out.println(smallestMissingNumber(arr1));
//         System.out.println(smallestMissingNumber(arr2));
//         System.out.println(smallestMissingNumber(arr3));
//     }
// }
