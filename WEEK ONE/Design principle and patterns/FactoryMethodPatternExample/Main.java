public class Main 
{
    public static void main(String[] args) 
    {
        DocumentFactory obj = new WordDocumentFactory();
        Documents ob = obj.createDocument();
        ob.doctype();
    }

}
