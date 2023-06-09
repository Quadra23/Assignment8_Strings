
public class Assignment8_Strings_Q2 {
	
	    public static boolean isValid(String s) {
	        int minOpen = 0;  // Minimum number of open parentheses assuming '*' as ')'
	        int maxOpen = 0;  // Maximum number of open parentheses assuming '*' as '('

	        for (char ch : s.toCharArray()) {
	            if (ch == '(') {
	                minOpen++;
	                maxOpen++;
	            } else if (ch == ')') {
	                minOpen = Math.max(minOpen - 1, 0);
	                maxOpen--;
	            } else if (ch == '*') {
	                minOpen = Math.max(minOpen - 1, 0);
	                maxOpen++;
	            }

	            if (maxOpen < 0) {
	                return false;  // More closing parentheses encountered than opening parentheses
	            }
	        }

	        return minOpen == 0;
	    }

	    public static void main(String[] args) {
	        String s = "()";
	        boolean isValid = isValid(s);
	        System.out.println(isValid);
	    }
	}
