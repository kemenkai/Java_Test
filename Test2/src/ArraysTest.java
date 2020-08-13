import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println("排序前: " + Arrays.toString(ns));
        System.out.println("索引长度：" + ns.length);

        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] < ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                    System.out.println(i + Arrays.toString(ns));
                }
            }
        }
        // 排序后:
        System.out.println("排序后：" + Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }

        // 用二维数组表示的学生成绩:
        int[][] scores = {
                {82, 90, 91},
                {68, 72, 64},
                {95, 91, 89},
                {67, 52, 60},
                {79, 81, 85},
        };
        // TODO:
        double cunt = 0;
        double sum = 0;
        for (int[] sc1 : scores) {
            for (double sc2 : sc1) {
                sum += sc2;
                cunt++;
            }
        }

        sum = 0;
        cunt = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
                cunt++;
            }
        }

        double average = sum / cunt;
        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
