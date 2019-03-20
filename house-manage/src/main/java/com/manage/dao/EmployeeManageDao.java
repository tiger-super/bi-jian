package com.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.Employee;
import com.house.entity.Page;

@Repository
public interface EmployeeManageDao {
	public Employee ifExistEmployee(Employee employee);

	public int insertEmployee(Employee employee);

	public List<Employee> selectAllEmployee(Page page);
	
	public int selectTotalEmployee();
	
	public int updateEmployeePassword(Employee employee);
	
	public Employee quaryEmployeeFromEmployeeId(String employeeId);
}
