package src;

import com.sun.source.tree.Tree;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }


    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Integer> set_tmp = new TreeSet<>();
        List<Message> new_list = new ArrayList<>();

        for (Message msg : received)
        {
            if (set_tmp.add(msg.sequence))
            {
                new_list.add(msg);
            }
        }
        return new_list;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}
