package com.example.cache;

import java.util.*;

public class ReferenceCache {

    public static Map<String, String> load() {

        Map<String, String> cache = new HashMap<>();

        // Simulated DB/API data
        cache.put("ADMIN", "Administrator");
        cache.put("USER", "Standard User");
        cache.put("GUEST", "Guest User");

        if (cache.isEmpty()) {
            throw new RuntimeException("Reference cache empty!");
        }

        return Collections.unmodifiableMap(cache);
    }
}

