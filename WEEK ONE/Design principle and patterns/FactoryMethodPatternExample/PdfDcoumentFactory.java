public class PdfDcoumentFactory extends DocumentFactory 
{

    @Override
    public Documents createDocument() 
    {
        return new Pdf();
    }
    
}
