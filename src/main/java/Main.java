
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // Язык программирования: Java (jdk 17)
    public static void main(String[] args) {
        int[] testArr1 = new int[]{1, -1, 2, -2, 3, -3, 4, -4};
        int[] testArr2 = new int[]{1, -2, 2, 0, -3, 3, -1};
        int[] testArr3 = new int[]{1, 0, 0, -1, 0};
        int[] testArr4 = new int[]{1, 0, 0, 0, -1};
        int[] testArr5 = new int[]{5, 1, 2, -3, -5};
        int[] testArr6 = new int[]{5, 0, 1, -6, 2};
        int[] testArr7 = new int[]{-1, -2, -1, 4, 0, 0};

        //int total = countTotalSubarrays(testArr1, true);
        //System.out.println("Total subarrays = " + total);
        printAllNumberPartitions(5);
    }

    private static int countTotalSubarrays(int[] arr, boolean printSubarray) {
        int count = 0;
        int[] subArray;
        int sum;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    sum = arr[i];
                    continue;
                }
                sum += arr[j];
                if (sum == 0) {
                    int t;
                    if (i < j) {
                        t = i;
                        subArray = new int[(j - i) + 1];
                        for (int k = 0; k < subArray.length; k++) {
                            subArray[k] = arr[t++];
                        }
                        count++;
                        if (printSubarray) {
                            System.out.println("N subarray: " + Arrays.toString(subArray) + "  *markingForTest* ");
                        }
                    } else if (i > j) {
                        t = j;
                        subArray = new int[j + 2];
                        subArray[0] = arr[i];
                        for (int k = 1; k < subArray.length; k++) {
                            subArray[k] = arr[t--];
                        }
                        count++;
                        if (printSubarray) {
                            System.out.println("N subarray: " + Arrays.toString(subArray) + "  *markingForTest2*");
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int[] getNextPartition(int[] partition) {
        if (partition.length == 1) {
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < partition.length - 1; i++) {
            if (partition[i] < partition[minIndex]) {
                minIndex = i;
            }
        }
        partition[minIndex] += 1;
        partition[partition.length - 1] -= 1;
        minIndex += 1;
        int partSum = 0;
        for (int i = minIndex; i < partition.length; i++) {
            partSum += partition[i];
        }
        int[] nextPartiotion = Arrays.copyOf(partition,minIndex + partSum);
        for (int i = minIndex; i < nextPartiotion.length; i++) {
            nextPartiotion[i] = 1;
        }
        return nextPartiotion;
    }

    public static ArrayList<int[]> printAllNumberPartitions(int number) {
        ArrayList<int[]> result = new ArrayList<>();
        if(number==1||number==-1){
            number=number*-1;
            result.add(new int[]{number});
            for (int[] ints : result) {
                System.out.println(Arrays.toString(ints));
            }
            return result;
        }
        int[] partition=null;
        if(number>0){
            partition = new int[number];
            Arrays.fill(partition, -1);
        } else {
             partition= new int[(number*-1)];
            Arrays.fill(partition, 1);
        }

        for (; partition != null;) {
            System.out.println(Arrays.toString(partition));
            partition = getNextPartition(partition);
        }
        return result;
    }

}
