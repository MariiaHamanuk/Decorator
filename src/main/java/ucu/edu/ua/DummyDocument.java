package ucu.edu.ua;

public class DummyDocument implements Document {
    private final String content;
    private final long delayMs;

    public DummyDocument(String content, long delayMs) {
        this.content = content;
        this.delayMs = delayMs;
    }

    @Override
    public String parse() {
        if (delayMs > 0) {
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return content;
    }

    // --- THIS IS THE MISSING METHOD ---
    @Override
    public String getGcsPath() {
        // Return a "dummy" path. It just needs to be unique.
        return "dummy_id_" + content.hashCode();
    }
    // ------------------------------------

    public String getContent() {
        return content;
    }
}