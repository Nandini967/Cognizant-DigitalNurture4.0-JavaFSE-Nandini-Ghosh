public class FinancialForecaster 
{

    public double forecast(double initialAmount, double growthRate, int years) 
    {
        if (years == 0) 
            return initialAmount;

        return forecast(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }
}
 // Time complexity : O(n)


 // More optimized version of the code
 /*
  * public class FinancialForecastorOptimized 
    {

        public double forecastIterative(double initialAmount, double growthRate, int years) 
        {
        double futureValue = initialAmount;
        for (int i = 0; i < years; i++) 
        {
            futureValue *= (1 + growthRate);
        }
    return futureValue;
    }
    }
  */