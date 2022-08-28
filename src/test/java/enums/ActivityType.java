package enums;

public enum ActivityType {
    SELECT("Select..."),
    RUN("Run"),
    RUN_FARTLEK("    -Run: Fartlek"),
    RUN_HILLS("    -Run: Hills"),
    RUN_LACTATE_THRESHOLD("    -Run: Lactate Threshold"),
    RUN_LONG_RUN("    -Run: Long Run"),
    RUN_MARATHON_PACE("    -Run: Marathon Pace"),
    RUN_TEMPO_RUN("    -Run: Tempo Run"),
    RUN_TRACK_WORKOUT("    -Run: Track Workout"),
    RUN_V02_MAX("    -Run: VO2 Max"),
    BIKE("Bike"),
    BIKE_INTERVALS("    -Bike: Intervals"),
    BIKE_LONG_RIDE("    -Bike: Long Ride"),
    BIKE_POWER_STRENGTH("    -Bike: Power/Strength"),
    BIKE_RECOVERY_RIDE("    -Bike: Recovery Ride"),
    BIKE_TEMPO("    -Bike: Tempo"),
    BIKE_TIME_TRIAL("    -Bike: Time Trial"),
    BIKE_TRAINER("    -Bike: Trainer"),
    SWIM("Swim"),
    SWIM_DRILLS("    -Swim: Drills"),
    SWIM_ENDURANCE("    -Swim: Endurance"),
    SWIM_INTERVALS("    -Swim: Intervals"),
    SWIM_OPEN_WATER("    -Swim: Open Water"),
    SWIM_RECOVERY_SWIM("    -Swim: Recovery Swim"),
    SWIM_TEMPO("    -Swim: Tempo"),
    CROSS_TRAINING("Cross Training"),
    WALK("Walk"),
    REST_DAY("Rest Day"),
    STRENGTH_TRAINING("Strength Training"),
    RECOVERY_REHAB("Recovery/Rehab"),
    RECOVERY_REHAB_ACTIVE_RELEASE("    -Recovery/Rehab: Active Release"),
    RECOVERY_REHAB_CHIROPRACTOR("    -Recovery/Rehab: Chiropractor"),
    RECOVERY_REHAB_MASSAGE("    -Recovery/Rehab: Massage"),
    RECOVERY_REHAB_PHYSICAL_THERAPY("    -Recovery/Rehab: Physical Therapy"),
    OTHER("Other"),
    OTHER_APPOINTMENT("    -Other: Appointment"),
    OTHER_ILLNESS("    -Other: Illness"),
    OTHER_INJURY("    -Other: Injury"),
    OTHER_NOTES("    -Other: Notes"),
    TRANSITION("Transition");
    private final String activityType;

    ActivityType(String activityType) {
        this.activityType = activityType;
    }

    public static ActivityType fromString(String value) {
        for (ActivityType contactActivityType : ActivityType.values()) {
            if (contactActivityType.getName().equals(value)) {
                return contactActivityType;
            }
        }
        return null;
    }

    public String getName() {
        return this.activityType;
    }
}
