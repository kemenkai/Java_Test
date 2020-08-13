import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.石头   2.剪刀   3.布");
        System.out.print("请您选择出：");
        int Result = scanner.nextInt();
        int SystemResult = (int) (Math.random() * 3) + 1;
        switch (Result) {
            case 1:
                if (SystemResult == Result) {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("平局。");
                } else if (3 == SystemResult) {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("你输了。");
                } else {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("你赢了。");
                }
                break;
            case 2:
                if (SystemResult == Result) {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("平局。");
                } else if (1 == SystemResult) {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("你输了。");
                } else {
                    System.out.printf("您出了：%d，系统出了：%d\n", Result, SystemResult);
                    System.out.println("你赢了。");
                }
                break;
            case 3:
                if (SystemResult == Result) {
                    System.out.printf("您出了：%d，系统出了：%d", Result, SystemResult);
                    System.out.println("平局");
                } else if (2 == SystemResult) {
                    System.out.printf("您出了：%d，系统出了：%d", Result, SystemResult);
                    System.out.println("你输了。");
                } else {
                    System.out.printf("您出了：%d，系统出了：%d", Result, SystemResult);
                    System.out.println("你赢了。");
                }
        }
    }
}
