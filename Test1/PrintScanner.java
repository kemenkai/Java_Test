import java.util.Scanner;

public class PrintScanner {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
//        System.out.print("Input your name: ");
//	  String name = scanner.nextLine();
//        System.out.print("Input your age: ");
//        int age = scanner.nextInt();
//        System.out.printf("Hi, %s, you are %d\n", name, age);
        System.out.print("请输入上次考试成绩: ");
        int Old_Score = scanner.nextInt();
        System.out.print("请输入本次考试成绩: ");
        int New_Score = scanner.nextInt();
        float Score_Result = (float)(New_Score - Old_Score) / Old_Score * 100;
        System.out.printf("本次成绩提升为：%f %%\n", Score_Result);
    }
}
