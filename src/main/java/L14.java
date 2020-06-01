import  org.apache.isis.core.commons.ensure.Assert;

public class L14 {

    public static void main(String[] args) {
        Assert.assertEquals("dd","dd");
        Assert.assertEquals(L14.longestCommonPrefix(new String[]{}), "");
        Assert.assertEquals(L14.longestCommonPrefix(new String[]{"abcde"}), "abcde");
        Assert.assertEquals(L14.longestCommonPrefix(new String[]{"abcde","abcded"}), "abcde");

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].toCharArray().length;i++) {
            Character indexchar = strs[0].toCharArray()[i];
            boolean equal = true;
            for(int j=1;j < strs.length;j++){
                equal = equal && i < strs[j].length() && strs[j].charAt(i) == indexchar;
                if(!equal) break;
            }
            if(equal){
                result.append(indexchar);
            }else{
                break;
            }
        }
        
        return result.toString();
    }

}