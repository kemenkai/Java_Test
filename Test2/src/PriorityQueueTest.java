package src;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bossss", "A120"));
        q.offer(new User("Bob", "A10"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Alicess", "v10"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {

        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            Integer u1_int = Integer.parseInt(u1.number.substring(1));
            Integer u2_int = Integer.parseInt(u2.number.substring(1));
            return u1_int.compareTo(u2_int);
        }

        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

//class User implements Comparable {
class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }

//    @Override
//    public int compareTo(Object o )
//    {
//        User u = (User) o;
//        if (this.number.charAt(0) == u.number.charAt(0))
//        {
//            return Integer.parseInt(this.number.substring(1)) < Integer.parseInt(u.number.substring(1)) ? -1 : 1;
//        }
//
//        if (this.number.charAt(0) == 'V')
//        {
//            return -1;
//        }
//        else
//        {
//            return 1;
//        }
//    }
}
