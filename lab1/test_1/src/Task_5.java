public class Task_5 {
    public static void main(String[] args){
        String testString = "шалаш";
        if (isPalindrome(testString)) {
            System.out.println("\"" + testString + "\" — это палиндром.");
        } else {
            System.out.println("\"" + testString + "\" — это не палиндром.");
        }
    }
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        String cleaned = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
