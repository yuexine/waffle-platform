package com.waffle.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeManager employeeManager;

    @GetMapping("/em")
    public String createNewEmployee() {
        employeeManager.createNewEmployee();
        return "ok";
    }
}
