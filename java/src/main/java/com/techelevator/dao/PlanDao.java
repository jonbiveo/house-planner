package com.techelevator.dao;

import com.techelevator.model.Plan;

import java.util.List;

public interface PlanDao {
    List<Plan> getPlansByUser();
    void createNewPlan(Plan newPlan);
}
