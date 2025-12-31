package org.lldpractice.parkinglot.config;
import org.lldpractice.parkinglot.enums.SpotType;
import java.util.HashMap;
import java.util.Map;

public class PricingConfig {
    private static final Map<SpotType, SpotPricing> pricingConfigMap = new HashMap<>();

    static {
        pricingConfigMap.put(SpotType.SMALL, new SpotPricing(10, 20));
        pricingConfigMap.put(SpotType.MEDIUM, new SpotPricing(15, 30));
        pricingConfigMap.put(SpotType.LARGE, new SpotPricing(20, 50));
    }

    public static SpotPricing getPricing(SpotType spotType) {
        return pricingConfigMap.get(spotType);
    }
}
