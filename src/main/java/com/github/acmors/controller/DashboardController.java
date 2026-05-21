package com.github.acmors.controller;

import com.github.acmors.dto.dashboard.ResponseDashboard;
import com.github.acmors.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<ResponseDashboard> getSummary(@RequestParam Long userId) {
        ResponseDashboard response = dashboardService.getSummary(userId);
        return ResponseEntity.ok(response);
    }
}
