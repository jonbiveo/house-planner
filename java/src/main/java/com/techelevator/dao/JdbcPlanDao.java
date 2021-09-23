package com.techelevator.dao;

import com.techelevator.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcPlanDao implements PlanDao{
    @Autowired
    JdbcUserDao userDao;

    private JdbcTemplate jdbcTemplate;

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
        String sql = "INSERT INTO plans (user_id, plan_name, house_type, city, state, size) "
                + "values (?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, newPlan.getUserId(), newPlan.getPlanName(), newPlan.getHouseType(), newPlan.getCity(), newPlan.getState(),
                newPlan.getSize());
    }

    private Plan mapResultToPlan(SqlRowSet result) {
        Plan plan = new Plan();

        plan.setPlanId(result.getInt("plan_id"));
        plan.setUserId(result.getInt("user_id"));
        plan.setPlanName(result.getString("plan_name"));
        plan.setHouseType(result.getString("house_type"));
        plan.setCity(result.getString("city"));
        plan.setState(result.getString("state"));
        plan.setSize(result.getInt("size"));

        return plan;
    }

}
