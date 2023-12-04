package service;

import exeption.EmployeeAlreadyExistExeption;
import exeption.EmployeeNotFoundExeption;
import exeption.InvalidNameExeption;
import model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> storage = new HashMap<>();
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {
        validateNames(firstName, lastName);

        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                departmentId
        );
        if (storage.containsKey(getKey(firstName, lastName))){
            throw new EmployeeAlreadyExistExeption("Employee "+firstName+" "+lastName+" already exists");

        }
        storage.put(getKey(firstName, lastName), employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validateNames(firstName, lastName);
        if (!storage.containsKey(getKey(firstName, lastName))){
            throw new EmployeeNotFoundExeption("Employee "+firstName+" "+lastName+" not found");

        }
        return storage.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validateNames(firstName, lastName);
        if (!storage.containsKey(getKey(firstName, lastName))){
            throw new EmployeeNotFoundExeption("Employee "+firstName+" "+lastName+" not found");

        }
        return storage.get(getKey(firstName, lastName));
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(storage.values());
    }
    private String getKey(String firstName, String lastName) {
        return (firstName+"_"+lastName).toLowerCase();
    }

    private void validateNames(String... names) {
        for (String name: names) {
            if (!StringUtils.isAlpha(name)) {
                throw new InvalidNameExeption(name + " - wrong symbols");
            }
        }
    }
}
