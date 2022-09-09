package enums;

public enum ShoeSize {
    SELECT_SIZE("Select size..."),
    SIZE_1("1"),
    SIZE_1_5("1.5"),
    SIZE_2("2"),
    SIZE_2_5("2.5"),
    SIZE_3("3"),
    SIZE_3_5("3.5"),
    SIZE_4("4"),
    SIZE_4_5("4.5"),
    SIZE_5("5"),
    SIZE_5_5("5.5"),
    SIZE_6("6"),
    SIZE_6_5("6.5"),
    SIZE_7("7"),
    SIZE_7_5("7.5"),
    SIZE_8("8"),
    SIZE_8_5("8.5"),
    SIZE_9("9"),
    SIZE_9_5("9.5"),
    SIZE_10("10"),
    SIZE_10_5("10.5"),
    SIZE_11("11"),
    SIZE_11_5("11.5"),
    SIZE_12("12"),
    SIZE_12_5("12.5"),
    SIZE_13("13"),
    SIZE_13_5("13.5"),
    SIZE_14("14"),
    SIZE_14_5("14.5"),
    SIZE_15("15"),
    SIZE_15_5("15.5"),
    SIZE_16("16"),
    SIZE_16_5("16.5"),
    SIZE_17("17"),
    SIZE_17_5("17.5"),
    SIZE_18("18"),
    SIZE_18_5("18.5"),
    SIZE_19("19"),
    SIZE_19_5("19.5"),
    SIZE_20("20");
    private final String shoeSize;

    ShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }

    public static ShoeSize fromString(String value) {
        for (ShoeSize contactShoeSize : ShoeSize.values()) {
            if (contactShoeSize.getName().equals(value)) {
                return contactShoeSize;
            }
        }
        return null;
    }

    public String getName() {
        return this.shoeSize;
    }
}
