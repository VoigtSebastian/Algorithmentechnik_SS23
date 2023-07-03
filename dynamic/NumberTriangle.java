package dynamic;

public class NumberTriangle {
    static int[][] a = { { 10, 0, 0, 0, 0, 0, 0 }, { 82, 81, 0, 0, 0, 0, }, { 4, 6, 10, 0, 0, 0, 0 },
            { 2, 14, 35, 7, 0, 0, 0 }, { 41, 3, 52, 26, 15, 0, 0 }, { 32, 90, 11, 87, 56, 23, 0 },
            { 54, 65, 89, 32, 71, 9, 31 } };
    static int[][] s = new int[7][7];

    public static void main(String[] args) {
        printTriangle(a);

        s[0][0] = a[0][0];
        s[1][0] = a[0][0] + a[1][0];
        s[1][1] = a[0][0] + a[1][1];

        solveTriangle();
        printTriangle(s);

        backtracing();
    }

    public static void backtracing() {
        int column = 0;
        int currentMax = s[s.length - 1][0];

        for (int i = 1; i < s.length; i++) {
            if (s[s.length - 1][i] > currentMax) {
                column = i;
                currentMax = s[s.length - 1][i];
            }
        }
        System.out.println(column);

        for (int i = s.length - 2; i > 0; i--) {
            if (s[i][column] < s[i][column - 1])
                column -= 1;
            System.out.println(column);
        }

        System.out.println(0);
    }

    public static void solveTriangle() {
        for (int i = 2; i < s.length; i++) {
            s[i][0] = a[i][0] + s[i - 1][0];
            s[i][i] = a[i][i] + s[i - 1][i - 1];

            for (int j = 1; j < i; j++) {
                if (s[i - 1][j] > s[i - 1][j - 1])
                    s[i][j] = a[i][j] + s[i - 1][j];
                else
                    s[i][j] = a[i][j] + s[i - 1][j - 1];
            }
        }
    }

    public static void printTriangle(int[][] t) {
        for (var i : t) {
            for (var j : i) {
                System.out.print(String.format("%3d ", j));
            }
            System.out.println();
        }
        System.out.println();
    }
}
