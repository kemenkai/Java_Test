public class BoolTest {
    public static void main(String[] arges) {
        int age = 7;
        // primary student 的定义 : 6~12岁
        boolean isPrimaryStudent = age >= 6 && age <= 12;
	System.out.println(isPrimaryStudent ? "Yes" : "No");
    }
}
