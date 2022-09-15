package utils;

import enums.DistanceTypePaceCalculator;
import models.PaceCalculator;

public class PaceCalculatorFactory {
    public static PaceCalculator getPaceCalculator() {
        return PaceCalculator.builder()
                .distance("10")
                .distanceTypePaceCalculator(DistanceTypePaceCalculator.KILOMETERS)
                .hours("1")
                .minutes("50")
                .seconds("10")
                .build();
    }
}
