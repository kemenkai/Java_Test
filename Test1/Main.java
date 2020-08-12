public class Main{
    public static void main(String[] args){
        int x = 100;
        System.out.println("x = " + x);
        x = 200;
        System.out.println("x = " + x);
        
        int n = x;
        System.out.println("n = " + n);
        
        n = n + 100;
        System.out.println("x = " + x);
        System.out.println("n = " + n);
        
    }
}