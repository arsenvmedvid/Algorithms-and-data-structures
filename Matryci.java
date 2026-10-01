import java.util.Random;

public class Matryci {

    static int[][] generateMatrix(int m, int n, int min, int max) {
        int[][] a = new int[m][n];
        Random r = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = min + r.nextInt(max - min + 1);
            }
        }
        return a;
    }

    static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void task1(int[][] a) {
        System.out.println("Завдання 1");
        printMatrix(a);
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum = sum + a[i][j];
            }
            double average = (double) sum / a[i].length;
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%.2f\t", a[i][j] - average);
            }
            System.out.println();
        }
    }

    static void shiftRowRightByOne(int[] row) {
        int last = row[row.length - 1];
        for (int j = row.length - 1; j > 0; j--) {
            row[j] = row[j - 1];
        }
        row[0] = last;
    }

    static void shiftMatrixUpByOne(int[][] a) {
        int[] firstRow = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = firstRow;
    }

    static void task2(int[][] a, int k) {
        System.out.println("Завдання 2");
        printMatrix(a);
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < a.length; i++) {
                shiftRowRightByOne(a[i]);
            }
        }
        for (int step = 0; step < k; step++) {
            shiftMatrixUpByOne(a);
        }
        System.out.println("Після:");
        printMatrix(a);
    }

    static void task3(int[][] a) {
        System.out.println("Завдання 3");
        printMatrix(a);
        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) max = a[i][j];
            }
        }
        boolean[] removeRow = new boolean[a.length];
        boolean[] removeCol = new boolean[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == max) {
                    removeRow[i] = true;
                    removeCol[j] = true;
                }
            }
        }
        int newRows = 0;
        for (boolean r : removeRow) if (!r) newRows++;
        int newCols = 0;
        for (boolean r : removeCol) if (!r) newCols++;
        if (newRows == 0 || newCols == 0) {
            System.out.println("(матриця порожня)");
            return;
        }
        int[][] result = new int[newRows][newCols];
        int ri = 0;
        for (int i = 0; i < a.length; i++) {
            if (removeRow[i]) continue;
            int rj = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (removeCol[j]) continue;
                result[ri][rj] = a[i][j];
                rj++;
            }
            ri++;
        }
        printMatrix(result);
    }

    static void task4(int[][] a) {
        System.out.println("Завдання 4");
        printMatrix(a);
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < size; i++) {
            int left = 0;
            int right = size - 1;
            while (left < right) {
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("Після:");
        printMatrix(a);
    }

    public static void main(String[] args) {
        task1(generateMatrix(3, 4, 1, 20));
        System.out.println();
        task2(generateMatrix(4, 4, 1, 9), 1);
        System.out.println();
        task3(generateMatrix(4, 4, 1, 15));
        System.out.println();
        task4(generateMatrix(4, 4, 1, 9));
    }
}
