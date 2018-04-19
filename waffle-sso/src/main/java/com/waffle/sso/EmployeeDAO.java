package com.waffle.sso;

import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public class EmployeeDAO {
    public EmployeeDTO createNewEmployee() {
        return new EmployeeDTO();
    }
}
