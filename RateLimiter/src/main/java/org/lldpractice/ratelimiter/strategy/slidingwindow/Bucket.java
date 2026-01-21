package org.lldpractice.ratelimiter.strategy.slidingwindow;


//Used to track request per unit of time, we group requests under a bound (1s) so it is prone to bound error.
public class Bucket {
    private final long bucketStart;
    private int count;

    public Bucket(long bucketStart) {
        this.bucketStart = bucketStart;
        this.count = 1;
    }

    public long getBucketStart() {
        return bucketStart;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}
