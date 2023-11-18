Print Permutations of a String
Send Feedback
Given a string, find and print all the possible permutations of the input string.
Note:
The order of permutations are not important. Just print them in different lines.
Sample Input:
abc
Sample Output:
abc
acb
bac
bca
cab
cba


public class solution {

	public static void permutations(String input) {
        printPermutationsHelper(input.toCharArray(), 0);
    }

    private static void printPermutationsHelper(char[] input, int currentIndex) {
        if (currentIndex == input.length - 1) {
            System.out.println(new String(input));
            return;
        }

        for (int i = currentIndex; i < input.length; i++) {
            swap(input, currentIndex, i);
            printPermutationsHelper(input, currentIndex + 1);
            swap(input, currentIndex, i); // Backtrack to restore the original order
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";
        permutations(input);
    }
}