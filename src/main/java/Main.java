
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

        int totalSubarrays = findSubarrays(testArr1, true);
        System.out.println("totalSubarrays with zero sum = " + totalSubarrays);
    }

    public static int findSubarrays(int[] array, boolean print) {
        int argArrayLength = array.length;
        int total = 0;
        for (int i = 2; i <= argArrayLength; i++) {
            ArrayList<ArrayList<Integer>> arrayLists = getAllCombination(argArrayLength, i);
            for (ArrayList<Integer> arrayList : arrayLists) {
                int sum = 0;
                for (Integer integer : arrayList) {
                    sum += array[integer];
                }
                if (sum == 0) {
                    total++;
                    if (print) {
                        StringBuilder sb = new StringBuilder("[");
                        for (Integer integer : arrayList) {
                            sb.append(array[integer]);
                            sb.append(",");
                        }
                        sb.setCharAt(sb.lastIndexOf(","), ']');
                        System.out.println(sb);
                    }
                }
            }
        }
        return total;
    }

    private static ArrayList<ArrayList<Integer>> getAllCombination(int n, int k) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int[] comb = new int[k + 2];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[k] = n;
        comb[k + 1] = 0;
        for (; ; ) {
            arrayLists.add(arrayPart(comb, 0, k));
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
        return arrayLists;
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
