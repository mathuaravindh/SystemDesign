package org.lldpractice.ratelimiter.strategy.fixedwindow;

import org.lldpractice.ratelimiter.config.Limit;
import org.lldpractice.ratelimiter.strategy.RateLimiterStrategy;
import org.lldpractice.ratelimiter.strategy.fixedwindow.Counter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowCounterStrategy implements RateLimiterStrategy {

    private final Limit requestLimit;
    private Map<String, Counter> fixedWindowCounter; //String Key for userId/IP/GLOBAL

/*  In fixed window rate limiting, we don’t maintain counters per window explicitly.
    The window is derived from the current timestamp, and each key stores only the active window counter.
    When the window changes, the old counter is replaced.*/

    public FixedWindowCounterStrategy(Limit requestLimit) {
        this.requestLimit = requestLimit;
        this.fixedWindowCounter = new ConcurrentHashMap<>();
    }

    /* NOT THREAD SAFE
    @Override

    public boolean allowRequest(String key) {

        long now = System.currentTimeMillis();
        long windowSize = requestLimit.windowSizeMillis();
        long currentWindowStart = (now / windowSize) * windowSize;

        Counter counter = fixedWindowCounter.get(key);
        if (counter == null || counter.getWindowStart() != currentWindowStart) {
            fixedWindowCounter.put(key, new Counter(currentWindowStart, 1));
            return true;
        }

        if (counter.getCount() < requestLimit.getMaxRequests()) {
            counter.increment();
            return true;
        }

        return false;
    }
    */

    //THREAD SAFE
    @Override
    public boolean allowRequest(String key) {

        long now = System.currentTimeMillis();
        long windowSize = requestLimit.windowSizeMillis();
        long currentWindowStart = (now / windowSize) * windowSize;

        return fixedWindowCounter.compute(key, (k, counter) -> {

            // First request OR window expired
            if (counter == null || counter.getWindowStart() != currentWindowStart) {
                return new Counter(currentWindowStart, 1);
            }

            /*// Same window, under limit
            if (counter.getCount() < requestLimit.getMaxRequests()) {
                counter.increment();
                return counter;
            }*/

            // Limit exceeded → keep counter unchanged
            counter.increment();
            return counter;

        }).getCount() <= requestLimit.getMaxRequests();
    }

}
