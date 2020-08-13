public class DoWhile {
    public static void main(String[] args) {
        int m = 1;
        int n = 100;
        int sum = 0;
        do {
            sum += m;
            m++;
        } while (m <= n);
        System.out.println(sum);
    }
}
