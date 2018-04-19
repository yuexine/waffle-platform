package com.waffle.sso;

import org.springframework.context.ApplicationEvent;

/**
 * @author yuexin
 */
public class EmployeeEvent extends ApplicationEvent {

    private String eventType;

    private EmployeeDTO employee;

    public EmployeeEvent(Object source) {
        super(source);
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
