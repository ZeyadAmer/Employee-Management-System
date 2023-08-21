package net.javaguides.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.employee;
import net.javaguides.ems.entity.exception.ResourceNotFoundException;
import net.javaguides.ems.entity.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        employee employee = EmployeeMapper.mapToemployee(employeeDto);
        employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("There is no Employee with this id" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<employee> employees =employeeRepository.findAll();
       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("There is no Employee with this id" + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }


 
}
