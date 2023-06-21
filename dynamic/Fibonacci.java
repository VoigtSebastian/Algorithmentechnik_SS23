package dynamic;

import java.util.HashMap;

public final class Fibonacci {
    static HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        var n = 9;
        System.out.println(n + "th fibonacci number = " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        buffer.put(0, 0);
        buffer.put(1, 1);

        for (int i = 2; i <= n; i++) {
            System.out.println("Reuse: i-1:(" + (i - 1) + "),i-2:(" + (i - 2) + ") from " + buffer);

            var value = buffer.get(i - 1) + buffer.get(i - 2);
            buffer.put(i, value);
        }

        return buffer.get(n);
    }
}
