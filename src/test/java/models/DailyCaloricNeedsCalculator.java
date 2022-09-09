package models;

import enums.DistanceTypeCalculator;
import enums.GenderTypeCalculator;
import enums.HeightTypeCalculator;
import enums.WeightTypeCalculator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DailyCaloricNeedsCalculator {
    private String weight;
    private WeightTypeCalculator weightTypeCalculator;
    private String height;
    private HeightTypeCalculator heightTypeCalculator;
    private String age;
    private GenderTypeCalculator genderTypeCalculator;
    private String distance;
    private DistanceTypeCalculator distanceTypeCalculator;

}
