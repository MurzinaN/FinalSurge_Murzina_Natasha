package enums;


public enum DistanceType {
    MI("mi"),
    KM("km"),
    M("m"),
    YD("yd");
    private final String distanceType;

    DistanceType(String distanceType) {
        this.distanceType = distanceType;
    }

    public static DistanceType fromString(String value) {
        for (DistanceType contactDistanceType : DistanceType.values()) {
            if (contactDistanceType.getName().equals(value)) {
                return contactDistanceType;
            }
        }
        return null;
    }

    public String getName() {
        return this.distanceType;
    }
}
