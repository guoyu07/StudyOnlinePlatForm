package indi.jack.testservice;

import org.springframework.validation.annotation.Validated;

import indi.jack.testEntity.Employee;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface EmployeeService
{
    public void saveEmployee(
            @NotNull(message = "{validate.employeeService.saveEmployee}")
            @Valid Employee employee
    );

    public Employee getEmployee(
            @Min(value = 1L,
                    message = "{validate.employeeService.getEmployee.id}") long id
    );

    @NotNull(message="未获取到用户数据")
    public List<Employee> getAllEmployees();
}
