// 分割統治法: divide-and-conquer method

class Main{
    public static int[] doubledArray(int[] arr){
        return doubledArrayHelper(arr, 0, arr.length - 1);
    }

    public static int[] doubledArrayHelper(int[] arr, int start, int end){
        // ベースケース
        // the returned value in the basecase will be necessary, but can be any int[] data. e.g. new int[]{1}
        if (start == end){
            arr[start] *= 2;
            return arr;
        }

        int middle = (int)Math.floor((start + end) / 2);

        doubledArrayHelper(arr, start, middle);
        doubledArrayHelper(arr, middle + 1, end);

        return arr;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5};

        printArr(doubledArray(arr1));
        printArr(doubledArray(arr2));
    }
}
