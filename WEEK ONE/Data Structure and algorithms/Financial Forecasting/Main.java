public class Main 
{
    public static void main(String[] args) 
    {
        FinancialForecaster forecaster = new FinancialForecaster();

        double initialAmount = 10000.0;     
        double growthRate = 0.08;           
        int years = 5;                      

        double futureValue = forecaster.forecast(initialAmount, growthRate, years);

        System.out.println("Initial Amount: ₹" + initialAmount);
        System.out.println("Growth Rate: " + (growthRate * 100) + "% per year");
        System.out.println("Years: " + years);
        System.out.printf("Future Value: %.2f\n", futureValue);
    }
}

