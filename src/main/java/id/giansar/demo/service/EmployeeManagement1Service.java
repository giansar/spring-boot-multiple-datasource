/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.service;

import id.giansar.demo.model.Department;
import id.giansar.demo.repository.IEmployeeRepository1;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author giansar pratiknya
 */
@Service
public class EmployeeManagement1Service implements IEmployeeManagement1Service {

    private final IEmployeeRepository1 employeeRepository1;

    public EmployeeManagement1Service(IEmployeeRepository1 employeeRepository1) {
        this.employeeRepository1 = employeeRepository1;
    }

    @Override
    public List<Department> getDepartments() {
        return employeeRepository1.findAllDepartments();
    }
}
