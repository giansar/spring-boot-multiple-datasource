/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.repository;

import id.giansar.demo.model.Department;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author giansar pratiknya
 */
@Repository
public class EmployeeRepository1 implements IEmployeeRepository1 {

    @Autowired
    @Qualifier("jdbcTemplateFirstDS")
    NamedParameterJdbcTemplate jdbcTemplate1;

    @Override
    public List<Department> findAllDepartments() {
        String sql = "SELECT * FROM t_department";
        return jdbcTemplate1.query(sql, (ResultSet rs, int rowNum) -> {
            Department department = new Department();
            department.setDatetimeUpdated(rs.getDate("datetime_updated"));
            department.setDescription(rs.getString("description"));
            department.setDepartmentId(rs.getString("department_id"));
            department.setUserUpdated(rs.getString("user_updated"));
            return department;
        });
    }
}
