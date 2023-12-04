package service;

import exeption.InvalidNameExeption;
import model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> storage = new HashMap<>();
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {
        validateNames(firstName, lastName);

        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }

    private void validateNames(String... names) {
        for (String name: names) {
            if (!StringUtils.isAlpha(name)) {
                throw new InvalidNameExeption(name + " - wrong symbols");
            }
        }
    }
}
