package models;

import enums.ActivityType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Report {
    private String date;
    private String dateEnd;
    private ActivityType activityType;
}
