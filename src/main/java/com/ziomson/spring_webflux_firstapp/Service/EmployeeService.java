package com.ziomson.spring_webflux_firstapp.Service;

import com.ziomson.spring_webflux_firstapp.Dto.EmployeeDto;
import com.ziomson.spring_webflux_firstapp.Entity.Employee;
import com.ziomson.spring_webflux_firstapp.Mapper.EmployeeMapper;
import com.ziomson.spring_webflux_firstapp.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {

Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
Mono<Employee> savedEmployee = employeeRepository.save(employee);
return savedEmployee
        .map((employeeEntity)-> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);
        return savedEmployee
                .map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> savedEmployees = employeeRepository.findAll();
        return savedEmployees.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {
        Mono<Employee> employeeToUpdate = employeeRepository.findById(employeeId);
        Mono<Employee> updatedEmployee= employeeToUpdate.flatMap((existingEmployee)-> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());

            return employeeRepository.save(existingEmployee);
             });
        return updatedEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
