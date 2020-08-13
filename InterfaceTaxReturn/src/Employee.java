public class Employee implements Income {
    double income;
    public Employee(double income){
        this.income = income;
    }

    public double getTax(){
        return income * 0.2;
    }
}
