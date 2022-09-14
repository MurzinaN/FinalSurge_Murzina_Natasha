package enums;

public enum DistanceTypeShoes {
    MI("mi"),
    KM("km");
    private final String distanceTypeShoes;

    DistanceTypeShoes(String distanceTypeShoes) {
        this.distanceTypeShoes = distanceTypeShoes;
    }

    public static DistanceTypeShoes fromString(String value) {
        for (DistanceTypeShoes contactDistanceTypeShoes : DistanceTypeShoes.values()) {
            if (contactDistanceTypeShoes.getName().equals(value)) {
                return contactDistanceTypeShoes;
            }
        }
        return null;
    }


    public String getName() {
        return this.distanceTypeShoes;
    }
}
