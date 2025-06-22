public class ProductSorter 
{
    public static void sortByProductId(Product[] products) 
    {
        int n = products.length;
        for (int i=0; i<n-1; i++) 
        {
            for (int j=0; j<n-i-1; j++) 
            {
                if (products[j].getProductId() > products[j + 1].getProductId()) 
                {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }
}
