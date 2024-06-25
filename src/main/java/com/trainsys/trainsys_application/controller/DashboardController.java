package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.DashboardResponse;
import com.trainsys.trainsys_application.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dashboard")
@RestController
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public ResponseEntity<DashboardResponse> getDashboard(@AuthenticationPrincipal UserEntity user) {
        DashboardResponse dashboardResponse = dashboardService.getDashboardData(user);
        return new ResponseEntity<>(dashboardResponse, HttpStatus.OK);
    }
}
