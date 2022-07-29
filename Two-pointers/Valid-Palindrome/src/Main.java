public class Main {
    public static void main(String[] args) {
        String word = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String s) {
        if(s.isEmpty() || s.isBlank())
            return true;

        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}