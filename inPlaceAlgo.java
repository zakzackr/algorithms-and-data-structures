import java.util.Arrays;
// 時間計算量0(n)
// 空間計算量O(1): in-place algo.

// ids = [1,2,3,4,5], n=2
// step1. [1,2,3,4,5] -> [5,4,3,2,1]
// step2. idx:0~n-1までの部分を逆にする: [4,5,3,2,1], n=2
// step3. idx:n~最後までを逆にする: [4,5,1,2,3]

class Main{
    public static void reverseInPlace (int[] arr, int start, int end){
        int middle = (int)Math.floor((start + end) / 2);
        for (int i = start; i <= middle; i++){

            int opposite = start + (end - i);
            int temp = arr[i];
            arr[i] = arr[opposite];
            arr[opposite] = temp;
        }
    }

    public static int[] rotateByTimes(int[] ids, int n){
        int r = n % ids.length;
        if (r == 0) return ids;

        int last = ids.length - 1;

        reverseInPlace(ids, 0, last);  // step1
        reverseInPlace(ids, 0, r - 1);  // step2
        reverseInPlace(ids, r, last);  // step3

        return ids;
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] test1 = {1,2,3,4,5};
        int[] test2 = {4,230,104,435,500,3};

        printArr(rotateByTimes(test1, 2));  // --> [4,5,1,2,3]
        printArr(rotateByTimes(test1, 10));  // --> [4,5,1,2,3]
        printArr(rotateByTimes(test2, 26));  //  --> [500,3,4,230,104,435]
        printArr(rotateByTimes(test2, 3));  // --> [230, 104, 435, 500, 3, 4]
    }
}



// 時間計算量O(n)
// 新しい配列を作成しているから空間計算量O(n)

// class Main{
//     public static int[] rotateByTimes(int[] ids, int n){
//         // 関数を完成させてください
//         int len = ids.length;
//         int[] outputArr = new int[len];
//         for (int i = 0; i < len; i++){
//             outputArr[(i + n) % len] = ids[i];
//         }

//         return outputArr;
//     }
// }



