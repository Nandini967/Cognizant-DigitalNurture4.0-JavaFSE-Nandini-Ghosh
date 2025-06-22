public class WordDocumentFactory extends DocumentFactory 
{
    @Override
    public Documents createDocument() {
        return new Word();
    }    
}
