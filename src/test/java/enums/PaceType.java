package enums;


public enum PaceType {
    MIN_MI("min/mi"),
    MIN_KM("min/km"),
    MPH("mph"),
    KPH("kph"),
    MIN_100_M("min/100m"),
    MIN_100_Y("min/100y"),
    MIN_1500_M("min/1500m");
    private final String paceType;


    PaceType(String paceType) {
        this.paceType = paceType;
    }

    public static PaceType fromString(String value) {
        for (PaceType contactPaceType : PaceType.values()) {
            if (contactPaceType.getName().equals(value)) {
                return contactPaceType;
            }
        }
        return null;
    }

    public String getName() {
        return this.paceType;
    }
}
