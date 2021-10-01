package com.techelevator.dao;

import com.techelevator.model.Design;
import com.techelevator.model.Plan;
import com.techelevator.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JdbcPlanDao implements PlanDao{
    @Autowired
    JdbcUserDao userDao;

    private JdbcTemplate jdbcTemplate;
    private Integer newId;

    public JdbcPlanDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Plan> getPlansByUser(Principal principal){
        List<Plan> planList= new ArrayList<>();

        String sql = "SELECT * FROM plans WHERE user_id = (SELECT user_id FROM users WHERE username = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName());
        while(results.next()){
            planList.add(mapResultToPlan(results));
        }
        return  planList;
    }

    @Override
    public Plan getPlanByPlanId(int id, Principal principal){
        Plan plan = new Plan();
        String sql = "SELECT * FROM plans WHERE user_id = (SELECT user_id FROM users WHERE username = ?) and plan_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName(), id);
        if(results.next()){
            plan = mapResultToPlan(results);
        }
        return  plan;
    }

    @Override
    public void createNewPlan(Plan newPlan) {
        String sql = "INSERT INTO plans (user_id, plan_name, city, state, house_type, square_footage, price_range_lower, price_range_upper) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?) RETURNING plan_id";

        this.newId = jdbcTemplate.queryForObject(sql, Integer.class, newPlan.getUserId(), newPlan.getPlanName(), newPlan.getCity(), newPlan.getState(), newPlan.getHouseType(),
                newPlan.getSquareFootage(), newPlan.getPriceRangeLower(), newPlan.getPriceRangeUpper());

        System.out.println(this.newId);

    }

    @Override
    public void createNewRooms(Room room) {
        String sql = "INSERT INTO rooms(plan_id, floor, room_type, room_size)" +
                "values (?, ?, ?, ?)";
        System.out.println(this.newId);

        jdbcTemplate.update(sql, this.newId, room.getFloor(), room.getRoomType(), room.getRoomSize());
    }

    @Override
    public void createRoomDesign(Design design) {
        String sql = "INSERT INTO design(plan_id, floor_one_layout, doors, staircase, bathroom_cabinets, bathroom_tub, kitchen_cabinets, kitchen_island, " +
                "kitchen_floor, living_room_floor, bedroom_floor, bathroom_floor, entertainment_room_floor, spare_room_floor, staircase_floor)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, this.newId, design.getFloorOneLayout(), design.getDoors(), design.getStaircase(), design.getBathroomCabinets(), design.getBathroomTub(), design.getKitchenCabinets(),
        design.getKitchenIsland(), design.getKitchenFloor(), design.getLivingRoomFloor(), design.getBedroomFloor(), design.getBathroomFloor(), design.getEntertainmentRoomFloor(),
        design.getSpareRoomFloor(), design.getStaircaseFloor());
    }

    @Override
    public void deletePlan(int id) {
        String sql = "DELETE FROM rooms WHERE plan_id = ?; "+
                    "DELETE FROM design WHERE plan_id = ?; "+
                    "DELETE FROM plans WHERE plan_id = ?;";
        jdbcTemplate.update(sql, id, id, id);
    }


    private Plan mapResultToPlan(SqlRowSet result) {
        Plan plan = new Plan();

        plan.setPlanId(result.getInt("plan_id"));
        plan.setUserId(result.getInt("user_id"));
        plan.setPlanName(result.getString("plan_name"));
        plan.setHouseType(result.getString("house_type"));
        plan.setCity(result.getString("city"));
        plan.setState(result.getString("state"));
        plan.setSquareFootage(result.getInt("square_footage"));
        plan.setPriceRangeLower(result.getDouble("price_range_lower"));
        plan.setPriceRangeUpper(result.getDouble("price_range_upper"));

        return plan;
    }

}
