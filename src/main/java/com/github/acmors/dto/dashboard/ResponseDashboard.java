package com.github.acmors.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDashboard {

    private Long totalStudyMinutes;
    private Double totalStudyHours;
    private Long totalSessions;
    private Long studiedDaysInMonth;
    private Long todaySessions;
}
