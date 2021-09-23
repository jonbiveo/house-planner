package com.techelevator.dao;

import com.techelevator.model.Plan;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

public interface PlanDao {
    List<Plan> getPlansByUser(Principal principal);
    Plan getPlanByPlanId(int id, Principal principal);
    void createNewPlan(Plan newPlan);
}
