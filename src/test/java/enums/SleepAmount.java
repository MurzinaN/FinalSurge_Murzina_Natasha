package enums;

public enum SleepAmount {
    SELECT("Select..."),
    HARDLY_ANY("Hardly Any"),
    NOT_ENOUGH("Not Enough"),
    ENOUGH("Enough"),
    MORE_THEN_ENOUGH("More Than Enough");

    private final String sleepAmount;

    SleepAmount(String sleepAmount) {
        this.sleepAmount = sleepAmount;
    }

    public static SleepAmount fromString(String value) {
        for (SleepAmount contactSleepAmount : SleepAmount.values()) {
            if (contactSleepAmount.getName().equals(value)) {
                return contactSleepAmount;
            }
        }
        return null;
    }

    public String getName() {
        return this.sleepAmount;
    }
}
