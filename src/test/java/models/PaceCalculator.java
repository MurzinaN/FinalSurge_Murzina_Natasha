package models;

import enums.DistanceTypePaceCalculator;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PaceCalculator {
    private String distance;
    private DistanceTypePaceCalculator distanceTypePaceCalculator;
    private String hours;
    private String minutes;
    private String seconds;

}
