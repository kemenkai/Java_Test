public class While {
    public static void main(String[] args) {
        int sum = 0;
        int m = 1;
        int n = 100;
        // 使用while计算M+...+N:
        while (m <= n) {
            sum += m;
            m++;
        }
        System.out.println(sum);
    }
}
