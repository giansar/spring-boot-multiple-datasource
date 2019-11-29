/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.service;

import id.giansar.demo.model.Division;
import id.giansar.demo.repository.IEmployeeRepository2;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author giansar pratiknya
 */
@Service
public class EmployeeManagement2Service implements IEmployeeManagement2Service {

    private final IEmployeeRepository2 employeeRepository2;

    public EmployeeManagement2Service(IEmployeeRepository2 employeeRepository2) {
        this.employeeRepository2 = employeeRepository2;
    }

    @Override
    public List<Division> getDivisions() {
        return employeeRepository2.findAllDivisions();
    }
}
