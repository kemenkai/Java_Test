package src;
import java.util.*;

public class SatckTest1 {
    public static void main(String[] args) {
        String hex = toHex(12500);

        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> remainder_que = new LinkedList<>();
        while(n != 0){
            int remainder = n % 16;
            n /= 16;
            remainder_que.push(Integer.toHexString(remainder));
        }

        StringBuilder remainder_result = new StringBuilder();
        while (!remainder_que.isEmpty()){
            remainder_result.append(remainder_que.pop());
        }
        return remainder_result.toString();
    }
}