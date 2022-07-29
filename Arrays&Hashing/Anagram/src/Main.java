import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagramBetter (String s, String t){
        if(s.length() != t.length())
            return false;

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        Arrays.sort(schar);
        Arrays.sort(tchar);

        for (int i=0; i < s.length(); i++){
            if(schar[i] != tchar[i])
                return false;
        }
        return true;
    }

    public static boolean isAnagram (String s, String t){
        if(s.length() != t.length())
            return false;

        for(int i=0; i < s.length(); i++){
            if(containsChar(s.charAt(i), s) != containsChar(s.charAt(i), t))
                return false;
        }

        return true;
    }

    public static int containsChar(char c , String s){
        int number = 0;
        for(int i=0; i < s.length(); i++ ){
            if(c == s.charAt(i))
                number ++;
        }
        return number;
    }
}
