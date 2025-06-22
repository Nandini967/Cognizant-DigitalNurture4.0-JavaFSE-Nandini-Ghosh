public class BinarySearch implements SearchStrategy 
{
    @Override
    public Product search(Product[] products, int targetId) 
    {
        ProductSorter.sortByProductId(products); 
        int left = 0, right = products.length - 1;

        while (left <= right) 
        {
            int mid = (left + right) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) 
                return products[mid];
            else if (midId < targetId)
                left = mid + 1;
            else 
                right = mid - 1;
            
        }
        return null;
    }
}

