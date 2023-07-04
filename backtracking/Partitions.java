package backtracking;

import java.util.ArrayList;

public class Partitions {
    public static void main(String[] args) {
        ArrayList<Integer> start = new ArrayList<>();
        partition(start, 10);
    }

    public static int sum(ArrayList<Integer> x) {
        int sum = 0;
        for (Integer i : x) {
            sum += i;
        }
        return sum;
    }

    public static boolean isCandidate(ArrayList<Integer> x, int n) {
        return sum(x) <= n;
    }

    public static void partition(ArrayList<Integer> x, int n) {
        if (!isCandidate(x, n)) {
            return;
        }
        if (sum(x) == n) {
            System.out.println(x);
            return;
        }
        var start = x.isEmpty() ? 1 : x.get(x.size() - 1);
        for (int i = start; i <= n; i++) {
            x.add(i);
            partition(x, n);
            x.remove(Integer.valueOf(i));
        }

    }
}
