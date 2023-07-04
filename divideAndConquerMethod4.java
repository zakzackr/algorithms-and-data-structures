class Main{
    public static String longestCommonPrefix(String[] strArr){
        return longestCommonPrefixHelper(strArr, 0, strArr.length - 1);
    }

    public static String longestCommonPrefixHelper(String[] strArr, int start, int end){
        if (start == end) return strArr[start];
        int middle = (start + end) / 2;

        String s1 = longestCommonPrefixHelper(strArr, start, middle);
        String s2 = longestCommonPrefixHelper(strArr, middle + 1, end);

        String commonPredix = commonPrefix(s1, s2, 0, "");

        return commonPredix;
    }

    // 末尾再帰
    public static String commonPrefix(String s1, String s2, int index, String output){
        if (index >= s1.length() || index >= s2.length() || s1.charAt(index) != s2.charAt(index)) return output;
        return commonPrefix(s1, s2, index + 1, output + s1.charAt(index));
    }

    public static void main(String[] args){
        String[] arr1 = {"ccc","cbd","cbc","c"};
        String[] arr2 = {"autopilot","autobiography","automobile","auto"};

        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr2));
    }
}

