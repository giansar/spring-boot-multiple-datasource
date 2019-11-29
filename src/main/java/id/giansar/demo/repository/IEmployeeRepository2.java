/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.repository;

import id.giansar.demo.model.Division;
import java.util.List;

/**
 *
 * @author giansar pratiknya
 */
public interface IEmployeeRepository2 {

    public List<Division> findAllDivisions();
}
