package enums;


public enum WeightTypeCalculator {
    LBS("l"),
    KG("k");

    private final String weightTypeCalculator;

    WeightTypeCalculator(String weightTypeCalculator) {
        this.weightTypeCalculator = weightTypeCalculator;
    }

    public String getName() {
        return weightTypeCalculator;
    }
}
