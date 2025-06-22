public class Main 
{
    public static void main(String[] args) 
    {
        Product[] products = 
        {
            new Product(103, "Phone", "Electronics"),
            new Product(101, "Shirt", "Clothing"),
            new Product(105, "Laptop", "Electronics"),
            new Product(102, "Book", "Education"),
            new Product(104, "Shoes", "Footwear")
        };

        int searchId = 105;

        // linear search
        SearchStrategy linear = new LinearSearch();
        long start1 = System.nanoTime();
        Product result1 = linear.search(products, searchId);
        long end1 = System.nanoTime();

        System.out.println("Linear Search:");
        System.out.println("Result: " + result1);
        System.out.println("Time Taken: " + (end1 - start1) + " ns");

        // Binary Search
        SearchStrategy binary = new BinarySearch();
        long start2 = System.nanoTime();
        Product result2 = binary.search(products, searchId);
        long end2 = System.nanoTime();

        System.out.println("\nBinary Search:");
        System.out.println("Result: " + result2);
        System.out.println("Time Taken: " + (end2 - start2) + " ns");
    }
}
