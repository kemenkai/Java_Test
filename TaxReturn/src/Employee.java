public class Employee extends Income{
    public Employee(double income){
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }
}
