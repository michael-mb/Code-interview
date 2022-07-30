import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        List<Character> set = new ArrayList<>();
        int max = 0;

        for(int i=0; i < s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(0);
            }
            set.add(s.charAt(i));
            max = Math.max(set.size(), max);
        }
        return max;
    }
}