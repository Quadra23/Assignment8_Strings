

	import java.util.Stack;

	public class Assignment8_Strings_Q7 {
	    public static String decodeString(String s) {
	        Stack<Integer> countStack = new Stack<>();
	        Stack<String> resultStack = new Stack<>();
	        StringBuilder currentString = new StringBuilder();
	        int count = 0;

	        for (char ch : s.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                count = count * 10 + (ch - '0');
	            } else if (ch == '[') {
	                countStack.push(count);
	                resultStack.push(currentString.toString());
	                currentString = new StringBuilder();
	                count = 0;
	            } else if (ch == ']') {
	                StringBuilder temp = new StringBuilder(resultStack.pop());
	                int repeatCount = countStack.pop();
	                for (int i = 0; i < repeatCount; i++) {
	                    temp.append(currentString);
	                }
	                currentString = temp;
	            } else {
	                currentString.append(ch);
	            }
	        }

	        return currentString.toString();
	    }

	    public static void main(String[] args) {
	        String s = "3[a]2[bc]";
	        String decodedString = decodeString(s);
	        System.out.println(decodedString);
	    }
	}

