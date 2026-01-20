package org.lldpractice.ratelimiter.service;

import org.lldpractice.ratelimiter.strategy.RateLimiterStrategy;

public class RateLimiterService {

    private final RateLimiterStrategy rateLimiterStrategy;

    public RateLimiterService(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public void Request(String key)
    {
        if(rateLimiterStrategy.allowRequest(key)) {
            System.out.println("Request by : " + key + " processed successfully");
        }
        else {
            System.out.println("429: Too many requests");
        }

    }
}
