package net.javaguides.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")


public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
        public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
            EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }
}
