class Main{
    public static void printArray(int[] intArr){
        System.out.print("[");
        for (int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i] + " ");
        }
        System.out.println("]");
    }

    // in-place algorithm
    // time complexity: O(n^2)
    // space complexity: O(1)
    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }

            if (maxIdx != i){
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args){
        int[] intArr = {2, 7, 3, 2, 9, 1, 7};
        printArray(intArr);
        selectionSort(intArr);
        printArray(intArr);
    }
}
