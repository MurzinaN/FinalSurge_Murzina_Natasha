package enums;


public enum SleepQuality {
    SELECT("Select..."),
    GOOD("Good"),
    MODERATE("Moderate"),
    POOR("Poor");

    private final String sleepQuality;

    SleepQuality(String sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public static SleepQuality fromString(String value) {
        for (SleepQuality contactSleepQuality : SleepQuality.values()) {
            if (contactSleepQuality.getName().equals(value)) {
                return contactSleepQuality;
            }
        }
        return null;
    }

    public String getName() {
        return this.sleepQuality;
    }
}
