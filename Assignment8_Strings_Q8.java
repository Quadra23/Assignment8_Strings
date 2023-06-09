
public class Assignment8_Strings_Q8 {
	
	    public static boolean canSwapStrings(String s, String goal) {
	        if (s.length() != goal.length()) {
	            return false;
	        }
	        
	        int diffCount = 0;
	        int[] diffIndices = new int[2];
	        
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) != goal.charAt(i)) {
	                if (diffCount >= 2) {
	                    return false;
	                }
	                diffIndices[diffCount++] = i;
	            }
	        }
	        
	        if (diffCount != 2) {
	            return false;
	        }
	        
	        // Check if swapping the characters makes the strings equal
	        return s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1]) &&
	               s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]);
	    }
	    
	    public static void main(String[] args) {
	        String s = "ab";
	        String goal = "ba";
	        boolean canSwap = canSwapStrings(s, goal);
	        System.out.println(canSwap);
	    }
	}

