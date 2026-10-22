import java.util.Scanner;

public class Main {
    static void from1(int n) {
        if (n == 0) return;
        from1(n - 1);
        System.out.print(n + " ");
    }

    static void fromAtoB(int a, int b) {
        System.out.print(a + " ");
        if (a == b) return;
        fromAtoB(a < b ? a + 1 : a - 1, b);
    }

    static boolean isPow2(int n) {
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPow2(n / 2);
    }

    static int sum(int n) {
        if (n == 0) return 0;
        return n % 10 + sum(n / 10);
    }

    static void rightToLeft(int n) {
        System.out.print(n % 10 + " ");
        if (n >= 10) rightToLeft(n / 10);
    }

    static void leftToRight(int n) {
        if (n >= 10) leftToRight(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1) n = ");
        from1(sc.nextInt());

        System.out.print("\n2) A B = ");
        fromAtoB(sc.nextInt(), sc.nextInt());

        System.out.print("\n3) N = ");
        System.out.println(isPow2(sc.nextInt()) ? "YES" : "NO");

        System.out.print("4) N = ");
        System.out.println(sum(sc.nextInt()));

        System.out.print("5) N = ");
        rightToLeft(sc.nextInt());

        System.out.print("\n6) N = ");
        leftToRight(sc.nextInt());
    }
}
