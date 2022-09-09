package enums;

public enum GenderTypeCalculator {
    MALE("m"),
    FEMALE("f");

    private final String genderTypeCalculator;

    GenderTypeCalculator(String genderTypeCalculator) {
        this.genderTypeCalculator = genderTypeCalculator;
    }

    public String getName() {
        return genderTypeCalculator;
    }
}
