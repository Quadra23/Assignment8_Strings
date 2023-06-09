

	import java.util.ArrayList;
	import java.util.List;

	public class Assignment8_Strings_Q6 {
	    public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList<>();

	        if (s.length() < p.length()) {
	            return result;
	        }

	        int[] charCountP = new int[26];
	        int[] charCountS = new int[26];

	        // Count the occurrences of characters in p
	        for (char ch : p.toCharArray()) {
	            charCountP[ch - 'a']++;
	        }

	        int windowSize = p.length();

	        // Initialize the sliding window
	        for (int i = 0; i < windowSize; i++) {
	            charCountS[s.charAt(i) - 'a']++;
	        }

	        // Slide the window through s
	        for (int i = windowSize; i <= s.length(); i++) {
	            // Check if the current window is an anagram of p
	            if (isAnagram(charCountS, charCountP)) {
	                result.add(i - windowSize);
	            }

	            // Move the window by 1 position
	            if (i < s.length()) {
	                charCountS[s.charAt(i) - 'a']++;
	                charCountS[s.charAt(i - windowSize) - 'a']--;
	            }
	        }

	        return result;
	    }

	    private static boolean isAnagram(int[] charCountS, int[] charCountP) {
	        for (int i = 0; i < 26; i++) {
	            if (charCountS[i] != charCountP[i]) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        String s = "cbaebabacd";
	        String p = "abc";

	        List<Integer> indices = findAnagrams(s, p);
	        System.out.println(indices);
	    }
	}
