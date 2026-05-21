package com.github.acmors.service;

import com.github.acmors.dto.dashboard.ResponseDashboard;
import com.github.acmors.entities.StudySession;
import com.github.acmors.exceptions.ResourceNotFoundException;
import com.github.acmors.repository.StudySessionRepository;
import com.github.acmors.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserAccountRepository userRepository;
    private final StudySessionRepository studyRepository;



    public ResponseDashboard getSummary(Long userId){
        validateUserExists(userId);

        StudySession.Status doneStatus = StudySession.Status.DONE;

        Long totalMinutes = studyRepository.sumTotalMinutesByUserId(userId, doneStatus);
        Long totalSessions = studyRepository.countDoneSessionsByUserId(userId, doneStatus);
        LocalDate today = LocalDate.now();

        LocalDateTime startOfMonth = today
                .withDayOfMonth(1)
                .atStartOfDay();

        LocalDateTime endOfMonth = today
                .withDayOfMonth(today.lengthOfMonth())
                .atTime(23,59,59);

        Long studiedDaysInMonth = studyRepository.countStudiedDaysInPeriod(
                userId,
                doneStatus,
                startOfMonth,
                endOfMonth
        );

        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23,59,59);

        Long todaySession = studyRepository.countTodaySessions(
                userId,
                doneStatus,
                startOfDay,
                endOfDay
        );

        Double totalHours = Math.round((totalMinutes / 60.0) * 100.0) / 100.0;

        return new ResponseDashboard(
                totalMinutes,
                totalHours,
                totalSessions,
                studiedDaysInMonth,
                todaySession
        );
    }

    private void validateUserExists(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found.");
        }
    }
}
