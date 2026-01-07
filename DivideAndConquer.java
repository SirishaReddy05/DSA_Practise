class DivideAndConquer {

    static final long MOD = 1000000007;
    public static void main(String[] args) {
        long a = 2, b = 10, m = 1000000007;
        System.out.println("2^10 % m = " + findPower(a, b, m));
        long[][] matrix = {
            {1, 1},
            {1, 0}
        };

        long power = 5;
        long[][] result = matrixPow(matrix, power);

        System.out.println("Matrix^" + power + ":");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // -------------------- BINARY EXPONENTIATION --------------------
    // Computes (a^b) % m in O(log b)
    static long findPower(long a, long b, long m) {

        if (b == 0) return 1;          // a^0 = 1
        if (b == 1) return a % m;      // a^1 = a % m

        long half = findPower(a, b / 2, m);
        long square = (half * half) % m;

        if (b % 2 == 0)
            return square;
        else
            return (square * (a % m)) % m;
    }

    // -------------------- MATRIX MULTIPLICATION --------------------
    static long[][] matrixMult(long[][] A, long[][] B) {
        int n = A.length;
        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + A[i][k] * B[k][j]) % MOD;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    // -------------------- MATRIX EXPONENTIATION --------------------
    // Computes matrix^power in O(n^3 log power)
    static long[][] matrixPow(long[][] matrix, long power) {
        int n = matrix.length;

        // Identity matrix
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++)
            result[i][i] = 1;

        long[][] base = matrix;

        while (power > 0) {
            if ((power & 1) == 1)
                result = matrixMult(result, base);

            base = matrixMult(base, base);
            power >>= 1;
        }
        return result;
    }
}
