package Leetcode57;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem720 {

	public static void main(String[] args) {
		String result = longestWord(new String[]{"wo","w","wor","worl", "world"});

		System.out.println(result);
	}
	
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
