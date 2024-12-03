package com.ffzu.request;

import lombok.Data;
import org.springframework.lang.NonNull;
import java.util.List;

@Data
public class UserRangeAndDateRange {

    @NonNull
    private List<String> userIds;

    @NonNull
    private Integer startYear;

    @NonNull
    private Integer startMonth;

    @NonNull
    private Integer endYear;

    @NonNull
    private Integer endMonth;


}
