
public class Assignment8_Strings_Q5 {
	
	    public static int compress(char[] chars) {
	        int index = 0; // Index to track the position in the modified array

	        for (int i = 0; i < chars.length; i++) {
	            char currChar = chars[i];
	            int count = 1;

	            // Count the consecutive repeating characters
	            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
	                count++;
	                i++;
	            }

	            // Modify the original array
	            chars[index++] = currChar;

	            if (count > 1) {
	                String countStr = String.valueOf(count);

	                // If the count is 10 or more, split it into individual characters
	                for (char c : countStr.toCharArray()) {
	                    chars[index++] = c;
	                }
	            }
	        }

	        return index;
	    }

	    public static void main(String[] args) {
	        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
	        int newLength = compress(chars);

	        System.out.println(newLength);

	        // Print the modified array
	        for (int i = 0; i < newLength; i++) {
	            System.out.print(chars[i] + " ");
	        }
	    }
	}
