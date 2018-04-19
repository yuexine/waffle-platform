package com.waffle.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author yuexin
 */
@Service
public class EmployeeManager implements ApplicationEventPublisherAware {

    @Autowired
    private EmployeeDAO dao;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public EmployeeDTO createNewEmployee() {

        EmployeeDTO employee =  dao.createNewEmployee();

        publisher.publishEvent(new EmployeeEvent(this));

        return employee;
    }

    @EventListener(EmployeeEvent.class)
    public void lis(EmployeeEvent employeeEvent) {
        System.out.println("ok");
    }

    @EventListener(EmployeeEvent.class)
    public void lis2(EmployeeEvent employeeEvent) {
        System.out.println("ok2");
    }


}
