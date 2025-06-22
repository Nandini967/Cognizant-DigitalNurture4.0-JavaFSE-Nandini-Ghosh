public class LinearSearch implements SearchStrategy 
{
    @Override
    public Product search(Product[] products, int targetId) 
    {
        for (int i=0; i<products.length; i++) 
        {
            Product product = products[i];
            if (product.getProductId() == targetId) 
                return product;
            
        }
        return null;
    }
}

