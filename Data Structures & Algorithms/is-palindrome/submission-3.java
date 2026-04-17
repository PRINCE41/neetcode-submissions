class Solution {
    public boolean isPalindrome(String s) {
        // char[] arr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        // for(int i=0, j=arr.length-1; i<j; i++, j--){
        //     if(arr[i] != arr[j]) return false;
        // }
        // return true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else {
                if(s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
        }
        return true;


    }
}
