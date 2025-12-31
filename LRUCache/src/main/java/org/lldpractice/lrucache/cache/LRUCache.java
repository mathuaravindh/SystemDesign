package org.lldpractice.lrucache.cache;

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Deque<Node> dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        dll = new LinkedList<>();
    }

    public int getCapacity() {
        return capacity;
    }


    public synchronized void put(int key, String value)
    {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            dll.remove(node);               //.remove is O(N) since java doesn't expose the node ref
            node.setData(value);
            dll.addLast(node);
            cache.put(key, node);
            return;
        }

        if (cache.size() == this.getCapacity())
        {
            System.out.println("cache is full removing least recently used key : " + dll.getFirst().key);
            cache.remove(dll.getFirst().getKey());
            dll.removeFirst();
        }

        Node node = new Node(key, value);
        dll.addLast(node);
        cache.put(key, node);


    }

    public synchronized String get(int key)
    {
        Node node = cache.get(key);
        if(node == null) {
            System.out.println("Key not present in cache");
            return null;
        }
        else {
            dll.remove(node);
            dll.addLast(node);
            System.out.println("key : " + key + " value : " + node.data);
            return node.data;
        }
    }
}
