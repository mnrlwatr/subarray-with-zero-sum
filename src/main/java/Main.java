
import java.util.ArrayList;

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

        printSubarray(testArr1);
    }

    public static void printSubarray(int[] array) {
        ArrayList<ArrayList<Integer>> arrayLists = getAllCombination(array.length, 2);
        for (ArrayList<Integer> arrayList1 : arrayLists) {
            int sum = 0;
            for (Integer integer : arrayList1) {
                sum += array[integer];
            }
            if (sum == 0) {
                StringBuilder sb = new StringBuilder("[");
                for (Integer i : arrayList1) {
                    sb.append(array[i]);
                    sb.append(",");
                }
                sb.setCharAt(sb.lastIndexOf(","),']');
                System.out.println(sb);
            }
        }

    }

    private static ArrayList<ArrayList<Integer>> getAllCombination(int n, int k) {
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        int[] comb = new int[k + 2];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[k] = n;
        comb[k + 1] = 0;
        for (; ; ) {
            list2.add(arrayPart(comb, 0, k));
            int j = 0;
            for (; comb[j] + 1 == comb[j + 1]; ) {
                comb[j] = j;
                j = j + 1;
            }
            if (j < k) {
                comb[j]++;
            } else {
                break;
            }
        }
        return list2;
    }

    private static ArrayList<Integer> arrayPart(int[] array, int s, int e) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = s; i < e - 1; i++) {
            list.add(array[i]);
        }
        list.add(array[e - 1]);
        return list;
    }
}
