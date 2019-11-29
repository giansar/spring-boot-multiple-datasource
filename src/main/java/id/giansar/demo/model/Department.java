/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author giansar pratiknya
 */
@Data
public class Department {

    private String departmentId;
    private String description;
    private String userUpdated;
    private Date datetimeUpdated;
}
