package com.howtodoinjava.demo.service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.dto.EmplDto;
import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.model.Room;
import com.howtodoinjava.demo.model.Student;
import com.howtodoinjava.demo.repository.EmployeeRepository;
import com.howtodoinjava.demo.repository.RoomRepository;
import com.howtodoinjava.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<EmplDto> getAllEmployees() {
        return repository.findAll().stream()
                .map(el -> new EmplDto(el.getFirstName(), el.getLastName()))
                .collect(toList());
    }

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Employee getByUsernameEmail(final String username, final String email) {
        return repository.findOneByFirstNameAndEmail(username, email);
    }


    public Employee getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee = repository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException {
        Optional<Employee> employee = repository.findById(entity.getId());

        if (employee.isPresent()) {
            Employee newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee = repository.findById(id);

        if (employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}