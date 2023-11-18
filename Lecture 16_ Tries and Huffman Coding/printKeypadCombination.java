Print Keypad Combinations Code
Send Feedback
+
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note:
The order of strings are not important. Just print different strings in new lines.
Input Format:
Integer n
Output Format:
All possible strings in different lines
Constraints: 1 <= n <= 10^6


public class solution {

	public static void printKeypad(int input){
		  printKeypadHelper(input, "");
    }

    private static void printKeypadHelper(int input, String outputSoFar) {
        if (input == 0) {
            System.out.println(outputSoFar);
            return;
        }
        String[] lastDigitMapping = getMapping(input % 10);
        for (String character : lastDigitMapping) {
            printKeypadHelper(input / 10, character + outputSoFar);
        }
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