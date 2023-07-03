class Main{
    public static void printArray(int[] intArr){
        System.out.print("[");
        for (int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i] + " ");
        }
        System.out.println("]");
    }

    // in-place algorithm
    public static void selectionSort(int[] list){
        for (int i = 0; i < list.length; i++){
            int minIdx = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j] <= list[minIdx]) minIdx = j;
            }

            int temp = list[i];
            list[i] = list[minIdx];
            list[minIdx] = temp;
        }
    }

    public static void main(String[] args){
        int[] intArr = {1, 5, 3, 2, 10, 1, 4};
        printArray(intArr);
        selectionSort(intArr);
        printArray(intArr);
    }
}

