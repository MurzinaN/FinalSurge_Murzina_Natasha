package enums;

public enum WeightType {
    LBS("lbs"),
    KG("kg");
    private final String weightType;

    WeightType(String weightType) {
        this.weightType = weightType;
    }

    public static WeightType fromString(String value) {
        for (WeightType contactWeightType : WeightType.values()) {
            if (contactWeightType.getName().equals(value)) {
                return contactWeightType;
            }
        }
        return null;
    }

    public String getName() {
        return this.weightType;
    }
}
