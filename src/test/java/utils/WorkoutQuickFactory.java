package utils;

import com.github.javafaker.Faker;
import enums.*;
import models.WorkoutQuick;

public class WorkoutQuickFactory {
    private static final Faker faker = new Faker();

    public static WorkoutQuick getWorkoutQuickAllData() {
        return WorkoutQuick.builder()
                .timeOfDay(TimeOfDay.AM_01_45)
                .activityType(ActivityType.BIKE_INTERVALS)
                .workoutName(faker.name().firstName())
                .workoutDescription(faker.name().username())
                .distance("10.00")
                .distanceType(DistanceType.KM)
                .duration("02:00:00")
                .paceType(PaceType.MIN_KM)
                .howIFelt(HowIFelt.GOOD)
                .perceivedEffort(PerceivedEffort.LIGHT_2)
                .postWorkoutNotes_Results(faker.name().username())
                .build();
    }

    public static WorkoutQuick getWorkoutQuickWithActivityType() {
        return WorkoutQuick.builder()
                .workoutName(faker.name().firstName())
                .activityType(ActivityType.OTHER)
                .build();
    }

    public static WorkoutQuick getWorkoutQuickWithDistance() {
        return WorkoutQuick.builder()
                .activityType(ActivityType.SWIM_OPEN_WATER)
                .workoutName(faker.name().firstName())
                .distance("10.00")
                .distanceType(DistanceType.KM)
                .duration("02:00:00")
                .paceType(PaceType.MIN_KM)
                .build();
    }

    public static WorkoutQuick copyWorkoutQuick(String workoutName, ActivityType activityType, String workoutDescription) {
        return WorkoutQuick.builder()
                .workoutName(workoutName)
                .activityType(activityType)
                .workoutDescription(workoutDescription)
                .build();
    }

    public static WorkoutQuick uploadWorkoutQuick() {
        return WorkoutQuick.builder()
                .workoutName("OneTraining")
                .activityType(ActivityType.RUN_HILLS)
                .distance("6.60")
                .distanceType(DistanceType.MI)
                .duration("02:33:31")
                .paceType(PaceType.MIN_MI)
                .build();
    }

}
