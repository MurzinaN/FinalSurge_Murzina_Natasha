package enums;

public enum PerceivedEffort {
    SELECT("Select..."),
    VERY_LIGHT_1("1 (Very Light)"),
    LIGHT_2("2 (Light)"),
    LIGHT_3("3 (Light)"),
    MODERATE_4("4 (Moderate)"),
    MODERATE_5("5 (Moderate)"),
    MODERATE_6("6 (Moderate)"),
    HARD_7("7 (Hard)"),
    HARD_8("8 (Hard)"),
    VERY_HARD_9("9 (Very Hard)"),
    MAX_EFFORT_10("10 (Max Effort)");
    private final String perceivedEffort;

    PerceivedEffort(String perceivedEffort) {
        this.perceivedEffort = perceivedEffort;
    }

    public static PerceivedEffort fromString(String value) {
        for (PerceivedEffort contactPerceivedEffort : PerceivedEffort.values()) {
            if (contactPerceivedEffort.getName().equals(value)) {
                return contactPerceivedEffort;
            }
        }
        return null;
    }

    public String getName() {
        return this.perceivedEffort;
    }
}
