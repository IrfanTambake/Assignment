package com.wowoni.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wowoni.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query("update Employee emp set emp.employeeName =:empName, emp.department = :dept where emp.id =:empId")
	void updateEmployeeData(@Param("empId") Long empId, @Param("empName") String empName, @Param("dept") String dept);

}
