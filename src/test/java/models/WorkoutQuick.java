package models;

import enums.*;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class WorkoutQuick {
    private TimeOfDay timeOfDay;
    private ActivityType activityType;
    private String workoutName;
    private String workoutDescription;
    private String distance;
    private DistanceType distanceType;
    private String duration;
    private PaceType paceType;
    private HowIFelt howIFelt;
    private PerceivedEffort perceivedEffort;
    private String postWorkoutNotes_Results;

}
