package models;

import enums.SleepAmount;
import enums.SleepQuality;
import enums.StressAmount;
import enums.WeightType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DailyVitals {
    private String steps;
    private String caloriesConsumed;
    private String weight;
    private WeightType weightType;
    private String bodyFat;
    private String water;
    private String muscleMass;
    private WeightType muscleMassType;
    private String restingHR;
    private String hRVariability;
    private String sleepHours;
    private String totalAwakeTime;
    private SleepAmount sleepAmount;
    private SleepQuality sleepQuality;
    private StressAmount stressAmount;
    private String systolic;
    private String diastolic;
    private String healthNotes;

}
