public class RoyaltyIncome extends Income{
    public RoyaltyIncome(double income){
        super(income);
    }

    @Override
    public double getTax(){
        if (income < 4000){
            return (income - 800) * 0.2 * 0.7;
        }
        return income * (1 - 0.2) * 0.2 * 0.7;
    }
}
