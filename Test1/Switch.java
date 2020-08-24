import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int number = 3;
        switch (number) {
            case 1 -> System.out.println("Number1");
            case 2 -> System.out.println("Number2");
            case 3 -> System.out.println("Number3");
        }
    }
}
