package enums;

public enum HowIFelt {
    SELECT("Select..."),
    GREAT("Great"),
    GOOD("Good"),
    NORMAL("Normal"),
    POOR("Poor"),
    TERRIBLE("Terrible");
    private final String howIFelt;

    HowIFelt(String howIFelt) {
        this.howIFelt = howIFelt;
    }

    public static HowIFelt fromString(String value) {
        for (HowIFelt contactHowIFelt : HowIFelt.values()) {
            if (contactHowIFelt.getName().equals(value)) {
                return contactHowIFelt;
            }
        }
        return null;
    }

    public String getName() {
        return this.howIFelt;
    }
}
