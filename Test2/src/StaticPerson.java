public class StaticPerson {
    public static void main(String[] args){
        Person.count = 10;
        System.out.println(Person.getCount());
    }
}

class Person{
    public static int count;
    public static int getCount(){
        return count;
    }
}
