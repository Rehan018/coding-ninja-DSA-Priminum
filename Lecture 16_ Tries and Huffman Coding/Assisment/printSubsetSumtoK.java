Print Subset Sum to K
Send Feedback
Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note:
The order of subsets are not important. Just print them in different lines.
Input format:
Line 1: Size of input array
Line 2: Array elements separated by space
Line 3: K


import java.util.*;
public class solution {
	public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTokHelper(input, 0, k, new ArrayList<>());
    }
    private static void printSubsetsSumTokHelper(int input[], int startIndex, int targetSum, ArrayList<Integer> currentSubset) {
        if (startIndex == input.length) {
            if (targetSum == 0) {
                printSubset(currentSubset);
            }
            return;
        }

        printSubsetsSumTokHelper(input, startIndex + 1, targetSum, currentSubset);
        currentSubset.add(input[startIndex]);
        printSubsetsSumTokHelper(input, startIndex + 1, targetSum - input[startIndex], currentSubset);
        currentSubset.remove(currentSubset.size() - 1);
    }

    private static void printSubset(ArrayList<Integer> subset) {
        for (int element : subset) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}