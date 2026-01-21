package org.lldpractice.ratelimiter.strategy.slidingwindow;

import org.lldpractice.ratelimiter.config.Limit;
import org.lldpractice.ratelimiter.strategy.RateLimiterStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterStrategy implements RateLimiterStrategy {

    private final long windowSizeMillis;
    private final long bucketSizeMillis;
    private final int maxRequests;

    private final Map<String, SlidingWindowState> store =
            new ConcurrentHashMap<>();

    public SlidingWindowCounterStrategy(
            Limit requestLimit) {

        this.windowSizeMillis = requestLimit.windowSizeMillis();
        this.bucketSizeMillis = 1000L;
        this.maxRequests = requestLimit.getMaxRequests();
    }

    @Override
    public boolean allowRequest(String key) {

        long now = System.currentTimeMillis();
        long bucketStart = (now / bucketSizeMillis) * bucketSizeMillis;
        long validWindowStart = now - windowSizeMillis;

        return store.compute(key, (k, state) -> {

            if (state == null) {
                state = new SlidingWindowState();
            }

            // Evict expired buckets
            state.evictExpired(validWindowStart);

            Bucket last = state.getLastBucket();
            boolean newBucket = (last == null || last.getBucketStart() != bucketStart);

            // Apply change
            if (newBucket) {
                state.addNewBucket(bucketStart);
            } else {
                state.incrementLastBucket();
            }

            // Enforce limit
            /*if (state.getTotalCount() > maxRequests) {
                // rollback
                if (newBucket) {
                    state.rollbackNewBucket();
                } else {
                    state.rollbackIncrement();
                }
            }*/

            return state;

        }).getTotalCount() <= maxRequests;
    }
}

