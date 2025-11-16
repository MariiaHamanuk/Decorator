package ucu.edu.ua;


public abstract class AbstractDocumentDecorator implements Document {
    protected Document document;

    public AbstractDocumentDecorator(Document document) {
        this.document = document;
    }
    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
    @Override
    public String parse() {
        return document.parse();
    }

}