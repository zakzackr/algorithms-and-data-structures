class Main{
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int currentValue = arr[i];

            for (int j = i - 1; j >= 0; j--){
                if (currentValue <= arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = currentValue;
                }
                else break;
            }
        }

        return arr;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] arr = {2, 4, 3, 1, 10, 2};

        printArr(arr);
        insertionSort(arr);
        printArr(arr);
    }
}
