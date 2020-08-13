public class RoyaltyIncome implements Income {
    double income;
    public RoyaltyIncome(double income){
        this.income = income;
    }

    @Override
    public double getTax(){
        if (income < 4000){
            return (income - 800) * 0.2 * 0.7;
        }
        return income * (1 - 0.2) * 0.2 * 0.7;
    }
}
