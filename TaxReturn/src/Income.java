abstract public class Income {
//public class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public abstract double getTax();

/*    public double getTax() {
        return income * 0.2;
    }*/
}
