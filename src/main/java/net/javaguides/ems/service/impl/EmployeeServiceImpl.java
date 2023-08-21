package net.javaguides.ems.service.impl;

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
}
