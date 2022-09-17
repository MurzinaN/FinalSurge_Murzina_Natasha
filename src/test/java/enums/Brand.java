package enums;

public enum Brand {
    ADIDAS("adidas"),
    ALTRA("Altra"),
    ASICS("ASICS"),
    AVIA("Avia"),
    BROOKS("Brooks"),
    HOKA_ONE_ONE("Hoka One One"),
    INOV_8("Inov-8"),
    K_SWISS("K-SWISS"),
    MERRELL("Merrell"),
    MIZUNO("Mizuno"),
    MONTRAIL("Montrail"),
    NEW_BALANCE("New Balance"),
    NEWTON_RUNNING("Newton Running"),
    NIKE("Nike"),
    NOBULL("NOBULL"),
    ON("On"),
    PEARL_IZUMI("Pearl Izumi"),
    PUMA("Puma"),
    REEBOK("Reebok"),
    RYKA("Ryka"),
    SALOMON("Salomon"),
    SAUCONY("Saucony"),
    SCOTT("SCOTT"),
    SKECHERS("Skechers"),
    SKORA("SKORA"),
    SPIRA("Spira"),
    UK_GEAR("UK Gear"),
    UNDER_ARMOUR("Under Armour"),
    VIBRAM_FIVEFINGERS("Vibram FiveFingers"),
    VIVOBAREFOOT("VIVOBAREFOOT"),
    ZOOT("Zoot");
    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public static Brand fromString(String value) {
        for (Brand contactBrand : Brand.values()) {
            if (contactBrand.getName().equals(value)) {
                return contactBrand;
            }
        }
        return null;
    }

    public String getName() {
        return this.brand;
    }
}
