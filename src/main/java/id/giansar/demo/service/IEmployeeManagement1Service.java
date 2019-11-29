/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.service;

import id.giansar.demo.model.Department;
import java.util.List;

/**
 *
 * @author giansar pratiknya
 */
public interface IEmployeeManagement1Service {

    public List<Department> getDepartments();
}
