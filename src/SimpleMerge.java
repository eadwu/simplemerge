import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Teacher on 1/28/2019.
 * simpleMerge takes in two sorted arrays of
 * integers and merges them to return one sorted
 * array of integers.
 */
public class SimpleMerge {
    public static int[] simpleMergeOld(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
    }

    public static int[] simpleMerge(int[] arr1, int[] arr2) {
        int[] sortedArr = new int[arr1.length + arr2.length];

        IntStream.range(0, arr1.length).forEach(i -> sortedArr[i] = arr1[i]);
        IntStream.range(0, arr2.length).forEach(i -> sortedArr[arr1.length + i] = arr2[i]);

        for (int i = 0; i < sortedArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedArr[i] < sortedArr[j]) {
                    int tmp = sortedArr[j];
                    sortedArr[j] = sortedArr[i];
                    sortedArr[i] = tmp;
                }
            }
        }
        return sortedArr;
    }
}
