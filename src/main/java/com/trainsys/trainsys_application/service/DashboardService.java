package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.DashboardResponse;

public interface DashboardService {
    DashboardResponse getDashboardData(UserEntity user);
}
