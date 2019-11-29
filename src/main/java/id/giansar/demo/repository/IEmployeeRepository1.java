/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.repository;

import id.giansar.demo.model.Department;
import java.util.List;

/**
 *
 * @author giansar pratiknya
 */
public interface IEmployeeRepository1 {

    public List<Department> findAllDepartments();
}
