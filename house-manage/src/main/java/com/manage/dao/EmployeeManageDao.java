package com.manage.dao;

import org.springframework.stereotype.Repository;

import com.house.entity.Employee;
@Repository
public interface EmployeeManageDao {
	Employee ifExistEmployee(Employee employee);
}
