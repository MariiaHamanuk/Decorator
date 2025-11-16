package ucu.edu.ua;

import java.util.HashMap;
import java.util.Map;

public class CachedDocument extends AbstractDocumentDecorator {
    private static final Map<String, String> CACHE = new HashMap<>();


    public CachedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        String cacheKey = super.getGcsPath();

        if (CACHE.containsKey(cacheKey)) {
            System.out.println("[Cache HIT] Using cached result for key: " + cacheKey);
            return CACHE.get(cacheKey);
        }

        System.out.println("Calling underlying document parse...");
        String result = super.parse();

        CACHE.put(cacheKey, result);
        System.out.println("Result saved to cache for key: " + cacheKey);

        return result;
    }

    public static void clearCache() {
        CACHE.clear();
    }
}