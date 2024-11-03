package com.ziomson.spring_webflux_firstapp.Controller;

import com.ziomson.spring_webflux_firstapp.Dto.EmployeeDto;
import com.ziomson.spring_webflux_firstapp.Repository.EmployeeRepository;
import com.ziomson.spring_webflux_firstapp.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor

public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private EmployeeService employeeService;


    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String EmployeeId) {
        return employeeService.getEmployee(EmployeeId);
    }
    @GetMapping("/all")
    public Flux<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();

    }

    @PutMapping("/update/{id}")
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable ("id") String employeeId) {
        return employeeService.updateEmployee(employeeDto, employeeId);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId) {
     return employeeService.deleteEmployee(employeeId);
    }
}
