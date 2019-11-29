/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.controller;

import id.giansar.demo.model.Department;
import id.giansar.demo.model.Division;
import id.giansar.demo.service.IEmployeeManagement1Service;
import id.giansar.demo.service.IEmployeeManagement2Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author giansar pratiknya
 */
@Controller
public class ApplicationWebController {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationWebController.class);

    IEmployeeManagement1Service employeeManagement1Service;
    IEmployeeManagement2Service employeeManagement2Service;

    public ApplicationWebController(IEmployeeManagement1Service employeeManagement1Service, IEmployeeManagement2Service employeeManagement2Service) {
        this.employeeManagement1Service = employeeManagement1Service;
        this.employeeManagement2Service = employeeManagement2Service;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        LOG.info("Index");
        List<Department> departments = employeeManagement1Service.getDepartments();
        List<Division> divisions = employeeManagement2Service.getDivisions();
        model.addAttribute("departments", departments);
        model.addAttribute("divisions", divisions);
        return "index";
    }
}
