package org.lldpractice.ratelimiter;

import org.lldpractice.ratelimiter.config.Limit;
import org.lldpractice.ratelimiter.config.RequestLimitConfig;
import org.lldpractice.ratelimiter.enums.UnitType;
import org.lldpractice.ratelimiter.service.RateLimiterService;
import org.lldpractice.ratelimiter.strategy.fixedwindow.FixedWindowCounterStrategy;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Limit limit = new Limit(1, UnitType.MINUTES, 10);
        Map<String, Limit> map = new HashMap<>();
        map.put("10ReqPerMinute", limit);
        RequestLimitConfig requestLimitConfig = new RequestLimitConfig(map);
        RateLimiterService rateLimiterService =
                new RateLimiterService(new FixedWindowCounterStrategy(requestLimitConfig.limitStore.get("10ReqPerMinute")));

        int count = 0;
        while(count < 15)
        {
            rateLimiterService.Request("Mathu");
            count++;
        }
    }
}
