package enums;


public enum TimeOfDay {
    AM_12_00("12:00 AM"),
    AM_12_15("12:15 AM"),
    AM_12_30("12:30 AM"),
    AM_12_45("12:45 AM"),
    AM_01_00("01:00 AM"),
    AM_01_15("01:15 AM"),
    AM_01_30("01:30 AM"),
    AM_01_45("01:45 AM"),
    AM_02_00("02:00 AM"),
    AM_02_15("02:15 AM"),
    AM_02_30("02:30 AM"),
    AM_02_45("02:45 AM"),
    AM_03_00("03:00 AM"),
    AM_03_15("03:15 AM"),
    AM_03_30("03:30 AM"),
    AM_03_45("03:45 AM"),
    AM_04_00("04:00 AM"),
    AM_04_15("04:15 AM"),
    AM_04_30("04:30 AM"),
    AM_04_45("04:45 AM"),
    AM_05_00("05:00 AM"),
    AM_05_15("05:15 AM"),
    AM_05_30("05:30 AM"),
    AM_05_45("05:45 AM"),
    AM_06_00("06:00 AM"),
    AM_06_15("06:15 AM"),
    AM_06_30("06:30 AM"),
    AM_06_45("06:45 AM"),
    AM_07_00("07:00 AM"),
    AM_07_15("07:15 AM"),
    AM_07_30("07:30 AM"),
    AM_07_45("07:45 AM"),
    AM_08_00("08:00 AM"),
    AM_08_15("08:15 AM"),
    AM_08_30("08:30 AM"),
    AM_08_45("08:45 AM"),
    AM_09_00("09:00 AM"),
    AM_09_15("09:15 AM"),
    AM_09_30("09:30 AM"),
    AM_09_45("09:45 AM"),
    AM_10_00("10:00 AM"),
    AM_10_15("10:15 AM"),
    AM_10_30("10:30 AM"),
    AM_10_45("10:45 AM"),
    AM_11_00("11:00 AM"),
    AM_11_15("11:15 AM"),
    AM_11_30("11:30 AM"),
    AM_11_45("11:45 AM"),
    PM_12_00("12:00 PM"),
    PM_12_15("12:15 PM"),
    PM_12_30("12:30 PM"),
    PM_12_45("12:45 PM"),
    PM_01_00("01:00 PM"),
    PM_01_15("01:15 PM"),
    PM_01_30("01:30 PM"),
    PM_01_45("01:45 PM"),
    PM_02_00("02:00 PM"),
    PM_02_15("02:15 PM"),
    PM_02_30("02:30 PM"),
    PM_02_45("02:45 PM"),
    PM_03_00("03:00 PM"),
    PM_03_15("03:15 PM"),
    PM_03_30("03:30 PM"),
    PM_03_45("03:45 PM"),
    PM_04_00("04:00 PM"),
    PM_04_15("04:15 PM"),
    PM_04_30("04:30 PM"),
    PM_04_45("04:45 PM"),
    PM_05_00("05:00 PM"),
    PM_05_15("05:15 PM"),
    PM_05_30("05:30 PM"),
    PM_05_45("05:45 PM"),
    PM_06_00("06:00 PM"),
    PM_06_15("06:15 PM"),
    PM_06_30("06:30 PM"),
    PM_06_45("06:45 PM"),
    PM_07_00("07:00 PM"),
    PM_07_15("07:15 PM"),
    PM_07_30("07:30 PM"),
    PM_07_45("07:45 PM"),
    PM_08_00("08:00 PM"),
    PM_08_15("08:15 PM"),
    PM_08_30("08:30 PM"),
    PM_08_45("08:45 PM"),
    PM_09_00("09:00 PM"),
    PM_09_15("09:15 PM"),
    PM_09_30("09:30 PM"),
    PM_09_45("09:45 PM"),
    PM_10_00("10:00 PM"),
    PM_10_15("10:15 PM"),
    PM_10_30("10:30 PM"),
    PM_10_45("10:45 PM"),
    PM_11_00("11:00 PM"),
    PM_11_15("11:15 PM"),
    PM_11_30("11:30 PM"),
    PM_11_45("11:45 PM");
    private final String timeOfDay;

    TimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public static TimeOfDay fromString(String value) {
        for (TimeOfDay contactTimeOfDay : TimeOfDay.values()) {
            if (contactTimeOfDay.getName().equals(value)) {
                return contactTimeOfDay;
            }
        }
        return null;
    }

    public String getName() {
        return this.timeOfDay;
    }
}
