import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"",""};

        System.out.println(groupAnagrams(strs));
    }

    /**
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     **/
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solutions = new ArrayList<>();

        List<String> solution;


        if(strs.length == 0){
            solution = new ArrayList<>();
            solution.add("");
            solutions.add(solution);
            return solutions;
        }

        if(strs.length == 1){
            solution = new ArrayList<>();
            solution.add(strs[0]);
            solutions.add(solution);
            return solutions;
        }

        for(int i=0; i < strs.length; i++){

            if(strs[i].equals("-X-"))
               continue;

            String str = strs[i];
            solution = new ArrayList<>();
            solution.add(str);
            for (int j=i+1; j < strs.length; j++){

                if(isAnagramBetter(str, strs[j])){
                    solution.add(strs[j]);
                    strs[j] = "-X-";
                }
            }
            strs[i] = "-X-";
            solutions.add(solution);
        }
        return solutions;
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
}
