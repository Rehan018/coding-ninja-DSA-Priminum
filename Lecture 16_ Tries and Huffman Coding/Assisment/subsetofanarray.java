Return subset of an array
Send Feedback
+
Given an integer array (of length n), find and return all the subsets of input array.
NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note:
The order of subsets are not important.
Input format:
Line 1 : Size of array
Line 2: Array elements (separated by space) Expected Time Complexity: O(2^N), where N is the size of given array
Sample Input:
3
15 20 12

import java.util.*;
public class solution {

	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentSubset = new ArrayList<>();
        generateSubsets(input, 0, currentSubset, result);
        return convertArrayListToArray(result);
    }

    private static void generateSubsets(int[] input, int currentIndex, ArrayList<Integer> currentSubset, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = currentIndex; i < input.length; i++) {
            currentSubset.add(input[i]);
            generateSubsets(input, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    private static int[][] convertArrayListToArray(ArrayList<ArrayList<Integer>> list) {
        int size = list.size();
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> subset = list.get(i);
            int subsetSize = subset.size();
            result[i] = new int[subsetSize];
            for (int j = 0; j < subsetSize; j++) {
                result[i][j] = subset.get(j);
            }
        }
        return result;
    }
}