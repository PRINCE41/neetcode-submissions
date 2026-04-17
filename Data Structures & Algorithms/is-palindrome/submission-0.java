class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            if(arr[i] != arr[j]) return false;
        }
        return true;
    }
}
