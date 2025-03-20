
import java.util.Arrays;

public class Main {
    // Язык программирования: Java (jdk 17)
    // Решения придумал я сам с нуля, не стал искать задачу в гугле и копировать готовые решения оттуда,
    // но на работе если время поджимает лучше не изобретать велосипед самому с нуля.
    // Извиняюсь за трудночитаемый спагетти код
    public static void main(String[] args) {
        int[] testArr1 = new int[]{1, -1, 2, -2, 3, -3, 4, -4};
        int[] testArr2 = new int[]{1, -2, 2, 0, -3, 3, -1};
        int[] testArr3 = new int[]{1, 0, 0, -1, 0};
        int[] testArr4 = new int[]{1, 0, 0, 0, -1};
        int[] testArr5 = new int[]{5, 1, 2, -3, -5};
        int[] testArr6 = new int[]{5, 0,1 , -6, 2};

        int total = countTotalSubarrays(testArr1, true);
        System.out.println("Total subarrays = " + total);
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
                if ((arr[i] + arr[j]) == 0) {
                    subArray = new int[2];
                    subArray[0] = arr[i];
                    subArray[1] = arr[j];
                    count++;
                    if (printSubarray) {
                        System.out.println(Arrays.toString(subArray));
                    }
                }
                if (sum == 0 && (j - 1 != i) && (j + 1 != i)) {
                    int t;
                    if (i < j) {
                        t = i;
                        subArray = new int[(j - i) + 1];
                        for (int k = 0; k < subArray.length; k++) {
                            subArray[k] = arr[t++];
                        }
                        count++;
                        if (printSubarray) {
                            System.out.println("N** subarray: " + Arrays.toString(subArray));
                        }
                    } else if (i > j && (arr[i] + arr[j]) != 0) {
                        t = j;
                        subArray = new int[j + 2];
                        subArray[0] = arr[i];
                        for (int k = 1; k < subArray.length; k++) {
                            subArray[k] = arr[t--];
                        }
                        count++;
                        if (printSubarray) {
                            System.out.println("**N subarray: " + Arrays.toString(subArray));
                        }
                    }
                }
            }
        }
        return count;
    }
}
