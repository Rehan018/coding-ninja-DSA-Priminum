Return subsets sum to K
Send Feedback
+
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note:
The order of subsets are not important.
Input format:
Line 1: Integer n. Size of input array
Line 2: Array elements separated by space
Line 3: K
Constraints:
1 <= n <= 20



import java.util.*;
public class solution {

	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentSubset = new ArrayList<>();
        subsetsSumKHelper(input, k, 0, currentSubset, result);
        return convertArrayListToArray(result);
    }

    private static void subsetsSumKHelper(int[] input, int k, int startIndex,
                                          ArrayList<Integer> currentSubset, ArrayList<ArrayList<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = startIndex; i < input.length; i++) {
            if (input[i] <= k) {
                currentSubset.add(input[i]);
                subsetsSumKHelper(input, k - input[i], i + 1, currentSubset, result);
                currentSubset.remove(currentSubset.size() - 1);
            }
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