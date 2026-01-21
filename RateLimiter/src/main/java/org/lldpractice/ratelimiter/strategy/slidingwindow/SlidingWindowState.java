package org.lldpractice.ratelimiter.strategy.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

//Since we need total count, we wrap buckets and totalcount in this class.
public class SlidingWindowState {

    private final Deque<Bucket> buckets = new ArrayDeque<>();
    private int totalCount = 0;

    public int getTotalCount() {
        return totalCount;
    }

    public void addBucket(Bucket bucket) {
        buckets.addLast(bucket);
        totalCount += bucket.getCount();
    }

    public void incrementLastBucket() {
        Bucket last = buckets.peekLast();
        last.increment();
        totalCount++;
    }


    public void rollbackNewBucket() {
        Bucket removed = buckets.removeLast();
        totalCount -= removed.getCount();
    }

    public void rollbackIncrement() {
        Bucket last = buckets.peekLast();
        last.decrement();
        totalCount -= 1;
    }

    public void evictExpired(long windowStart) {
        while (!buckets.isEmpty() &&
                buckets.peekFirst().getBucketStart() < windowStart) {

            Bucket expired = buckets.removeFirst();
            totalCount -= expired.getCount();
        }
    }

    public Bucket getLastBucket() {
        return buckets.peekLast();
    }

    public void addNewBucket(long bucketStart) {
        Bucket bucket = new Bucket(bucketStart);
        buckets.addLast(bucket);
        totalCount += 1;
    }
}
