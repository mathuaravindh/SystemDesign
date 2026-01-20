package org.lldpractice.ratelimiter.strategy;

public interface RateLimiterStrategy {
    boolean allowRequest(String key);
}
