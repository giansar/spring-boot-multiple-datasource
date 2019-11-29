/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.repository;

import id.giansar.demo.model.Division;
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
public class EmployeeRepository2 implements IEmployeeRepository2 {

    @Autowired
    @Qualifier("jdbcTemplateSecondDS")
    NamedParameterJdbcTemplate jdbcTemplate2;

    @Override
    public List<Division> findAllDivisions() {
        String sql = "SELECT * FROM t_division";
        return jdbcTemplate2.query(sql, (ResultSet rs, int rowNum) -> {
            Division division = new Division();
            division.setDatetimeUpdated(rs.getDate("datetime_updated"));
            division.setDescription(rs.getString("description"));
            division.setDivisionId(rs.getString("division_id"));
            division.setUserUpdated(rs.getString("user_updated"));
            return division;
        });
    }
}
