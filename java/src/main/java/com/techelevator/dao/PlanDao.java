package com.techelevator.dao;

import com.techelevator.model.Design;
import com.techelevator.model.Plan;
import com.techelevator.model.Room;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface PlanDao {
    List<Plan> getPlansByUser(Principal principal);
    Plan getPlanByPlanId(int id, Principal principal);
    void createNewPlan(Plan newPlan);
    void createNewRooms(Room room);
    void createRoomDesign(Design design);
    void deletePlan(int id);
}
