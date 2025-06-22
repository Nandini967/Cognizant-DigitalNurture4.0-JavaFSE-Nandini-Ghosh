public class ExcelDocumentFactory extends DocumentFactory
{

    @Override
    public Documents createDocument() {
        return new Excel();
    }
    
}
