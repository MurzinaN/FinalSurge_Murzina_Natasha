package utils;


import enums.*;
import models.DailyVitals;


public class DailyVitalsFactory {

    public static DailyVitals getDailyVitalsAllData() {
        return DailyVitals.builder()
                .steps("15000")
                .caloriesConsumed("2000")
                .weight("50")
                .weightType(WeightType.KG)
                .bodyFat("20")
                .water("30")
                .muscleMass("10")
                .muscleMassType(WeightType.KG)
                .restingHR("6")
                .hRVariability("5")
                .sleepHours("8")
                .totalAwakeTime("13")
                .sleepAmount(SleepAmount.ENOUGH)
                .sleepQuality(SleepQuality.GOOD)
                .stressAmount(StressAmount.HIGH)
                .systolic("120")
                .diastolic("80")
                .healthNotes("good")
                .build();
    }

    public static DailyVitals getDailyVitalsSomeData() {
        return DailyVitals.builder()
                .weight("80")
                .weightType(WeightType.KG)
                .muscleMass("30")
                .muscleMassType(WeightType.KG)
                .sleepHours("12")
                .totalAwakeTime("15")
                .sleepAmount(SleepAmount.ENOUGH)
                .sleepQuality(SleepQuality.GOOD)
                .stressAmount(StressAmount.HIGH)
                .build();
    }

    public static DailyVitals getDailyVitalsSleepHours() {
        return DailyVitals.builder()
                .sleepHours("30")
                .build();
    }
    public static DailyVitals getDailyVitalsWater() {
        return DailyVitals.builder()
                .water("120")
                .build();
    }
    public static DailyVitals getDailyVitalsBodyFat() {
        return DailyVitals.builder()
                .bodyFat("100")
                .build();
    }
    public static DailyVitals getDailyVitalsCalories() {
        return DailyVitals.builder()
                .caloriesConsumed("25000")
                .build();
    }
}
