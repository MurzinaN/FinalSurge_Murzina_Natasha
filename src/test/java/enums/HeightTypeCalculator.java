package enums;

public enum HeightTypeCalculator {
    INCHES("i"),
    CENTIMETERS("m");

    private final String heightTypeCalculator;

    HeightTypeCalculator(String heightTypeCalculator) {
        this.heightTypeCalculator = heightTypeCalculator;
    }

    public String getName() {
        return heightTypeCalculator;
    }
}
