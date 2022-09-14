package enums;

public enum DistanceTypePaceCalculator {
    MILES("Miles"),
    KILOMETERS("Kilometers"),
    METERS("Meters"),
    YARD("Yard"),
    FEET("Feet");
    private final String distanceTypePaceCalculator;

    DistanceTypePaceCalculator(String distanceTypePaceCalculator) {
        this.distanceTypePaceCalculator = distanceTypePaceCalculator;
    }

    public static DistanceTypePaceCalculator fromString(String value) {
        for (DistanceTypePaceCalculator contactDistanceTypePaceCalculator : DistanceTypePaceCalculator.values()) {
            if (contactDistanceTypePaceCalculator.getName().equals(value)) {
                return contactDistanceTypePaceCalculator;
            }
        }
        return null;
    }


    public String getName() {
        return this.distanceTypePaceCalculator;
    }
}
