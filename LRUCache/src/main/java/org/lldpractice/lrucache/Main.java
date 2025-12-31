package org.lldpractice.lrucache;

import org.lldpractice.lrucache.cache.LRUCache;
import org.lldpractice.lrucache.cache.LRUCacheCustom;


public class Main {
    static void main() {
        LRUCacheCustom cache = new LRUCacheCustom(5);
        cache.put(1, "Mathu");
        cache.put(2, "Mathu");
        cache.put(3, "Mathu");
        cache.put(4, "Mathu");
        cache.put(5, "Mathu");
        cache.put(6, "Mathu");
        cache.put(7, "Mathu");

        cache.get(1);
        cache.get(2);
        cache.get(7);
        cache.get(3);
        cache.get(4);
        cache.get(5);
        cache.get(6);

        cache.put(8, "Mathu");

        cache.get(8);

        System.out.println("----------------------------");
        LRUCache cache1 = new LRUCache(5);
        cache1.put(1, "Mathu");
        cache1.put(2, "Mathu");
        cache1.put(3, "Mathu");
        cache1.put(4, "Mathu");
        cache1.put(5, "Mathu");
        cache1.put(6, "Mathu");
        cache1.put(7, "Mathu");

        cache1.get(1);
        cache1.get(2);
        cache1.get(7);
        cache1.get(3);
        cache1.get(4);
        cache1.get(5);
        cache1.get(6);

        cache1.put(8, "Mathu");

        cache1.get(8);
    }
}
