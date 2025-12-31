package org.lldpractice.lrucache.cache;

import org.lldpractice.lrucache.customlinkedlist.CustomLinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheCustom {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final CustomLinkedList dll;
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public LRUCacheCustom(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        this.dll = new CustomLinkedList();
    }

    public int getCapacity() {
        return capacity;
    }


    public void put(int key, String value) {
        reentrantLock.lock();
        try {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                dll.moveToTail(node);
                node.setData(value);
                cache.put(key, node);
                return;
            }
        } finally {
            reentrantLock.unlock();
        }

        if (cache.size() == this.getCapacity()) {
            System.out.println("cache is full removing least recently used key : " + dll.getFirst().key);
            cache.remove(dll.getFirst().getKey());
            dll.removeFirst();
        }

        Node node = new Node(key, value);
        dll.addLast(node);
        cache.put(key, node);
    }

    public String get(int key) {
        reentrantLock.lock();
        try {
            Node node = cache.get(key);
            if (node == null) {
                System.out.println("Key not present in cache");
                return null;
            } else {
                dll.moveToTail(node);
                System.out.println("key : " + key + " value : " + node.data);
                return node.data;
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
