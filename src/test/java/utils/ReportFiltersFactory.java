package utils;

import enums.ActivityType;
import models.Report;


public class ReportFiltersFactory {
    public static Report getReportFilters() {
        return Report.builder()
                .date("8/1/2022")
                .dateEnd("8/31/2022")
                .activityType(ActivityType.BIKE_TIME_TRIAL)
                .build();
    }
}
