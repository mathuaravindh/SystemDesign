package org.lldpractice.ratelimiter.strategy.fixedwindow;

public class Counter {
    private final long windowStart;
    private int count;

    public Counter(long windowStart, int count) {
        this.windowStart = windowStart;
        this.count = count;
    }

    public long getWindowStart() {
        return windowStart;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}
