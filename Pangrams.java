

import java.util.Scanner;

public class Solution {

    protected static String getOutput(String sentence) {
        return (isPangram(sentence)) ? "pangram" : "not pangram";
    }

    protected static boolean isPangram(String sentence) {
        String lowerSentence = sentence.toLowerCase();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (lowerSentence.indexOf(letter) < 0) return false;
        }
        return true;
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println(Solution.getOutput(in.nextLine()));
    }

}
