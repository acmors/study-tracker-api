package com.github.acmors.repository;

import com.github.acmors.entities.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

    @Query("""
                SELECT COALESCE(SUM(s.durationMinutes), 0)
                FROM StudySession s
                WHERE s.user.id = :userId
                AND s.status = :status
    """)
    Long sumTotalMinutesByUserId(Long userId, StudySession.Status status);


    @Query("""
            SELECT COUNT(s)
            FROM StudySession s
            WHERE s.user.id = :userId
            AND s.status = :status
    """)
    Long countDoneSessionsByUserId(Long userId, StudySession.Status status);

    @Query("""
            SELECT COUNT(DISTINCT FUNCTION('DATE', s.studiedAt))
            FROM StudySession s
            WHERE s.user.id = :userId
            AND s.status = :status
            AND s.studiedAt BETWEEN :startDate AND :endDate
    """)
    Long countStudiedDaysInPeriod(
            Long userId,
            StudySession.Status status,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    @Query("""
            SELECT COUNT(s)
            FROM StudySession s
            WHERE s.user.id = :userId
            AND s.status = :status
            AND s.studiedAt BETWEEN :startOfDay AND :endOfDay
    """)
    Long countTodaySessions(
            Long userId,
            StudySession.Status status,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay
    );
}
