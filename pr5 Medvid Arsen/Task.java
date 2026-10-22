import java.util.Random;

public class Task {

    static boolean compare(double x, double y, boolean asc) {
        return asc ? x < y : x > y;
    }

    static void swap(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int partition(double[] a, int start, int end, boolean asc) {
        int i = start;
        for (int j = start; j < end; j++)
            if (compare(a[j], a[end], asc))
                swap(a, i++, j);
        swap(a, i, end);
        return i;
    }

    static void quickSort(double[] a, int start, int end, boolean asc) {
        if (start >= end)
            return;
        int p = partition(a, start, end, asc);
        quickSort(a, start, p - 1, asc);
        quickSort(a, p + 1, end, asc);
    }

    static boolean isSorted(double[] a, boolean asc) {
        for (int i = 0; i < a.length - 1; i++)
            if (compare(a[i + 1], a[i], asc))
                return false;
        return true;
    }

    static void bubbleSort(double[] a, boolean asc) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - 1 - i; j++)
                if (compare(a[j + 1], a[j], asc))
                    swap(a, j, j + 1);
    }

    static void insertionSort(double[] a, boolean asc) {
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && compare(a[j], a[j - 1], asc); j--)
                swap(a, j, j - 1);
    }

    static void selectionSort(double[] a, boolean asc) {
        for (int i = 0; i < a.length - 1; i++) {
            int s = i;
            for (int j = i + 1; j < a.length; j++)
                if (compare(a[j], a[s], asc))
                    s = j;
            swap(a, i, s);
        }
    }

    static void test(String name, double[] original, boolean asc) {
        double[] a = original.clone();
        long start = System.nanoTime();
        if (name.equals("Quick"))
            quickSort(a, 0, a.length - 1, asc);
        if (name.equals("Bubble"))
            bubbleSort(a, asc);
        if (name.equals("Insertion"))
            insertionSort(a, asc);
        if (name.equals("Selection"))
            selectionSort(a, asc);
        long ms = (System.nanoTime() - start) / 1_000_000;
        System.out.println(name + (asc ? " зростання: " : " спадання: ") + ms + " мс, " + isSorted(a, asc));
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int size : new int[] { 1_000, 10_000, 100_000 }) {
            double[] a = new double[size];
            for (int i = 0; i < size; i++)
                a[i] = r.nextDouble() * 1000;
            System.out.println("\nРозмір: " + size);
            test("Quick", a, true);
            test("Quick", a, false);
            test("Bubble", a, true);
            test("Insertion", a, true);
            test("Selection", a, true);
        }
    }
}