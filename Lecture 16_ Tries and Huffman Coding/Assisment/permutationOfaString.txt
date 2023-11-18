Return Permutations of a String
Send Feedback
+
Given a string, find and return all the possible permutations of the input string.
Note :
The order of permutations are not important.
Sample Input:
abc
Sample Output:
abc
acb
bac
bca
cab
cba


import java.util.*;
public class solution {
	
	public static String[] permutationOfString(String input) {
        ArrayList<String> result = new ArrayList<>();
        generatePermutations(input.toCharArray(), 0, result);
        return result.toArray(new String[0]);
    }

    private static void generatePermutations(char[] input, int currentIndex, ArrayList<String> result) {
        if (currentIndex == input.length - 1) {
            result.add(new String(input));
            return;
        }
        for (int i = currentIndex; i < input.length; i++) {
            swap(input, currentIndex, i);
            generatePermutations(input, currentIndex + 1, result);
            swap(input, currentIndex, i); 
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}