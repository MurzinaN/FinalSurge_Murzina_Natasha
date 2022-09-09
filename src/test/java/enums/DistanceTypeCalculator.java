package enums;

public enum DistanceTypeCalculator {
    MILES("m"),
    KILOMETERS("k");

    private final String distanceTypeCalculator;

    DistanceTypeCalculator(String distanceTypeCalculator) {
        this.distanceTypeCalculator = distanceTypeCalculator;
    }

    public String getName() {
        return distanceTypeCalculator;
    }
}
