import java.util.Scanner;
public class Ifelse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的体重（kg）: ");
        double Weight = scanner.nextDouble();
        System.out.print("请输入你的身高（cm）：");
        double Height = scanner.nextDouble();
        Height = Height / 100;
        double BMI = Weight / (Height * Height);
        if (BMI < 18.5) {
            System.out.printf("您的体重过轻，BMI为：%f\n", BMI);
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.printf("您的体重正常，BMI为：%f\n", BMI);
        } else if (BMI >= 25 && BMI < 28) {
            System.out.printf("您的体重过重，BMI为：%f\n", BMI);
        } else if (BMI >= 28 && BMI < 32) {
            System.out.printf("您的体重属于肥胖，BMI为：%f\n", BMI);
        } else {
            System.out.printf("您的体重属于非常肥胖，BMI为：%f\n", BMI);
        }
    }
}
