package com.ziomson.spring_webflux_firstapp.Repository;

import com.ziomson.spring_webflux_firstapp.Entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

}
