/*Return Keypad Code
Send Feedback
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note:
1. The order of strings are not important. 2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Input Format:
Integer n
Output Format:
All possible strings in different lines
Constraints: 1 <= n <= 10^6*/


public class solution {

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
        // Base case: empty string for 0 and 1
        if (n == 0 || n == 1) {
            String[] result = {""};
            return result;
        }
        String[] lastDigitMapping = getMapping(n % 10);
        String[] smallerOutput = keypad(n / 10);
        int finalSize = lastDigitMapping.length * smallerOutput.length;
        String[] output = new String[finalSize];
        int k = 0;
        for (int i = 0; i < lastDigitMapping.length; i++) {
            for (int j = 0; j < smallerOutput.length; j++) {
                output[k++] = smallerOutput[j] + lastDigitMapping[i];
            }
        }

        return output;
    }

    private static String[] getMapping(int digit) {
        switch (digit) {
            case 2:
                return new String[]{"a", "b", "c"};
            case 3:
                return new String[]{"d", "e", "f"};
            case 4:
                return new String[]{"g", "h", "i"};
            case 5:
                return new String[]{"j", "k", "l"};
            case 6:
                return new String[]{"m", "n", "o"};
            case 7:
                return new String[]{"p", "q", "r", "s"};
            case 8:
                return new String[]{"t", "u", "v"};
            case 9:
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[]{};
        }
    }

}