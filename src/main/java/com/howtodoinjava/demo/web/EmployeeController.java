package com.howtodoinjava.demo.web;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.dto.BaseRequestDto;
import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(final EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> getAllEmployees() {
        service.getRoom(1L);

        service.getStudent(1L);
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.POST)
    public ResponseEntity<?> getByFirstNameAndEmail(@RequestBody BaseRequestDto dto) {
        return ResponseEntity.ok(service.getByUsernameEmail(dto.getName(), dto.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Employee entity = service.getEmployeeById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee)
            throws RecordNotFoundException {
        Employee updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}