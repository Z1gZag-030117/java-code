package com.Collection;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRU<K, V> extends LinkedHashMap<K, V> {

    public LRU(int initialCapacity) {
        super(initialCapacity, 0.75F, true);
    }

    public LRU() {
        super(16, 0.75F, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 3;
    }
}
