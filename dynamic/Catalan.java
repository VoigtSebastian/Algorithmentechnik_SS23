package dynamic;

public class Catalan {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            var simple = catalan(i);
            System.out.println("Catalan number of " + i + " = " + simple);
            assert (simple == catalanDynamic(i));
        }
    }

    // Complexity of O(n^2), because both loops use O(n) operations in the
    // worst-case
    // Space-complexity is probably O(n+1), because of the array?
    private static int catalanDynamic(int n) {
        int[] buffer = new int[n + 1];
        buffer[0] = 1;

        for (int i = 1; i <= n; i++) { // O(n) - worst-case
            for (int j = 0; j < i; j++) { // O(n) - worst-case
                buffer[i] += buffer[j] * buffer[i - j - 1];
            }
        }
        return buffer[n];
    }

    // ------------------------------------------------------------------------
    // NON DYNAMIC IMPLEMENTATION
    // ------------------------------------------------------------------------

    private static int catalan(int n) {
        if (n <= 1)
            return 1;
        var r = 0;
        for (int i = 0; i < n; i++) {
            r += catalan(i) * catalan(n - i - 1);
        }
        return r;
    }
}
