package dynamicproblems;

public class CutRoadProblem {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum obtained prices is: " + cutRoadMethod(arr, size));
    }

    public static int cutRoadMethod(int[] prices, int size) {
        int vals[] = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, prices[j] + vals[i - j - 1]);
            }
            vals[i] = max_val;
        }
        return vals[size];
    }
}
