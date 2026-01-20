package org.lldpractice.ratelimiter.config;

import java.util.HashMap;
import java.util.Map;

public class RequestLimitConfig {
    public final Map<String, Limit> limitStore;

    public RequestLimitConfig(Map<String, Limit> limitStore) {
        this.limitStore = Map.copyOf(limitStore);
    }
}
