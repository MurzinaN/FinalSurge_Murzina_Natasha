package enums;

public enum StressAmount {
    SELECT("Select..."),
    LOW("Low"),
    MODERATE("Moderate"),
    HIGH("High");

    private final String stressAmount;

    StressAmount(String stressAmount) {
        this.stressAmount = stressAmount;
    }

    public static StressAmount fromString(String value) {
        for (StressAmount contactStressAmount : StressAmount.values()) {
            if (contactStressAmount.getName().equals(value)) {
                return contactStressAmount;
            }
        }
        return null;
    }

    public String getName() {
        return this.stressAmount;
    }
}
