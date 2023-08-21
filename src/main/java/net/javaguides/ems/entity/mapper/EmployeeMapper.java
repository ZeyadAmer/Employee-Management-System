package net.javaguides.ems.entity.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.employee;


public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(employee employee){
        return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail()
        );
    }
   public static employee mapToemployee(EmployeeDto EmployeeDto){
 return new employee(
        EmployeeDto.getId(),
        EmployeeDto.getFirstName(),
        EmployeeDto.getLastName(),
        EmployeeDto.getEmail()
        );
   }
}
