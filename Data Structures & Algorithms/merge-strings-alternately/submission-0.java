class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int minL = Math.min(word1.length(),word2.length());
        for(int i=0; i<minL; i++){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
        }
        if(word1.length() - word2.length() > 0){
            str.append(word1.substring(minL));
        }else{
            str.append(word2.substring(minL));
        }
        return str.toString();
    }
}