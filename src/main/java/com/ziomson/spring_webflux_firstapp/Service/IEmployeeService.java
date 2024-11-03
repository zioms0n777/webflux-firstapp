package com.ziomson.spring_webflux_firstapp.Service;

import com.ziomson.spring_webflux_firstapp.Dto.EmployeeDto;
import com.ziomson.spring_webflux_firstapp.Entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {

    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String employeeId);
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId);

    Mono<Void> deleteEmployee(String employeeId);

}
