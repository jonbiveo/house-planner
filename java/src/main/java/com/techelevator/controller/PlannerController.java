package com.techelevator.controller;


import com.techelevator.dao.PlanDao;
import com.techelevator.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class PlannerController {
    @Autowired
    PlanDao planDao;

    @GetMapping("/plans")
    public List<Plan> getAllPlans(){
        List<Plan> allPlans = planDao.getPlansByUser();
        return allPlans;
    }

    @PostMapping("/newPlan")
    public void createPlan(@RequestBody Plan newPlan){
        planDao.createNewPlan(newPlan);
        System.out.println("User ID "+newPlan.getUserId() + " created a new plan");
    }
}
