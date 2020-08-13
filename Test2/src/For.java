public class For {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        int[] ns = {1, 4, 9, 16, 25};
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.print(ns[i] + " ");
        }

        sum = 0;
        for (int n : ns) {
            sum = sum + n;
        }
        System.out.printf("\nForeach Sum: %d\n", sum);

        double pi = 0;
        for (double i = 1; i < 9999999; i += 2) {
            pi = 1 / (i * 2 - 1) - 1 / (i * 2 + 1) + pi;
        }
        System.out.println(pi * 4);
    }
}