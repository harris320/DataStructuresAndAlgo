package arrays;

public class ReverseString {

    public static String reverseString(String str){
        int l = str.length();
        char[] ch = convertToCharArray(str);

        String s = "";
        for(int i=l-1; i>=0; i--){
            s=s+ch[i];
        }

        return s;
    }

    public static char[] convertToCharArray(String s){
        char[] ch = new char[s.length()];
        for(int i=0;i<s.length();i++){
            ch[i] = s.charAt(i);
        }
        return ch;
    }

    public static String reverseWithSB(String str){
//        StringBuilder sb = new StringBuilder(str);
//        String rev = sb.reverse().toString();
        return new StringBuilder(str).reverse().toString();
    }


    public static void main(String[] args) {
        String str = "My name is Harris";
        System.out.println("Reversing String...");
        String rev = reverseString(str);
        String revSB = reverseWithSB(str);
        System.out.println("the reversed String is : " + rev);
        System.out.println("the reversed String with StringBuilder is : " + revSB);
    }
}
