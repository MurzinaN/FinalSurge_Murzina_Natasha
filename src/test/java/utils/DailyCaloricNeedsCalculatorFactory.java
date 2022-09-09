package utils;

import enums.DistanceTypeCalculator;
import enums.GenderTypeCalculator;
import enums.HeightTypeCalculator;
import enums.WeightTypeCalculator;
import models.DailyCaloricNeedsCalculator;
import models.DailyVitals;

public class DailyCaloricNeedsCalculatorFactory {
    public static DailyCaloricNeedsCalculator getDailyCaloricNeedsCalculator() {
        return DailyCaloricNeedsCalculator.builder()
                .weight("80")
                .weightTypeCalculator(WeightTypeCalculator.KG)
                .height("180")
                .heightTypeCalculator(HeightTypeCalculator.CENTIMETERS)
                .age("30")
                .genderTypeCalculator(GenderTypeCalculator.MALE)
                .distance("10")
                .distanceTypeCalculator(DistanceTypeCalculator.KILOMETERS)
                .build();
    }
}
